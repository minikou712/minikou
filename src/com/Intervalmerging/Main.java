package com.Intervalmerging;

import java.util.*;
import java.util.Arrays;
import java.lang.Math;

/**
 * 区间合并
 * 给定 n个区间 [li,ri]，要求合并所有有交集的区间。
 * 
 * 注意如果在端点处相交，也算有交集。
 * 
 * 输出合并完成后的区间个数。
 * 例如：[1,3]
 * 和 [2,6]
 * 可以合并为一个区间 [1,6]
 * 。
 * 
 * Math 类常用方法介绍：
 * 1. 绝对值：
 * - Math.abs(int a)：返回参数的绝对值。
 * 
 * 2. 最大值和最小值：
 * - Math.max(a, b)：返回两个数中的最大值。
 * - Math.min(a, b)：返回两个数中的最小值。
 * 
 * 3. 幂运算：
 * - Math.pow(double a, double b)：返回 a 的 b 次幂。
 * 
 * 4. 平方根：
 * - Math.sqrt(double a)：返回参数的平方根。
 * 
 * 5. 对数运算：
 * - Math.log(double a)：返回自然对数（以 e 为底）。
 * - Math.log10(double a)：返回以 10 为底的对数。
 * 
 * 6. 向上/向下取整：
 * - Math.ceil(double a)：向上取整。
 * - Math.floor(double a)：向下取整。
 * - Math.round(double a)：四舍五入。
 * 
 * 7. 随机数：
 * - Math.random()：返回 [0, 1) 范围内的随机数。
 * 
 * 8. 三角函数：
 * - Math.sin(double a)：正弦。
 * - Math.cos(double a)：余弦。
 * - Math.tan(double a)：正切。
 * - Math.toRadians(double angdeg)：角度转弧度。
 * - Math.toDegrees(double angrad)：弧度转角度。
 * 
 * 9. 取模运算：
 * - Math.floorMod(int x, int y)：计算 x % y，结果始终为非负数。
 * 
 * 10. 符号函数：
 * - Math.signum(double a)：返回参数的符号（正数返回 1.0，负数返回 -1.0，零返回 0.0）。
 * 
 * 11. 指数函数：
 * - Math.exp(double a)：返回 e 的 a 次幂。
 * 
 * 12. 三角函数的反函数：
 * - Math.asin(double a)：反正弦。
 * - Math.acos(double a)：反余弦。
 * - Math.atan(double a)：反正切。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入区间个数
        int a[][] = new int[n + 5][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt(); // 输入区间左端点
            a[i][1] = scanner.nextInt(); // 输入区间右端点
        }
        // 排序区间
        Arrays.sort(a, 0, n - 1, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        }); // 排序区间 注意函数都不包括有边界，左闭右开
        int ans = 0; // 合并后的区间个数
        int current[][] = new int[1][2]; // 当前区间
        current[0][0] = a[0][0]; // 初始化当前区间的左端点
        current[0][1] = a[0][1]; // 初始化当前区间的右端点
        for (int i = 1; i < n; i++) {
            if (current[0][1]< a[i][0]) {
                ans++; // 如果前一个区间的右端点小于当前区间的左端点，则不重叠，合并后的区间个数加1
                current[0][0] = a[i][0]; // 更新当前区间的左端点
                current[0][1] = a[i][1]; // 更新当前区间的右端点
            } else {
                current[0][1]=Math.max(current[0][1],a[i][1]); // 如果重叠，则更新当前区间的右端点为两个区间的右端点的最大值
            }
        }
        ans++; // 最后一个区间也要加1
        System.out.println(ans); // 输出合并后的区间个数
        scanner.close(); // 关闭扫描器
    }

}