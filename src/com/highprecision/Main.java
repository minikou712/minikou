package com.highprecision;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private BigInteger add(BigInteger num1, BigInteger num2) {
        return num1.add(num2);
    }

    private BigInteger subtract(BigInteger num1, BigInteger num2) {
        return num1.subtract(num2);
    }

    private BigInteger multiply(BigInteger num1, BigInteger num2) {
        return num1.multiply(num2);
    }

    private BigInteger divide(BigInteger num1, BigInteger num2) {
        if (num2.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("除数不能为零！");
        }
        return num1.divide(num2);
    }

    private BigInteger mod(BigInteger num1, BigInteger num2) {
        if (num2.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("除数不能为零！");
        }
        return num1.mod(num2);
    }

    //2.BigDecimal类  高精度运算data类型
    //作用：提供了对任意精度的十进制数进行运算的支持，适用于需要高精度计算的场景。
    //使用方法：创建一个BigDecimal对象，传入字符串或double类型的数值，然后可以使用add、subtract、multiply、divide等方法进行运算。


    //1.使用BigInteger类  计算快速幂
    //作用：提供了对任意精度的整数进行运算的支持，适用于需要高精度计算的场景。
    private BigInteger pow(BigInteger base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("指数不能为负数！");
        }
        return base.pow(exponent);
    }   

    //2.使用BigDecimal类  计算快速幂
    private BigDecimal pow(BigDecimal base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("指数不能为负数！");
        }
        return base.pow(exponent);
    }



    private BigDecimal powD(BigDecimal base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("指数不能为负数！");
        }
        return base.pow(exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 选择计算类型 高精度加法，减法，乘法，除法
        System.out.println("请输入计算类型：1.加法 2.减法 3.乘法 4.除法");
        int type = scanner.nextInt();
        System.out.println("请输入两个高精度数：");
        BigInteger num1 = scanner.nextBigInteger();
        BigInteger num2 = scanner.nextBigInteger();
        Main main = new Main();
        switch (type) {
            case 1:
                System.out.println("结果为：" + main.add(num1, num2));
                break;
            case 2:
                System.out.println("结果为：" + main.subtract(num1, num2));
                break;
            case 3:
                System.out.println("结果为：" + main.multiply(num1, num2));
                break;
            case 4:
                System.out.println("结果为：" + main.divide(num1, num2) + " 余数为：" + main.mod(num1, num2));
                break;
            default:
                System.out.println("无效的计算类型！");
        }
        scanner.close();
    }
}
