package com.dp4.visitor3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public class ObjectStructure {
    private List<Flower> flowers;

    public ObjectStructure() {
        flowers = new ArrayList<Flower>();
    }

    public void attach(Flower flower){
        flowers.add(flower);
    }

    public void detach(Flower flower){
        flowers.remove(flower);
    }

    public void accept(Visitor visitor){
        for (Flower flower : flowers) {
            flower.accept(visitor);
        }
    }
}
