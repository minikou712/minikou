package com.dp.多重背包问题;

import java.util.Scanner;

public class Main {
    // 多重背包问题的动态规划解法
    // dp[i][j]表示前i个物品放入容量为j的背包的最大价值
    // 与完全背包的区别在于多重背包对于每个物品只能选择放入有限数量的物品
    // 完全背包可以选择放入多个相同的物品
    // 01背包对于每个物品只能选择放入一次，而完全背包可以选择放入多次

    private static class item {
        int w; // 物品重量
        int c; // 物品价值
        int s; // 物品数量

        public item(int w, int c, int s) {
            this.w = w;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 物品数量
        int v = scanner.nextInt(); // 背包容量

        item[] items = new item[n + 1]; // 物品数组
        for (int i = 1; i <= n; i++) {
            int w = scanner.nextInt(); // 物品重量
            int c = scanner.nextInt(); // 物品价值
            int s = scanner.nextInt(); // 物品数量
            items[i] = new item(w, c, s); // 创建物品对象并存入数组
        }
        int[][] dp = new int[n + 1][v + 1]; // dp[i][j]表示前i个物品放入容量为j的背包的最大价值
        for (int i = 1; i <= n; i++) // 枚举物品
        {
            for (int j = 0; j <= v; j++) // 枚举背包容量
            {
                dp[i][j] = dp[i - 1][j]; // 初始化为不放入当前物品的最大价值
                for (int k = 0; k <= items[i].s && k + items[i].w <= j; k++) // 枚举放入物品的数量
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * items[i].w] + k * items[i].c); // 放入背包和不放入背包的最大价值
                }
            }
        }
        System.out.println(dp[n][v]); // 输出最大价值   
        scanner.close(); // 关闭扫描器
    }
}
