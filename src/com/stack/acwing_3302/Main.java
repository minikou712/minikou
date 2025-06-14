package com.stack.acwing_3302;

import java.util.*;

/**
 * 表达式求值
 * 给定一个表达式，其中运算符仅包含 +,-,*,/（加 减 乘 整除），可能包含括号，请你求出表达式的最终值。
 * 
 * 注意：
 * 
 * 数据保证给定的表达式合法。
 * 题目保证符号 - 只作为减号出现，不会作为负号出现，例如，-1+2,(2+2)*(-(1+1)+2) 之类表达式均不会出现。
 * 题目保证表达式中所有数字均为正整数。
 * 题目保证表达式在中间计算过程以及结果中，均不超过 231−1
 * 。
 * 题目中的整除是指向 0
 * 取整，也就是说对于大于 0
 * 的结果向下取整，例如 5/3=1
 * ，对于小于 0
 * 的结果向上取整，例如 5/(1−4)=−1
 * 
 */

public class Main {

    private Integer cal(int a, int b, char op) {
        if (op == '+') {
            return Integer.valueOf(a + b);
        } else if (op == '-') {
            return Integer.valueOf(a - b);
        } else if (op == '*') {
            return Integer.valueOf(a * b);
        } else if (op == '/') {
            return Integer.valueOf(a / b);
        }
        return null;
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> numsStack = new Stack<>();
        Stack<Character> opsStack = new Stack<>();

        Main main = new Main();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opsStack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (opsStack.peek() != '(') {
                    int b = numsStack.pop();
                    int a = numsStack.pop();
                    char op = opsStack.pop();
                    numsStack.push(main.cal(a, b, op));
                }
                opsStack.pop();
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                String num = "";
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num += s.charAt(i);
                    i++;
                }
                i--;  // 退回到数字的最后一位
                numsStack.push(Integer.valueOf(Integer.parseInt(num)));
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {  // 处理运算符
                while (!opsStack.isEmpty() && main.precedence(opsStack.peek()) >= main.precedence(s.charAt(i))) {
                    int b = numsStack.pop();
                    int a = numsStack.pop();
                    char op = opsStack.pop();
                    numsStack.push(main.cal(a, b, op));
                }
                opsStack.push(s.charAt(i));
            }
        }
        while (!opsStack.isEmpty()) {
            int b = numsStack.pop();
            int a = numsStack.pop();
            char op = opsStack.pop();
            numsStack.push(main.cal(a, b, op));
        }
        System.out.println(numsStack.pop());
        sc.close();
    }
}
