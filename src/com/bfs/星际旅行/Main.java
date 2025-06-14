package com.bfs.星际旅行;

import java.util.*;

public class Main {
    private static int n; // 星球数
    private static int[][] path; // 存储最短路径
    private static boolean[] visited; // 访问标记数组
    private static List<List<Integer>> graph;

    // 使用 BFS 计算从星球 i 到其他星球的最短路径
    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>(); // 队列
        visited = new boolean[n + 1]; // 访问标记数组
        queue.add(start); // 将起点加入队列
        visited[start] = true; // 标记起点为已访问
        path[start][start] = 0; // 自己到自己的路径为 0

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 取出队首元素
            for (int neighbor : graph.get(current)) { // 遍历当前星球的邻居
                if (!visited[neighbor]) { // 如果没有访问过
                    visited[neighbor] = true; // 标记为已访问
                    queue.add(neighbor); // 加入队列
                    path[start][neighbor] = path[start][current] + 1; // 更新路径长度
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 星球数
        int m = scanner.nextInt(); // 传送门数
        int q = scanner.nextInt(); // 盲盒数

        path = new int[n + 1][n + 1]; // 初始化路径数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                path[i][j] = Integer.MAX_VALUE / 2; // 没有传送门的距离为无穷大
            }
            path[i][i] = 0; // 自己到自己的路径为 0
        }

        graph = new ArrayList<>(); // 存储星球间的传送门信息
        for (int i = 0; i <= n; i++) { // 注意：从 0 到 n 初始化
            graph.add(new ArrayList<>());
        }

        // 读入传送门信息
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt(); // 传送门的起点
            int v = scanner.nextInt(); // 传送门的终点
            graph.get(u).add(v); // 有传送门
            graph.get(v).add(u); // 双向传送门
        }

        // 使用 BFS 计算每个星球到其他星球的最短路径
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        double ans = 0; // 期望值
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt(); // 起始星球
            int y = scanner.nextInt(); // 最多使用的传送门次数
            int count = 0; // 可到达的星球数
            for (int j = 1; j <= n; j++) {
                if (path[x][j] <= y) { // 如果星球 j 在 x 的可达范围内
                    count++;
                }
            }
            ans += count; // 累加可到达的星球数
        }

        ans = ans / q; // 计算期望值
        System.out.printf("%.2f", ans); // 输出期望值，保留两位小数
        scanner.close(); // 关闭扫描器
    }
}