package com.bittech;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.setName("Jack");
        person1.setAge(23);

        Person person2 = new Person();
        person2.setAge(22);
        person2.setName("Tom");

        Person person3 = new Person();
        person3.setAge(18);
        person3.setName("Alex");

        //1.Person类实现可比较接口

        /*TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(person1);
        treeSet.add(person2);
        treeSet.add(person3);*/

        /*for(Person person:treeSet){
            System.out.println(person);
        }*/

        //2.TreeSet构造方法中传入比较器接口实现类的对象

        //匿名内部类
        /*TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //按年龄排序 降序
                return (o1.getAge()-o2.getAge()) * (-1);
                }
        });*/

        //Lambda表达式
        /*TreeSet<Person> treeSet = new TreeSet<>((o1, o2) ->
                (o1.getAge()-o2.getAge()) * (-1));*/

        //方法引用
        TreeSet<Person> treeSet = new TreeSet<>(TestTreeSet::compare);

        treeSet.add(person1);
        treeSet.add(person2);
        treeSet.add(person3);
        for(Person person:treeSet)
            System.out.println(person);
    }
    public static int compare(Person o1, Person o2){
        return o1.getAge() - o2.getAge();
    }
}
