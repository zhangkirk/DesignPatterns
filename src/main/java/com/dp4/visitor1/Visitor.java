package com.dp4.visitor1;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface Visitor {
    public void visit(GladiolusConcreteElement gladiolus);

    public void visit(ChrysanthemumConreteElement chrysanthemum);
}
