/**
 * 简单工厂模式
 * 一个抽象产品类，多个具体产品类，一个工程
 * 优点：简单易于实现，把类的实例交给工厂，易于解耦
 * 缺点：天剑具体产品需要修改工厂，违反了OCP开放封闭原则（对扩展开放，对修改封闭）
 */

import java.util.Scanner;

interface Computer{
    void buyComputer();
}

class Macbook implements Computer{
    @Override
    public void buyComputer() {
        System.out.println("买一个Mac book");
    }
}

class Surfacebook implements Computer{
    @Override
    public void buyComputer() {
        System.out.println("买一个Surface book");
    }
}

class Factory{
    public Computer getInstance(String type){
        Computer computer = null;
        if (type.equals("Macbook")){
            computer = new Macbook();
        }else {
            computer = new Surfacebook();
        }
        return computer;
    }
}

public class Practice195 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String type = in.nextLine();
        Factory factory = new Factory();
        Computer computer = factory.getInstance(type);
        computer.buyComputer();
    }
}