package www.like.java;

interface IFruit{
    void eat();
}

class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat an apple");
    }
}

class Banana implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat a banana");
    }
}

class Orange implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat an orange");
    }
}

//反射修改工厂方法
class Factory{
    private Factory(){}
    //工厂方法模式
    public static IFruit getInstance(String className){
        IFruit fruit = null;
        try{
            //取得任意子类反射对象
            Class<?> cls = Class.forName(className);
            //通过反射取得实例化对象
            fruit = (IFruit) cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fruit;
    }
}

public class Test5 {
    public static void main(String[] args) throws Exception {
        IFruit fruit = Factory.getInstance("www.like.java.Apple");
        fruit.eat();
    }
}
