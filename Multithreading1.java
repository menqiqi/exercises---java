package www.bit.java;

/**
 * 写两个线程，一个线程打印 1~52，另一个线程打印A~Z，
 * 打印顺序是12A34B...5152Z；
 */

class Print{
    private int flag = 1;
    private int count = 1;

    public synchronized void printNum(){
        while(flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(2*count-1);
        System.out.print(count*2);
        flag = 2;
        notify();
    }

    public synchronized void printChar(){
        while(flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char) (count-1+'A'));
        //继续前行
        count++;
        flag = 1;
        notify();
    }
}

public class Multithreading1 {
    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        new Thread(()->{
            for (int i = 0;i < 26;i++) {
                print.printNum();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0;i < 26;i++) {
                print.printChar();
            }
        }).start();
    }
}

