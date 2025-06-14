package com.dfs.星际旅行floyd;

import java.util.Scanner;

/**
 * 小明国庆节准备去某星系进行星际旅行，这个星系里一共有 𝑛 n 个星球，其中布置了 𝑚 m 道双向传送门，第 𝑖 i 道传送门可以连接 𝑎 𝑖 ,
 * 𝑏 𝑖 a i ​ ,b i ​ 两颗星球（ 𝑎 𝑖 ≠ 𝑏 𝑖 a i ​  =b i ​ 且任意两颗星球之间最多只有一个传送门）。
 * 他看中了一款 “旅游盲盒”，一共有 𝑄 Q 个盲盒，第 𝑖 i 个盲盒里的旅行方案规定了旅行的起始星球 𝑥 𝑖 x i ​
 * 和最多可以使用传送门的次数 𝑦 𝑖 y i ​ 。只要从起始星球出发，使用传送门不超过规定次数能到达的所有星球都可以去旅行。
 * 小明关心在每个方案中有多少个星球可以旅行到。小明只能在这些盲盒里随机选一个购买，他想知道能旅行到的不同星球的数量的期望是多少。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 旅行的星球数
        int m = scanner.nextInt(); // 传送门的数量

        int[][] dp = new int[n + 1][n + 1]; // 星球间最短路径 此处路径即传送门
        int q = scanner.nextInt(); // 盲盒数
        // 先初始化floyd数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2; // 没有传送门的距离为无穷大
                if (i == j) {
                    dp[i][j] = 0; // 自己到自己距离为0
                }
            }
        }
        // 读入传送门信息
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt(); // 传送门的起点
            int v = scanner.nextInt(); // 传送门的终点
            dp[u][v] = 1; // 有传送门
            dp[v][u] = 1; // 双向传送门
        }

        // floyd算法求最短路径
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        double ans = 0; // 期望值
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt(); // 起始星球
            int y = scanner.nextInt(); // 最多使用的传送门次数
            int count = 0; // 可到达的星球数
            for (int j = 1; j <= n; j++) {
                if (dp[x][j] <= y) { // 如果星球i在x的可达范围内
                    count++;
                }
            }
            ans += count; // 累加可到达的星球数
        }
        ans = ans / q;
        System.out.printf("%.2f", ans); // 输出期望值  格式化自动四舍五入处理
        scanner.close(); // 关闭扫描器
    }
}