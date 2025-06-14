package com.prefixand;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int N = (int) (1e5 + 5);
    static int a[] = new int[N];
    static int s[] = new int[N];

    static void buildPrefixAnd() {
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
    }

    static int queryPrefix(int l, int r) {
        return s[r] - s[l - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        buildPrefixAnd();
        while ((m--) > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(queryPrefix(l, r));
        }
    }
    
}