package com.dp4.visitor1;

/**
 * Created by Administrator on 2017/6/15.
 */
public class Client {
    public static void main(final String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.addElement(new GladiolusConcreteElement());
        os.addElement(new ChrysanthemumConreteElement());

        GladiolusVisitor gVisitor = new GladiolusVisitor();
        ChrysanthemumVisitor chVisitor = new ChrysanthemumVisitor();

        os.accept(gVisitor);
        os.accept(chVisitor);

    }
}
