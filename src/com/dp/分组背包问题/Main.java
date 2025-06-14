package com.dp.分组背包问题;

import java.util.*;

public class Main {
    // 分组背包问题的动态规划解法
    // dp[i][j]表示前i个物品放入容量为j的背包的最大价值
    // 与完全背包的区别在于分组背包将物品分为多个组，每组只能至多选择一个物品放入背包
    // 多重背包问题的区别在于多重背包对于每个物品只能选择放入有限数量的物品
    // 完全背包可以选择放入多个相同的物品
    // 01背包对于每个物品只能选择放入一次，而完全背包可以选择放入多次
    // 分组背包问题的动态规划解法

    // 分组
    private static class item {
        int w; // 物品重量
        int c; // 物品价值

        public item(int w, int c) {
            this.w = w;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 物品组数
        int v = scanner.nextInt(); // 背包容量

        List<List<item>> items = new ArrayList<>(); // 物品组数组

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt(); // 物品数量
            List<item> group = new ArrayList<>(); // 当前组的物品列表
            for (int j = 0; j < m; j++) {
                int w = scanner.nextInt(); // 物品重量
                int c = scanner.nextInt(); // 物品价值
                group.add(new item(w, c)); // 创建物品对象并存入组列表
            }
            items.add(group); // 将当前组添加到物品组数组
        }

        int[][] dp = new int[n + 1][v + 1]; // dp[i][j]表示前i个物品组放入容量为j的背包的最大价值

        for (int i = 1; i <= n; i++) // 枚举物品组
        {
            for (int j = 0; j <= v; j++) // 枚举背包容量
            {
                dp[i][j] = dp[i - 1][j]; // 初始化为不放入当前组的最大价值
                // 枚举当前组的物品 每组只能取一个物品

                for (item it : items.get(i - 1)) // 枚举当前组的物品 每组只能取一个物品
                {

                    //此处为什么是max(dp[i][j],)而不是dp[i][j]=max(dp[i-1][j],)
                    //因为我们要在当前物品的基础上进行更新，而不是在前一个物品的基础上进行更新,所以与01背包不同
                    if (it.w <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - it.w] + it.c); // 放入背包和不放入背包的最大价值
                    }

                }
                // 如果每组可以取多个物品，则需要在这里进行处理
                // for(int k=0;k<items.get(i-1).size();k++) //枚举当前组的物品 每组可以取多个物品
                // {
                // item it=items.get(i-1).get(k);
                // if(it.w<=j)
                // {
                // dp[i][j]=Math.max(dp[i][j],dp[i][j-it.w]+it.c); //放入背包和不放入背包的最大价值
                // }
                // }
            }
        }
        System.out.println(dp[n][v]); // 输出最大价值
        scanner.close(); // 关闭扫描器
    }
}
