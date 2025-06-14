package com.MergeSort;

public class Main {

    // 归并排序
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 复制数据到临时数组
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // 合并临时数组回原数组
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 复制剩余元素
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 找到中间点
            int mid = (left + right) / 2;

            // 递归排序左半部分
            mergeSort(arr, left, mid);
            // 递归排序右半部分
            mergeSort(arr, mid + 1, right);

            // 合并已排序的部分
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        // 归并排序
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);

        System.out.println();
    }
}
