package com.lanqiao_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对于一个有n 位的十进制数N = d1d2d3 ... dn，可以生成一个类斐波那契数列S ，数列S 的前n 个数为{S1 = d1， S2 = d2，
 * S3 = d3...,Sn = dn}，数列S 的第k(k > n) 个数为k-n 到k-1 项的合。如果这个数N
 * 会出现在对应的类斐波那契数列S中，那么N 就是一个类斐波那契循环数。
 * 
 * 例如对于197，对应的数列S 为f 1; 9; 7; 17; 33; 57; 107; 197; : : : g，197 出现在S 中，所以197
 * 是一个类斐波那契循环数。
 * 
 * 请问在0 至10的7次方中，最大的类斐波那契循环数是多少？
 */
public class two {
    // 获取起始序列
    static List<Integer> toList(int a) {
        List<Integer> list = new ArrayList<>();
        while (a > 0) {
            int t = a % 10;// 得到个位数
            list.add(t);
            a /= 10;
        }
        Collections.reverse(list);// 逆置
        return list;
    }

    // 判断是否是循环数
    static boolean isFab(int a) {
        ArrayList<Integer> list = new ArrayList<>(toList(a));
        int len = list.size();// 获得a的位数
        while (true) {
            int sum = 0;

            // 注意下标不要越界！！！
            for (int i = list.size() - 1; i > list.size() - 1 - len; i--) {// 递推类斐波那契数
                sum += list.get(i);
            }
            if (sum == a)
                return true;
            if (sum > a)
                return false;
            list.add(sum);
        }
    }

    public static void main(String[] args) {
        int end = (int) 1e7;
        while (end > 0) {
            if (isFab(end)) {
                System.out.println(end);
                return;
            }
            end--;
        }

    }
}