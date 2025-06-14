package com.difference;

import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int a[] = new int[100005];
    public static int s[] = new int[100005];

    private static void buildDifference() {
        for (int i = 1; i <= n; i++) {
            a[i] = s[i] - s[i - 1];
        }
    }
    private static void prefixAnd() {
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 数组长度
        m = scanner.nextInt(); // 操作次数
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt(); // 输入数组元素
        }
        buildDifference(); // 构建差分数组
        for (int i = 1; i <= m; i++) {
            int l = scanner.nextInt(); // 左边界
            int r = scanner.nextInt(); // 右边界
            int c = scanner.nextInt(); // 增加的值
            a[l]+= c;
            a[r + 1] -= c;
        }
        prefixAnd();// 计算前缀和
        for (int i = 1; i <= n; i++) {
            System.out.print(s[i] + " "); // 输出结果
        }
        scanner.close(); // 关闭扫描器
    }
}