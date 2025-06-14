package com.piorityqueue;

import java.util.PriorityQueue;

//实现自定义排序的优先队列
//java中优先队列常用方法有 
//add(E e) 添加元素 到优先队列
//peek() 查看队列头部元素 不删除        
//poll() 取出队列头部元素 并删除
//remove(Object o) 删除指定元素
//clear() 清空队列
//isEmpty() 判断队列是否为空
//size() 返回队列中元素的个数

//相比c++中优先队列最常用方法是push()和pop()，java中使用add()和poll()来实现
public class Main {
    public static void main(String[] args) {
        // 创建一个优先队列，使用自定义的比较器进行排序
        PriorityQueue<Person> queue = new PriorityQueue<>((p1, p2) -> {
            // 按照姓名首字母的字典序排序 如果姓名相同按年龄升序排序
            int nameComparison = p1.name.compareTo(p2.name);
            if (nameComparison != 0) {
                return nameComparison;
            } else {
                return Integer.compare(p1.age, p2.age);
            }   
        });

        // 添加元素到优先队列
        queue.add(new Person("Alice", 30));
        queue.add(new Person("Bob", 25));
        queue.add(new Person("Charlie", 35));

        // 从优先队列中取出元素
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}



