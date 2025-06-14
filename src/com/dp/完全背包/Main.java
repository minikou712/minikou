package com.dp.完全背包;

import java.util.Scanner;

public class Main {
    // 完全背包问题的动态规划解法
    // dp[i][j]表示前i个物品放入容量为j的背包的最大价值
    // 与01背包的区别在于完全背包可以放入多个相同的物品
    // 01背包对于每个物品只能选择放入一次，而完全背包可以选择放入多次
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 物品数量
        int v = scanner.nextInt(); // 背包容量\
        int [] w = new int[n + 1]; // 物品重量
        int [] c = new int[n + 1]; // 物品价值
        int[][]dp = new int[n + 1][v + 1]; // dp[i][j]表示前i个物品放入容量为j的背包的最大价值
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt(); // 物品重量
            c[i] = scanner.nextInt(); // 物品价值
        }

        for(int i=1;i<=n;i++) //枚举物品
        {
            for(int j=0;j<=v;j++) //枚举背包容量
            {
                dp[i][j]=dp[i-1][j]; //初始化为不放入当前物品的最大价值
                for(int k=0;k*w[i]<=j;k++) //枚举放入物品的数量
                {
                    //此处为什么是max(dp[i][j],)而不是dp[i][j]=max(dp[i-1][j],)
                    //因为我们要在当前物品的基础上进行更新，而不是在前一个物品的基础上进行更新,所以与01背包不同
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k*w[i]]+k*c[i]); //放入背包和不放入背包的最大价值
                }
            }
        }
        System.out.println(dp[n][v]); //输出最大价值
        scanner.close(); //关闭扫描器
    }
}
