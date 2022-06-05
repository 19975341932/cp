package com.cp.java.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * list去重
 */
public class ListTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("李四", "123456", 20));
        list.add(new Person("张三", "123456", 20));
        list.add(new Person("王五", "123456", 20));
        list.add(new Person("张三", "123456", 20));

        test1(list);
    }

    /**
     * 通过循环集合判断循环的元素，是否已存在于新集合
     * @param list
     */
    private static void test1(List<Person> list) {
        List<Person> newList = new ArrayList<>();
        list.forEach(itme ->{
            if(!newList.contains(itme)){
                newList.add(itme);
            }
        });
        newList.forEach(p -> System.out.println(p));
    }

    private static void test2(List<Person> list) {
        Iterator<Person> iterator = list.iterator();
        while(iterator.hasNext()){
            Person item = iterator.next();
            //如果存在两个相同的值
            if(list.indexOf(item) != list.lastIndexOf(item)){
                //移除相同的值
                iterator.remove();
            }
        }
        list.forEach(p -> System.out.println(p));
    }

    private static void test3(List<Person> list) {
        HashSet<Person> set = new HashSet<>(list);//去重后元素顺序发生了变化
//        LinkedHashSet<Person> set = new LinkedHashSet<>(list);
        set.forEach(itme -> System.out.println(itme));
    }

    private static void test4(List<Person> list) {
        list = list.stream().distinct().collect(Collectors.toList());
    }

}


@Data
@AllArgsConstructor
class Person {
    private String name;
    private String password;
    private int age;
}