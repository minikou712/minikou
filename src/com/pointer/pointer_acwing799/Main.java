package com.pointer.pointer_acwing799;

import java.util.*;

/** 最长连续不重复子序列 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组长度
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt(); // 输入数组元素
        }
        int l = 1, r = 1; // 左右指针
        int ans = 0;
        int[] b = new int[100005]; // 记录元素出现的次数
        while (r <= n) {
            if(b[a[r]] == 0) { // 如果当前元素没有出现过
                b[a[r]]++; // 记录出现次数
                ans= Math.max(ans,r-l+1); // 更新最大长度
                r++; // 右指针向右移动}
            }
            else{
                b[a[l]]--; // 左指针向右移动
                l++; // 左指针向右移动
            }
        }
        scanner.close(); // 关闭扫描器
        System.out.println(ans); // 输出结果
    }
}
