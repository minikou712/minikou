package com.stack.basic;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /** String 常用方法 */
        String str = "Hello, World!";
        //1.charAt(int index) 返回指定索引处的字符。
        Character character = str.charAt(0);
        System.out.println(character); // H
        //2.compareTo(String anotherString) lexicographically compares two strings.
        // 返回一个负整数、零或一个正整数，表示该字符串与指定字符串的字典顺序比较的结果。
        System.out.println(str.compareTo("Hello, World!")); // 0
        //3.compareToIgnoreCase(String str) 忽略大小写
        // 返回一个负整数、零或一个正整数，表示该字符串与指定字符串的字典顺序比较的结果。
        System.out.println(str.compareToIgnoreCase("hello, world!")); // 0
        //4.subString(int beginIndex) 返回一个新的字符串，它是此字符串的子字符串，从指定的开始索引到字符串的结尾。
        String s=str.substring(0, 5);
        System.out.println(s); // Hello
        //5.indexOf(String str) 返回指定子字符串在此字符串中第一次出现的索引。
        // 如果此字符串中没有这样的子字符串，则返回 -1。
        System.out.println(str.indexOf("World")); // 7
        System.out.println(str.indexOf("Hello")); // 0  下标从0开始

        String str1 = "Hello, World! Hello!";
        //6.lastIndexOf(String str) 返回指定子字符串在此字符串中最后一次出现的索引。
        System.out.println(str1.lastIndexOf("Hello")); // 13
        
        //7.split(String regex) 将此字符串根据给定的正则表达式拆分为字符串数组。
        String[] arr=str.split(", ");
        for (String s1 : arr) {
            System.out.println(s1); // Hello
        }

        //8.replace(String target, String replacement) 返回一个新字符串，它是通过用指定的替换字符串替换此字符串中所有出现的指定子字符串来生成的。
        String replacedStr = str.replace("World", "Java");
        System.out.println(replacedStr); // Hello, Java!
        //9.toLowerCase() 将此字符串转换为小写。
        System.out.println(str.toLowerCase()); // hello, world!
        //10.toUpperCase() 将此字符串转换为大写。
        System.out.println(str.toUpperCase()); // HELLO, WORLD!
        //11.trim() 返回一个字符串，它是删除了前导和尾随空格的此字符串。
        String str2 = "   Hello, World!   ";
        System.out.println(str2.trim()); // Hello, World!
        //12.equals(Object anObject) 比较此字符串与指定对象。   与compare不同返回类型为boolean
        System.out.println(str.equals("Hello, World!")); // true

        //13.equalsIngoreCase(String str) 比较此字符串与指定字符串，忽略大小写。
        System.out.println(str.equalsIgnoreCase("hello, world!")); // true

        //14.contains(CharSequence sequence) 返回 true 如果此字符串包含指定的字符序列。  此处返回boolean类型
        System.out.println(str.contains("World")); // true


        /**Stack常用方法   */

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            stack.push(c); // 将字符压入栈中
        }
        System.out.println("栈的大小: " + stack.size()); // 栈的大小: 13

        //1.push(E item) 将指定元素压入此栈。
        stack.push('!');

        //2.pop() 删除栈顶部的对象，并将该对象作为此函数的值返回。
        char top = stack.pop(); // 删除栈顶元素

        //3.peek() 查看栈顶部的对象，但不删除它。
        char peek = stack.peek(); // 查看栈顶元素
        System.out.println("栈顶元素: " + peek); // 栈顶元素: !

        //4.isEmpty() 测试此栈是否为空。
        boolean isEmpty = stack.isEmpty(); // 判断栈是否为空

        //5.search(Object o) 返回对象在栈中的位置，栈顶元素的位置为 1。
        int position = stack.search('H'); // 查找元素 'H' 在栈中的位置

        //6.size() 返回栈中元素的数量。
        int size = stack.size(); // 获取栈的大小
        System.out.println("栈的大小: " + size); // 栈的大小: 13
    }

}
