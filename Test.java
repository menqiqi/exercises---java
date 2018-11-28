package www.like.java;

import java.lang.reflect.Method;

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        //1.拿到Person的Class对象
        Class<?> cls = Person.class;
        //2.创建Person的实例化对象
        Person per = (Person)cls.newInstance();
        //3.拿到setName的Method对象
        Method setMethod = cls.getMethod("setName", String.class);
        //4.通过invoke进行调用
        setMethod.invoke(per,"张三");
        System.out.println(per);
    }
}