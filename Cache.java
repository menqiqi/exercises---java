package www.like.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁实现缓存
 */

public class Cache {
    static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock readLock = rwl.readLock();
    static Lock writeLock = rwl.writeLock();

    /**
     * 线程安全的根据一个key获取value
     * @param key
     * @return
     */

    public static final Object get(String key){
        readLock.lock();
        try{
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    /**
     * 线程的安全根据key设置value，并返回旧的value
     * @param key
     * @param value
     * @return
     */

    public static final Object put(String key,Object value){
        writeLock.lock();
        try{
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

    /**
     * 线程安全的清空所有的value
     */

    public static final void clear(){
        writeLock.lock();
        try{
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }
}
