package com.slidingwindow.acwing_154;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口给定一个大小为 n≤10的6次方的数组。
 * 有一个大小为 k的滑动窗口，它从数组的最左边移动到最右边。
 * 
 * 你只能在窗口中看到 k个数字。
 * 
 * 每次滑动窗口向右移动一个位置。
 * 你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
 * 
 * 输出格式
 * 输出包含两个。
 * 
 * 第一行输出，从左至右，每个位置滑动窗口中的最小值。
 * 
 * 第二行输出，从左至右，每个位置滑动窗口中的最大值。
 */

// 1.常规暴力方法
// 直接遍历每一个窗口，找出每个窗口min,max，时间复杂度O(n*k) 超时
// 2.使用双端队列来优化 滑动窗口的最大值和最小值
// 双端队列的思路是：
// 1.维护一个单调递减的双端队列，队列头元素就是当前窗口的最大值
// 2.维护一个单调递增的双端队列，队列头元素就是当前窗口的最小值
// 3.当窗口向右移动时，弹出队列头元素，直到队列头元素不在窗口内
// 4.将当前元素入队列，同时维护单调性，弹出队列尾元素，直到队列尾元素比当前元素小或者队列为空
// 5.最后输出队列头元素就是当前窗口的最大值和最小值
// 6.时间复杂度O(n) 空间复杂度O(k)
// 7.注意：双端队列的实现可以使用LinkedList类，也可以使用ArrayDeque类，LinkedList类的性能更好
// 8.注意：双端队列的实现需要使用泛型，不能使用基本数据类型，基本数据类型会自动装箱成对象，性能较差
public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        String[] s = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        StringBuilder minResult = new StringBuilder();
        StringBuilder maxResult = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k) {
                maxDeque.pollFirst();
            }
            if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - k) {
                minDeque.pollFirst();
            }
            while (!maxDeque.isEmpty() && a[maxDeque.peekLast()] <= a[i]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && a[minDeque.peekLast()] >= a[i]) {
                minDeque.pollLast();
            }
            maxDeque.addLast(i);
            minDeque.addLast(i);
            if (i >= k - 1) {
                minResult.append(a[minDeque.peekFirst()]).append(" ");
                maxResult.append(a[maxDeque.peekFirst()]).append(" ");
            }
        }

        writer.write(minResult.toString().trim() + "\n");
        writer.write(maxResult.toString().trim() + "\n");
        writer.flush();
        reader.close();
        writer.close();
    }
}
