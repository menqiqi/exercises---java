package www.bit.java;

/**
 * 编写一个程序，启动三个线程，三个线程的名称分别是 A，B，C；
 * 每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABC...
 */

class Print{
    private int flag = 1;
    private int count = 0;

    public synchronized void printA(){
        while(flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        count++;
        flag = 2;
        notifyAll();
    }

    public synchronized void printB(){
        while (flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        count++;
        flag = 3;
        notifyAll();
    }

    public synchronized void printC(){
        while (flag != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        count++;
        flag = 1;
        notifyAll();
    }
    public int getCount(){
        return count;
    }
}

class MyThead implements Runnable{
    Print print = new Print();
    @Override
    public void run() {
        while(print.getCount() < 16){
            if(Thread.currentThread().getName().equals("A")){
                print.printA();
            }
            else if(Thread.currentThread().getName().equals("B")){
                print.printB();
            }
            else if(Thread.currentThread().getName().equals("C")){
                print.printC();
            }
        }
    }
}

public class Multithreading2 {
    public static void main(String[] args) {
        MyThead mt = new MyThead();
        Thread thread1 = new Thread(mt,"A");
        Thread thread2 = new Thread(mt,"B");
        Thread thread3 = new Thread(mt,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
