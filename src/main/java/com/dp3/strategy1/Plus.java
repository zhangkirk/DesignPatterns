package com.dp3.strategy1;

/**
 * Created by dpingxian on 2017/6/12.
 */
public class Plus extends AbstractCalculator{
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
