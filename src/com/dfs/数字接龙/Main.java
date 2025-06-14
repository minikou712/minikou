package com.dfs.数字接龙;

import java.util.Scanner;

public class Main {
    private static int n; // 棋盘大小
    private static int k; // 数字范围
    private static int[][] g; // 棋盘数字
    private static boolean[][] visited; // 访问标记
    private static boolean[][][][] edge; // 路径交叉标记
    private static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 },
            { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
    private static String result = null; // 最终结果路径

    // 判断路径是否交叉
    private static boolean check(int x1, int y1, int x2, int y2) {
        return edge[x2][y1][x1][y2] || edge[x1][y2][x2][y1];
    }

    // 深度优先搜索
    private static void dfs(int x, int y, int steps, StringBuilder path) {
        // 如果到达终点且经过所有格子
        if (steps == n * n && x == n && y == n) {
            if (result == null || path.toString().compareTo(result) < 0) {
                result = path.toString();
            }
            return;
        }

        // 遍历八个方向
        for (int i = 0; i < 8; i++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];

            // 边界检查、访问检查和路径交叉检查
            if (xx < 1 || xx > n || yy < 1 || yy > n || visited[xx][yy] || check(x, y, xx, yy)) {
                continue;
            }

            // 数字接龙规则检查
            if ((g[x][y] + 1) % k != g[xx][yy]) {

                continue;
            }

            // 标记访问和路径
            visited[xx][yy] = true;
            edge[x][y][xx][yy] = edge[xx][yy][x][y] = true;
            path.append(i);

            // 继续搜索
            dfs(xx, yy, steps + 1, path);

            // 回溯
            visited[xx][yy] = false;
            edge[x][y][xx][yy] = edge[xx][yy][x][y] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入棋盘大小和数字范围
        n = scanner.nextInt();
        k = scanner.nextInt();

        // 初始化棋盘
        g = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        edge = new boolean[n + 1][n + 1][n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = scanner.nextInt();
            }
        }

        // 从左上角开始搜索
        visited[1][1] = true;
        StringBuilder path = new StringBuilder();
        dfs(1, 1, 1, path);

        // 输出结果
        if (result == null) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}