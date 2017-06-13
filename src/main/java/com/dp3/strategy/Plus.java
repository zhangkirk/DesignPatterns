package com.dp3.strategy;

/**
 * Created by dpingxian on 2017/6/12.
 */
public class Plus extends AbstractCalculator implements ICalculator{
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\+");
        return arrayInt[0]+arrayInt[1];
    }
}
