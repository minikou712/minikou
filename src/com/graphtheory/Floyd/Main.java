package com.graphtheory.Floyd;

import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;
    private static int[][] g;

    //floyd算法思想：
    // 1. 初始化邻接矩阵，g[i][j]表示从i到j的最短路径长度
    // 2. 对于每一对节点(i, j)，检查是否存在一个中间节点k，使得从i到j的路径经过k更短
    // 3. 如果存在这样的k，则更新g[i][j]为g[i][k] + g[k][j]     
    // 4. 重复步骤2和3，直到所有节点都被考虑为止
    // 5. 最终，g[i][j]即为从i到j的最短路径长度
    private static void floyd() {
        for (int k = 1; k <= n; k++) {  //枚举中间点
            for (int i = 1; i <= n; i++) {  //枚举起点
                for (int j = 1; j <= n; j++) {  //枚举终点
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int k = scanner.nextInt();
        // 初始化邻接矩阵
        g = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    g[i][j] = 0;  // 自己到自己的距离为0
                else
                g[i][j] = Integer.MAX_VALUE / 2; // 使用较大的值表示无穷大
            }
        }

        // 读取边并构建图
        while (m-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            if (x != y) { // 忽略自环
                g[x][y] = Math.min(g[x][y], z);
            }
        }
        floyd(); // 执行Floyd-Warshall算法
        // 输出结果
        while (k-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (g[x][y] == Integer.MAX_VALUE / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(g[x][y]);
            }

        }
        scanner.close();
    }
}
