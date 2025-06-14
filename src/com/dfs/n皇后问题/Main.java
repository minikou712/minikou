package com.dfs.n皇后问题;

import java.util.Scanner;

public class Main {
    private static int n;
    private static char[][] g;
    private static boolean[] col, dg, udg; // 列、主对角线、副对角线

    private static void dfs(char[][] g, int u) {
        if (u == n) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return; // 此处的return是结束当前递归函数的执行 并返回到上一级递归函数，
            // 以树形结构为例，即到达当前路径的叶子节点后，返回到上一级节点然后继续遍历其他路径
        }
        for (int i = 1; i <= n; i++) {
            if (!col[i] && !dg[u + i] && !udg[u - i + n]) // 判断是否可以放置皇后 这里的u是当前行数 
            {
                // 这里的col[i]表示第i列是否被占用，dg[u + i]表示主对角线是否被占用，udg[u - i + n]表示副对角线是否被占用
                // 假设i表示当前列数，u表示当前行数，怎么得到主对角线和副对角线的编号呢？ 
                //通过数学推导可以得出 推导如下：
                // 主对角线编号：u + i  主对角线上的点坐标 (x, y) 满足 x + y = k  (k为常数)
                // 副对角线编号：u - i + n  副对角线上的点坐标 (x, y) 满足 x - y = k  (k为常数)
                g[u][i] = 'Q'; // 放置皇后
                col[i] = dg[u + i] = udg[u - i + n] = true; // 将该列，对角线设置为占用
                dfs(g, u + 1); // 递归调用，继续放置下一个皇后
                col[i] = dg[u + i] = udg[u - i + n] = false; // 回溯，撤销选择
                g[u][i] = '.'; // 撤销放置皇后
            }
                

            {
                g[u][i] = 'Q'; // 放置皇后
                col[i] = dg[u + i] = udg[u - i + n] = true; // 将该列，对角线设置为占用
                dfs(g, u + 1); // 递归调用，继续放置下一个皇后
                col[i] = dg[u + i] = udg[u - i + n] = false; // 回溯，撤销选择
                g[u][i] = '.'; // 撤销放置皇后
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new char[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(g, 1);
        sc.close();
    }
}