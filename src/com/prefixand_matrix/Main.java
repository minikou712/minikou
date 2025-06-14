package com.prefixand_matrix;
import java.util.Scanner;


public class Main {
    public static int n;
    public static int m;
    public static int q;
    public static int a[][] = new int[1005][1005];
    public static int s[][] = new int[1005][1005];

    public void prefixAnd() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + a[i][j];
            }
        }
    }

    public void queryPrefix(int x1, int y1, int x2, int y2) {
        System.out.println(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        // 调用计算二维前缀和
        Main main = new Main();
        main.prefixAnd();
        int x1, x2, y1, y2;
        while ((q--) > 0) {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            // 计算查询范围内的前缀和 调用查询函数
            main.queryPrefix(x1, y1, x2, y2);
        }
        scanner.close();
    }
}