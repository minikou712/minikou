package com.difference_matrix;
import java.util.Scanner;
import java.io.*;

public class Main {
    private static int n, m, q;
    private static int[][] a = new int[1005][1005];
    private static int[][] s = new int[1005][1005];

    private static void buildDifference() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = s[i][j] - s[i - 1][j] - s[i][j - 1] + s[i - 1][j - 1];
            }
        }
    }

    private static void prefixAnd() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + a[i][j];
            }
        }
    }

    private static void operate(int x1, int y1, int x2, int y2, int c) {
        a[x1][y1] += c;
        a[x1][y2 + 1] -= c;
        a[x2 + 1][y1] -= c;
        a[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args)throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = scanner.nextInt(); // 行数
        m = scanner.nextInt(); // 列数
        q = scanner.nextInt(); // 操作次数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = scanner.nextInt(); // 输入矩阵元素
            }
        }
        buildDifference(); // 构建差分数组
        for (int i = 1; i <= q; i++) {
            int x1 = scanner.nextInt(); // 左上角行坐标
            int y1 = scanner.nextInt(); // 左上角列坐标
            int x2 = scanner.nextInt(); // 右下角行坐标
            int y2 = scanner.nextInt(); // 右下角列坐标
            int c = scanner.nextInt(); // 增加的值
            operate(x1, y1, x2, y2, c); // 执行操作
        }
        prefixAnd(); // 前缀和计算
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bw.write(s[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        scanner.close(); // 关闭扫描器
    }
}