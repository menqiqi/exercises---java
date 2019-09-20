/**
 * 懒汉式单例
 */

public class Singleton2 {
    private static volatile Singleton2 sin;
    private Singleton2(){};

    public static Singleton2 getInstance(){
        if (sin == null){
            //多线程情况下可能会有多个线程进入
            synchronized (Singleton2.class){
                //最先进来的线程进行上锁操作，创建一个Singleton对象时，sin不为空，保证只创建一个对象
                if (sin == null){
                    //如果没有第二层循环，最先进来的线程释放锁后后面的线程也可以继续创建对象，不符合单例模式的标准
                    sin = new Singleton2();
                    //volatile是禁止指令重排，保证了一定是先创建对象载返回对象
                    //sin = new Singleton()是非原子性的，步骤如下：
                    //1）开辟空间 2）属性初始化 3）指向引用对象
                    //假如构造方法中有一些变量需要进行操作，但是因为指令重排，导致先执行1，就直接执行3了，这个时候已经有指向的对象了，直接返回null，就出现了错误
                }
            }
        }
        return sin;
    }
}
