package com.binarysearch;

import java.util.Scanner;

public class Main {
    public static int N = (int) 1e5;
    static int[] a = new int[N];
    static int n, q;

    //先大后小，有边界+1
    // 查找目标值的第一个出现位置
    static int findStart(int k) {
        int left = 0, right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] >= k) {
                // 当前搜索在目标值右侧，缩小搜索右边界
                right = mid;
            } else {
                // 当前搜索在目标值左侧，缩小左边界
                left = mid + 1; // 没有取等+1
            }
        }
        return left;
    }

    // 查找目标值的最后一个出现位置
    static int findEnd(int k) {
        int left = 0, right = N;
        while (left < right) {
            int mid=(left+right+1)/2;
            if(a[mid]<=k)
            {
                //当前搜索在目标左侧，缩小左边界
                left=mid;
            }
            else
            {
                //当前搜索在目标右侧，缩小右边界
                right=mid-1;  //没有取等+1
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int k;
        while ((q--) > 0) {
            k = scanner.nextInt();
            int start = findStart(k);
            int end = findEnd(k);
            if (a[start]!=k) {
                System.out.println(-1 + " " + -1);
            } else {
                System.out.println(start + " " + end);
            }
        }
    }
}