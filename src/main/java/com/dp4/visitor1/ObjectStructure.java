package com.dp4.visitor1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public class ObjectStructure {
    private final List<FlowerElement> elements = new ArrayList<FlowerElement>();

    public void addElement(final FlowerElement e){
        elements.add(e);
    }

    public void removeElement(final FlowerElement e){
        elements.remove(e);
    }

    public void accept(final Visitor visitor){
        for (final FlowerElement e : elements){
            e.accept(visitor);
        }
    }
}
