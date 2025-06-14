package com.graphtheory.dijkstra;
import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;
    private static int[][] g;

    private static int dijkstra(int start) {
        int[] dist = new int[n + 1]; // 存储最短路径长度
        boolean[] visited = new boolean[n + 1]; // 标记节点是否已访问

        // 初始化距离数组
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0; // 起点到自身的距离为0

        // 遍历n-1次
        for (int i = 1; i < n; i++) {
            int u = -1;
            // 找到未访问的最小距离节点
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            visited[u] = true; // 标记为已访问

            // 更新最短路径
            for (int v = 1; v <= n; v++) {
                if (g[u][v] != Integer.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + g[u][v]);
                }
            }
        }

        // 检查是否可达终点
        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        // 初始化邻接矩阵
        g = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = Integer.MAX_VALUE;
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

        // 输出结果
        System.out.println(dijkstra(1));
    }
}