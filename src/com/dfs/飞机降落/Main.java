package com.dfs.飞机降落;

import java.util.*;

public class Main {

    private static class Fly {
        int ti, di, li;

        Fly(int ti, int di, int li) {
            this.ti = ti;
            this.di = di;
            this.li = li;
        }
    }

    private static Fly[] flys;
    private static int n;
    private static boolean[] visited;

    private static boolean dfs(int k, int currentTime) {
        if (k == n)
            return true; // 所有飞机都已降落

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue; // 跳过已降落的飞机
            Fly fly = flys[i];
            if (currentTime > fly.ti + fly.di)
                continue; // 当前时间不在允许降落时间范围内

            visited[i] = true; // 标记当前飞机为已降落
            if (dfs(k + 1, Math.max(currentTime, fly.ti) + fly.li))
                return true; // 尝试下一架飞机
            visited[i] = false; // 回溯
        }
        return false; // 无法找到可行方案
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 测试数据组数
        while (T-- > 0) {
            n = scanner.nextInt(); // 飞机数量
            flys = new Fly[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                int ti = scanner.nextInt();
                int di = scanner.nextInt();
                int li = scanner.nextInt();
                flys[i] = new Fly(ti, di, li);
            }

            // 尝试深度优先搜索
            boolean canLand = dfs(0, 0);  // 从第 0 架飞机开始，当前时间为 0

            System.out.println(canLand ? "YES" : "NO");
        }
        scanner.close();
    }
}