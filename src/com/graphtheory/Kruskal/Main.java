package com.graphtheory.Kruskal;
import java.util.*;

public class Main {
    private static class Edge {
        int u, v, w;
    }

    private static int n, m;
    private static Edge[] edges;   //引用数据类型必须为每个元素初始化 此处只是初始化了
    //每个Edge对象的引用，即一个引用数组
    private static int[] p; //必须后初始化
    //private static int[] p=new int[n+5]; 此时n默认为0，会导致数组长度始终为5

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        
        edges=new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i]=new Edge();
            edges[i].u = scanner.nextInt();
            edges[i].v = scanner.nextInt();
            edges[i].w = scanner.nextInt();
        }

        Arrays.sort(edges, (e1, e2) -> { return Integer.compare(e1.w, e2.w);});

        p=new int[n+5];
        for (int i = 1; i <= n; i++) {
            p[i] = i; // 初始化并查集
        }

        int ans = 0; // 最小生成树边数
        int sumw = 0; // 最小生成树边权值
        for (int i = 0; i < m; i++) {
            if (find(edges[i].u) != find(edges[i].v)) {
                p[find(edges[i].u)] = find(edges[i].v);
                sumw += edges[i].w;
                ans++;
            }
        }

        if (ans < n - 1) {
            System.out.println("impossible");
        } else {
            System.out.println(sumw);
        }

        scanner.close();
    }
}