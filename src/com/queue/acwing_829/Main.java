package com.queue.acwing_829;

import java.security.cert.X509CRL;
import java.util.*;

/**
 * 模拟队列
 * 实现一个队列，队列初始为空，支持四种操作：
 * 
 * push x – 向队尾插入一个数 x；
 * pop – 从队头弹出一个数；
 * empty – 判断队列是否为空；
 * query – 查询队头元素。
 * 现在要对队列进行 M个操作，其中的每个操作 3和操作 4都要输出相应的结果。
 * 
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 * 
 * 接下来 M行，每行包含一个操作命令，操作命令为 push x，pop，empty，query 中的一种。
 * 
 * 输出格式
 * 对于每个 empty 和 query 操作都要输出一个查询结果，每个结果占一行。其中，empty 操作的查询结果为 YES 或 NO，query
 * 操作的查询结果为一个整数，表示队头元素的值。
 * 
 * 数据范围
 * 1≤M≤100000
 * ,
 * 1≤x≤109
 * ,
 * 所有操作保证合法，即不会在队列为空的情况下进行 pop 或 query 操作。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        while (m-- > 0) {
            String command = sc.next();
            // 注意：next()方法只能读取一个单词，不能读取空格
            // 而nextLine()方法可以读取一行
            if (command.equals("push")) {
                int x = sc.nextInt();
                queue.add(x);
            } else if (command.equals("pop")) {
                queue.poll();
            } else if (command.equals("empty")) {
                System.out.println(queue.isEmpty() ? "YES" : "NO");
            } else if (command.equals("query")) {
                System.out.println(queue.peek());
            }

        }
        sc.close();
    }

}
