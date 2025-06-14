package com.dfs.base;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 1.深度优先搜索（DFS）
    // 在算法比赛中，深度优先搜索（DFS）是一种常用的搜索算法，用于遍历或搜索树或图的所有节点。
    // 其代码模板一般采用 递归+循环的方式实现，每当搜索完一条路径后，进行判断，
    // 如果满足条件，则输出结果；否则，回溯到上一个节点，继续搜索其他路径。
    // 代码模板如下：
    // 判断条件函数
    private static boolean check(int depth) {
        // 判断条件
        return true; // 这里可以根据具体问题进行修改
    }

    public static void dfs(int depth, int n) {
        // 1.判断是否满足条件
        if (check(depth)) {
            // 输出结果
            return;
        }
        // 2.遍历所有可能的路径
        for (int i = 0; i < n; i++) {
            // 3.进行深度优先搜索
            dfs(depth + 1, n);
            // 4.回溯到上一个节点，继续搜索其他路径
        }
    }

    // 经典Dfs例题
    // 1.求解迷宫问题
    // 2.求解八皇后问题
    // 3.求解图的连通分量
    // 4.求解图的最小生成树
    // 5.求解图的最短路径问题

    //2.广度优先搜索（BFS）
    // 广度优先搜索（BFS）是一种常用的搜索算法，用于遍历或搜索树或图的所有节点。
    // 其代码模板一般采用 队列+循环的方式实现，每当搜索完一层节点后，进行判断，

    //相比与深度优先搜索，广度优先搜索的时间复杂度更高，
    //但是广度优先搜索的空间复杂度更低，适合用于大规模数据的搜索。

    //其代码模板如下：
    private static boolean checkB(int depth) {
        // 判断条件
        return true; // 这里可以根据具体问题进行修改
    }

    //队列循环实现广度优先搜索
    public static void bfs(int start, int n, boolean[][] graph) {
        // 创建一个队列用于存储节点
        Queue<Integer> queue = new LinkedList<>();
        // 创建一个数组用于标记节点是否已访问
        boolean[] visited = new boolean[n];

        // 将起始节点加入队列并标记为已访问
        queue.add(start);
        visited[start] = true;

        // 循环处理队列中的节点
        while (!queue.isEmpty()) {
            // 取出队首节点
            int current = queue.poll();
            System.out.println("访问节点：" + current);

            // 遍历当前节点的所有邻接节点
            for (int i = 0; i < n; i++) {
                // 如果节点未访问且与当前节点相连
                if (!visited[i] && graph[current][i]) {
                    queue.add(i); // 将节点加入队列
                    visited[i] = true; // 标记为已访问
                }
            }
        }
    }
}
