package com.dp.背包01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 物品数量
        int v = scanner.nextInt(); // 背包容量
        int[] w = new int[n + 1]; // 物品重量
        int[] c = new int[n + 1]; // 物品价值
        int[][] dp = new int[n + 1][v + 1]; // dp[i][j]表示
        //前i个物品放入容量为j的背包的最大价值
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt(); // 物品重量
            c[i] = scanner.nextInt(); // 物品价值
        }
        for (int i = 1; i <= n; i++) // 枚举物品
        {
            for (int j = 0; j <= v; j++) // 枚举背包容量   
            {
                dp[i][j] = dp[i - 1][j]; // 初始化为不放入当前物品的最大价值
                // 枚举放入物品的数量
                if(j>=w[i]) // 如果当前物品的重量小于等于背包容量
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+c[i]); // 放入背包和不放入背包的最大价值
                }

            }
        }
        System.out.println(dp[n][v]); // 输出最大价值
        scanner.close(); // 关闭扫描器
    }
}
