package com.bitoperation;

import java.util.*;

public class Main {
    /*
     * 1. Integer 类
     * Integer 是 int 类型的封装类，提供了许多静态方法和常量，常用于整数的转换、比较和位操作。
     *
     * 常用静态方法：
     * - parseInt(String s): 将字符串解析为整数。
     * - toString(int i): 将整数转换为字符串。
     * - toBinaryString(int i): 将整数转换为二进制字符串。
     * - bitCount(int i): 计算整数的二进制表示中 1 的个数。
     * - compare(int x, int y): 比较两个整数的大小，返回 -1、0 或 1。
     * - valueOf(String s): 将字符串转换为 Integer 对象。
     *
     * 常用成员方法：
     * - intValue(): 返回 Integer 对象的 int 值。
     *
     * 常量：
     * - Integer.MAX_VALUE: int 类型的最大值（2^31 - 1）。
     * - Integer.MIN_VALUE: int 类型的最小值（-2^31）。
     */
    private void integer() {
        int b = 20;
        System.out.println(Integer.MAX_VALUE); // 输出 int 类型的最大值
        System.out.println(Integer.MIN_VALUE); // 输出 int 类型的最小值
        System.out.println(Integer.toBinaryString(b)); // 输出 b 的二进制字符串表示
        System.out.println(Integer.toString(b)); // 输出 b 的字符串表示
        String str = "123";
        System.out.println(Integer.parseInt(str)); // 将字符串解析为整数
        Integer c = Integer.valueOf(str); // 将字符串转换为 Integer 对象
        String str2 = c.toString(); // 将 Integer 对象转换为字符串
    }
    /*
     * 2. Double 类
     * Double 是 double 类型的封装类，常用于浮点数的转换和比较。
     *
     * 常用静态方法：
     * - parseDouble(String s): 将字符串解析为双精度浮点数。
     * - toString(double d): 将双精度浮点数转换为字符串。
     * - compare(double x, double y): 比较两个浮点数的大小，返回 -1、0 或 1。
     * - isNaN(double d): 检查一个数是否为 NaN（非数字）。
     * - isInfinite(double d): 检查一个数是否为无穷大。
     *
     * 常用成员方法：
     * - doubleValue(): 返回 Double 对象的 double 值。
     *
     * 常量：
     * - Double.MAX_VALUE: double 类型的最大值。
     * - Double.MIN_VALUE: double 类型的最小正值。
     * - Double.NaN: 表示非数字。
     * - Double.POSITIVE_INFINITY: 正无穷大。
     * - Double.NEGATIVE_INFINITY: 负无穷大。
     */

    private void doubleType() {
        double d = 20.0;
        System.out.println(Double.MAX_VALUE); // 输出 double 类型的最大值
        System.out.println(Double.MIN_VALUE); // 输出 double 类型的最小正值
        System.out.println(Double.isNaN(d)); // 检查 d 是否为 NaN
        System.out.println(Double.isInfinite(d)); // 检查 d 是否为无穷大
        String str = "123.45";
        System.out.println(Double.parseDouble(str)); // 将字符串解析为双精度浮点数
        Double c=Double.parseDouble(str); // 将字符串转换为 Double 对象
        c.toString(); // 将 Double 对象转换为字符串
        System.out.println(c.toString()); // 将 d 转换为字符串
    }
    /*
     * 4. Long 类
     * Long 是 long 类型的封装类，常用于处理大整数。
     *
     * 常用静态方法：
     * - parseLong(String s): 将字符串解析为长整数。
     * - toString(long l): 将长整数转换为字符串。
     * - compare(long x, long y): 比较两个长整数的大小，返回 -1、0 或 1。
     * - valueOf(String s): 将字符串转换为 Long 对象。
     *
     * 常用成员方法：
     * - longValue(): 返回 Long 对象的 long 值。
     *
     * 常量：
     * - Long.MAX_VALUE: long 类型的最大值（2^63 - 1）。
     * - Long.MIN_VALUE: long 类型的最小值（-2^63）。
     */

    public static void main(String[] args) {
        Main main = new Main();
        main.integer(); // 调用 integer 方法
        main.doubleType(); // 调用 doubleType 方法

    }

}