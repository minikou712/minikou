package com.queue.basic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        
        /**Queue常用方法 (单向队列)*/
        //java中队列集合没有提供获取队尾元素的方法
        //因此我们可以使用LinkedList类来实现队列

        String str="hello world!";
        
        Queue queue=new LinkedList();
    
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
        }
        //1.添加元素
        queue.add("hello");

        //2.查看队列头元素
        queue.peek();
        System.out.println("队列头元素："+queue.peek());

        //3.删除元素
        queue.poll();
        System.out.println("删除元素："+queue.poll());

        //4.查看队列大小
        System.out.println("队列大小："+queue.size());

        //5.判断队列是否为空
        System.out.println("队列是否为空："+queue.isEmpty());
        //6.清空队列
        queue.clear();
        System.out.println("清空队列后，队列大小："+queue.size());


        /** 双向链表实现双向队列 */

        String str2="hello world!";
        
        Deque<Character> list=new LinkedList<>();
        LinkedList<Character> list2=new LinkedList<>();

        //二者有什么不同？ 实际上是没有区别的
        //Deque 是一个接口，LinkedList是一个类  Deque限制了只能使用双向队列的操作  多态的一种体现

        //1.添加元素
        for(int i = 0; i < str2.length(); i++) {
            list.add(str2.charAt(i));
        }
        for(int i = 0; i < str2.length(); i++) {
            list2.add(str2.charAt(i));
        }
        //2.在队头添加元素
        list.addFirst('H');
        list2.addFirst('H');

        //3.在队尾添加元素
        list.addLast('!');
        list2.addLast('!');

        //4.查看队头元素
        System.out.println("队头元素："+list.peekFirst());
        System.out.println("队头元素："+list2.peekFirst());

        //5.查看队尾元素
        System.out.println("队尾元素："+list.peekLast());
        System.out.println("队尾元素："+list2.peekLast());

        //5.删除队头元素    removeFirst()和pollFirst()的区别是：removeFirst()会抛出异常，而pollFirst()不会  
        //同时 reomve方法是删除元素，poll方法是删除并返回元素，remove根据下标删除元素 默认为0，删除第一个元素
        list.pollFirst();
        list2.pollFirst();
        list.removeFirst();
        list2.removeFirst();

        //6.删除队尾元素
        list.pollLast();
        list2.pollLast();

        //7.查看队列大小
        System.out.println("队列大小："+list.size());
        System.out.println("队列大小："+list2.size());

        //8.判断队列是否为空
        System.out.println("队列是否为空："+list.isEmpty());
        System.out.println("队列是否为空："+list2.isEmpty());


        for(Character c : list) {
            System.out.print(c);
        }
        System.out.println();
        for(Character c : list2) {
            System.out.print(c);
        }   
        System.out.println();

        List<Character> list4=new ArrayList<>();
        
        for(int i = 0; i < str2.length(); i++) {
            list4.add(str2.charAt(i));
        }
        list4.remove(0);
        for(int i=0;i<list4.size();i++)
        {
            System.out.print(list4.get(i));
        }

    }
    
}
