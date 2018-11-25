package www.like.java;

/**
 * 使用Condition来实现有界队列
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {
    private Object[] items;
    //队列中当前元素个数
    private int count;
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }
    //添加元素方法，如果当前队列已满，则添加线程进入等待状态，直到有空位被唤醒
    public void add(T t,int addIndex) throws InterruptedException{
        lock.lock();
        try{
            //当前队列已满，添加线程进入等待状态
            while(count == items.length){
                full.await();
            }
            items[addIndex] = t;
            count++;
            empty.signal();
        }finally {
            lock.unlock();
        }
    }
    //删除元素方法，如果当前队列为空，则移除线程进入等待状态直到队列不为空时被唤醒
    public T remove(int removeIndex) throws InterruptedException{
        lock.lock();
        try{
            //当队列为空时，移除线程进入等待状态
            while (count == 0){
                empty.await();
            }
            Object x = items[removeIndex];
            count--;
            full.signal();
            return (T) x;
        }finally {
            lock.unlock();
        }
    }
}
