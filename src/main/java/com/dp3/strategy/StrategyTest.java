package com.dp3.strategy;

/**
 * Created by dpingxian on 2017/6/12.
 */
public class StrategyTest {
    public static void main(String[] args) {
        String exp1 = "2+8";
        ICalculator cal1 = new Plus();
        int result1 = cal1.calculate(exp1);
        System.out.println(result1);

        String exp2 = "2*8";
        ICalculator cal2 = new Multiply();
        int result2 = cal2.calculate(exp2);
        System.out.println(result2);
    }
}
