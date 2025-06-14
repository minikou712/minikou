package com.pointer.pointer_acwing2816;
import java.util.*;
//判断子序列
/**
 * 给定一个长度为 n
 * 的整数序列 a1,a2,…,an
 * 以及一个长度为 m
 * 的整数序列 b1,b2,…,bm
 * 。
 * 
 * 请你判断 a
 * 序列是否为 b
 * 序列的子序列。
 * 
 * 子序列指序列的一部分项按原有次序排列而得的序列，例如序列 {a1,a3,a5}
 * 是序列 {a1,a2,a3,a4,a5}
 * 的一个子序列。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入序列长度
        int m = scanner.nextInt(); // 输入序列长度
        int a[] = new int[n + 2]; // 序列 A
        int b[] = new int[m + 2]; // 序列 B
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt(); // 输入序列 A 元素
        }
        for (int i = 1; i <= m; i++) {
            b[i] = scanner.nextInt(); // 输入序列 B 元素
        }
        int i = 1, j = 1; // 初始化指针
        while (i<= n && j <= m) { // 遍历序列
            if (a[i] == b[j]) { // 如果相等，移动指针
                i++; // 移动指针
                j++;
            }
            else { // 如果不相等，移动指针 j
                j++; // 移动指针
            }
        }
        if(i > n) { // 如果 i 超过 n，说明 A 是 B 的子序列
            System.out.println("Yes"); // 输出结果
        } else { // 否则不是子序列
            System.out.println("No"); // 输出结果
        }
        scanner.close(); // 关闭扫描器
    }

}
