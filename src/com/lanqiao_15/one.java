package com.lanqiao_15;

import java.math.BigInteger;

/**
 * 小蓝和朋友们在玩一个报数游戏。由于今年是 2024年，他们决定要从小到大轮流报出是 20或 24 倍数的正整数。
 * 前10个被报出的数是：20,24,40,48,60,72,80,96,100,120 请问第
 * 202420242024 个被报出的数是多少? 答案提交
 * 
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 **/

public class one {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("202420242024");
        BigInteger b = a.multiply(BigInteger.valueOf(120L));    //此处不能先除否则会舍去小数，精度不够
        System.out.println(b.divide(BigInteger.valueOf(10L)));

        BigInteger c = new BigInteger("202420242024");
        BigInteger d = c.divide(BigInteger.valueOf(2));
        System.out.println(d.multiply(BigInteger.valueOf(24L)));

        //字符型构造
        BigInteger bigInt = new BigInteger("12345678901234567890000000000000000000");
        System.out.println(bigInt.multiply(bigInt)); // 输出：12345678901234567890
    }
}
