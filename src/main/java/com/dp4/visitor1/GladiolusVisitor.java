package com.dp4.visitor1;

/**
 * Created by Administrator on 2017/6/15.
 */
public class GladiolusVisitor implements Visitor{
    public void visit(GladiolusConcreteElement gladiolus) {
        System.out.println(this.getClass().getSimpleName() + " access " + gladiolus.getClass().getSimpleName());
    }

    public void visit(ChrysanthemumConreteElement chrysanthemum) {
        System.out.println(this.getClass().getSimpleName() + " access " + chrysanthemum.getClass().getSimpleName());
    }
}
