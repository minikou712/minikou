package com.binarysearch.管道;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int n; // 阀门数
    private static int len; // 管道长度
    private static int[][] dp; // 存储管道段位置和打开时间

    private static class Merge {
        int start, end;

        Merge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static boolean check(int mid) {
        // 计算每个阀门的覆盖范围
        List<Merge> merges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mid > dp[i][1]) {  //阀门打开时间大于当前时间
                merges.add(new Merge(dp[i][0] - (mid - dp[i][1]), dp[i][0] + mid - dp[i][1]));
            }
        }

        // 按起点排序
        merges.sort((a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            } else {
                return Integer.compare(a.end, b.end);
            }
        });

        // 合并区间
        Merge currentMerge = merges.get(0);
        for(int i=1;i<merges.size();i++){
            if(currentMerge.end+1<merges.get(i).start){
                return false; // 无法覆盖
            }
            currentMerge.end = Math.max(currentMerge.end, merges.get(i).end);
        }
        // 检查是否覆盖整个管道
        return currentMerge.start <= 0 && currentMerge.end >= len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 阀门数
        len = scanner.nextInt(); // 管道长度
        dp = new int[n][2]; // 存储管道段位置和打开时间
        for (int i = 0; i < n; i++) {
            dp[i][0] = scanner.nextInt(); // 管道段位置
            dp[i][1] = scanner.nextInt(); // 打开时间
        }

        // 二分查找最小时间
        int left = 0, right = (int) 2e9;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid; // 尝试更小的时间
            } else {
                left = mid + 1; // 增加时间
            }
        }

        System.out.println(left);
        scanner.close();
    }
}
