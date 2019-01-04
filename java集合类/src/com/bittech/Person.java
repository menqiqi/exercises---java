package com.bittech;

public class Person implements Comparable<Person>{

    private Integer age;

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@Override
    public int compareTo(Person o) {
        //按照年龄排序 升序
        return this.getAge() - o.getAge();
    }*/

    @Override
    public int compareTo(Person o) {
        //按照姓名排序 升序
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
