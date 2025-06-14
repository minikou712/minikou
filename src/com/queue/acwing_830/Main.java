package com.queue.acwing_830;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    /**
     * 单调栈
     * 给定一个长度为 N
     * 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。
     * 
     * 输入格式
     * 第一行包含整数 N，表示数列长度。
     * 
     * 第二行包含 N
     * 个整数，表示整数数列。
     * 
     * 输出格式
     * 共一行，包含 N个整数，其中第 i个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 −1
     * 。
     */

    public static void main(String[] args) {
        // 常规思路 暴力枚举每一个数的左边第一个比它小的数，时间复杂度O(n^2)
        // 但是这样会超时
        // 所以我们需要使用单调栈来优化
        // 单调栈的思路是：
        // 1.从左到右遍历数列，维护一个单调递减的栈，栈顶元素就是当前元素的左边第一个比它小的数
        // 2.如果栈顶元素比当前元素大，则弹出栈顶元素，直到栈顶元素比当前元素小或者栈为空
        // 3.如果栈为空，则当前元素的左边第一个比它小的数为-1
        // 4.如果栈顶元素比当前元素小，则当前元素的左边第一个比它小的数为栈顶元素
        // 5.最后将当前元素入栈

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                System.out.print(-1 + " ");
                stack.push(a[i]);
            } else if (stack.peek() < a[i]) {
                System.out.print(stack.peek() + " ");
                stack.push(a[i]);
            } else {
                while (!stack.empty() && stack.peek() >= a[i]) {
                    stack.pop();
                }
                if (!stack.empty())
                    System.out.println(stack.peek() + " ");
                else
                    System.out.println(-1 + " ");
                stack.push(a[i]);
            }

        }
        sc.close();
    }
}
