package com.pointer.pointer_acwing800;

import java.util.*;

//数组元素目标和
/**
 * 给定两个升序排序的有序数组 A和 B
 * ，以及一个目标值 x
 * 。
 * 
 * 数组下标从 0开始。
 * 
 * 请你求出满足 A[i]+B[j]=x的数对 (i,j)
 * 。
 * 
 * 数据保证有唯一解。
 */

public class Main {
    private static int n, m; // 数组长度

    /**
     * 1.双指针法
     * 由于两个数组都是升序排序的，所以可以使用双指针法来解决这个问题。
     * 1. 初始化两个指针 i 和 j，分别指向数组 A 和 B 的开头。
     * 2. 如果 A[i] + B[j] == x，则输出 (i, j)。
     * 3. 如果 A[i] + B[j] < x，则将指针 i 向右移动一位。
     * 4. 如果 A[i] + B[j] > x，则将指针 j 向左移动一位。
     * 5. 重复步骤 2-4，直到找到满足条件的数对。
     * 
     * @param a
     * @param b
     * @param x
     * 
     */
    private void twoPointer(int a[], int b[], int x) {
        int i = 1, j = b.length; // 初始化指针
        while (i <= a.length && j >= 1) {
            if (a[i] + b[j] == x) { // 如果找到满足条件的数对
                System.out.println((i - 1) + " " + (j - 1)); // 输出结果
                return; // 结束程序
            } else if (a[i] + b[j] < x) { // 如果和小于目标值，移动左指针
                i++;
            } else { // 如果和大于目标值，移动右指针
                j--;
            }

        }
    }

    /**
     * 2.二分查找法
     * 1. 对于每个元素 A[i]，我们可以使用二分查找在数组 B 中查找 x - A[i]。
     * 2. 如果找到了满足条件的元素，则输出 (i, j)。
     * 3. 如果没有找到，则继续下一个元素。
     * 4. 重复步骤 1-3，直到找到满足条件的数对。
     * 
     * @param a
     * @param b
     * @param x
     * 
     */
    private void binarySearch(int a[], int b[], int x) {
        for (int i = 1; i <= n; i++) { // 遍历数组 A
            int target = x - a[i]; // 计算目标值
            int left = 1, right = m; // 初始化二分查找的左右指针
            int start = -1; // 目标下标
            while (left <= right) { // 二分查找
                int mid = left + (right - left) / 2; // 防止溢出
                if (b[mid] == target) {
                    start = mid; // 找到目标值，记录当前下标，继续向左搜素
                    right = mid - 1; // 搜左边界，继续左搜，防止多个重复target数据
                } else if (b[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (start != -1) { // 如果找到目标值
                System.out.println((i - 1) + " " + (start - 1)); // 输出结果
                return;
            }
        }
    }

    /**
     * 3.哈希表法
     * 1. 将数组 B 中的元素存储在哈希表中，键为元素值，值为下标。
     * 2. 遍历数组 A，对于每个元素 A[i]，计算 x - A[i]。
     * 3. 如果 x - A[i] 在哈希表中存在，则输出 (i, j)，其中 j 为哈希表中存储的下标。
     * 4. 如果没有找到，则继续下一个元素。
     * 5. 重复步骤 2-4，直到找到满足条件的数对。
     * 
     * @param a
     * @param b
     * @param x
     */
    private void hashMap(int a[], int b[], int x) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 创建哈希表
        for (int i = 1; i <= m; i++) {
            map.put(b[i], i - 1); // 存储数组 B 的值和对应的下标（从 0 开始）
        }
        for (int i = 1; i <= n; i++) {
            int target = x - a[i]; // 计算目标值
            if (map.containsKey(target)) { // 检查目标值是否存在于哈希表中
                System.out.println((i - 1) + " " + map.get(target)); // 输出结果
                return; // 找到唯一解后直接返回
            }
        }
    }
    
    /**
     * 4.法四暴力枚举
     * 1. 使用两层循环，遍历数组 A 和 B 的所有元素。
     * 2. 对于每一对元素 A[i] 和 B[j]，检查它们的和是否等于 x。
     * 3. 如果找到了满足条件的数对，则输出 (i, j)。
     * 4. 如果没有找到，则继续下一个元素。
     * 5. 重复步骤 2-4，直到找到满足条件的数对。
     * @param args
     */
    private void bruteForce(int a[], int b[], int x) {
        for (int i = 1; i <= n; i++) { // 遍历数组 A
            for (int j = 1; j <= m; j++) { // 遍历数组 B
                if (a[i] + b[j] == x) { // 如果找到满足条件的数对
                    System.out.println((i - 1) + " " + (j - 1)); // 输出结果
                    return; // 找到唯一解后直接返回
                }
            }
        }
    }
    public static void main(String[] args) {
        ;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int a[] = new int[n + 1];
        int b[] = new int[m + 1];
        int x = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt(); // 输入数组元素
        }
        for (int i = 1; i <= m; i++) {
            b[i] = scanner.nextInt(); // 输入数组元素
        }
        Main main = new Main();
        main.twoPointer(a, b, x); // 调用双指针方法

        scanner.close(); // 关闭扫描器
    }
}
