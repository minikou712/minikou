package com.pj;

import java.util.Scanner;

public class Main {

    private static int[] count = new int[1000001]; // 计数数组，假设元素范围在0到1000000之间

    private static void majorityElement(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            count[a[i]]++; // 统计每个元素出现的次数
        }
        int max = 0; // 记录数组中出现次数最多的数
        for (int i = 0; i < n; i++) {  
            if (count[a[i]] > count[max]) {
                max = a[i];  
            }
        }
        if (count[max] > n / 2) {
            System.out.println(max); // 输出主元素
        }
        else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // 找主元素函数
        majorityElement(a, n);

        scanner.close(); // 关闭扫描器
    }
}