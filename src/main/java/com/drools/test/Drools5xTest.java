package com.drools.test;

import com.drools.compiler.*;
import com.drools.executor.CompilerExecutor;
import com.drools.model.Product;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.drools.core.io.impl.ReaderResource;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ke on 2018/1/28.
 * 知识要点：
 * 1:drools规则
 * 2:drools Global引入调用JAVA
 * 3:velocity模板引擎
 * 4:janino.SimpleCompiler 动态编译
 */
public class Drools5xTest {

    public static void main(String[] args) {
        Drools5xTest test = new Drools5xTest();
        test.executeDrools();
    }

    private void executeDrools() {

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        VelocityEngine velocityEngine = new VelocityEngine();

        Template template = velocityEngine.getTemplate("adk_drools_template.vm");

        StringWriter writer = new StringWriter();
        VelocityContext context = new VelocityContext();
        context.put("viewtest", "System.out.println(\"==viewtes===\");");
        List<String> globalList = new ArrayList<>();
        globalList.add("com.drools.executor.CompilerExecutor compilerExecutor");
        context.put("globalList", globalList);
        context.put("key","test1");


        template.merge(context, writer);
        System.out.println(writer.toString());

        kbuilder.add(new ReaderResource(new StringReader(writer.toString())), ResourceType.DRL);
/*        kbuilder.add(ResourceFactory.newClassPathResource("com/rules/Rules.drl",
                this.getClass()), ResourceType.DRL);*/
        if (kbuilder.hasErrors()) {
            System.out.println(kbuilder.getErrors().toString());
        }
        CompilerExecutor compilerExecutor  = new CompilerExecutor();
        compilerExecutor.add("test1",initClazz());

        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
        // add the package to a rulebase
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        // 将KnowledgePackage集合添加到KnowledgeBase当中
        kbase.addKnowledgePackages(pkgs);

        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        ksession.setGlobal("compilerExecutor",compilerExecutor);
        Product product = new Product();
        product.setType(Product.DIAMOND);
        ksession.insert(product);
        ksession.fireAllRules();
        ksession.dispose();

        System.out.println("The discount for the product " + product.getType()
                + " is " + product.getDiscount() + "%");

      /*  Customer customer = new Customer();
        customer.setName("张三");
        ksession.insert(customer);
        ksession.fireAllRules();
        ksession.dispose();
*/
    }/**/


    private Cinter initClazz() {
        String src = "package com.drools.compiler;\n" +
                "\n" +
//                "import com.drools.compiler.Cinter;\n" +
                "public class Test2 extends Cinter {\n" +
                "\n" +
                "    public void cout() {\n" +
                "        System.out.println(\"==test2==\");\n" +
                "    }\n" +
                "}";
        String className = "com.drools.compiler.Test2";

        Class<Cinter> targetType =  com.drools.compiler.Compiler.compilerJavaCode(className, src);

        Cinter c = null;
        try {
            c = targetType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return c;

    }

}
