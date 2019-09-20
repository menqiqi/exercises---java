/**
 * 饿汉式单例
 */

public class Singleton1 {
    private static final Singleton1 SIN = new Singleton1();
    private Singleton1(){};

    public static Singleton1 getInstance(){
        return SIN;
    }
}
