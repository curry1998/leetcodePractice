package com.boshrong.leetcode.多线程.自定义同步组件;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {
    // 自定义的Sync 类
    private final Sync sync = new Sync(2);
    //继承自AQS
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if(count <= 0){
                throw new IllegalArgumentException("count must large than zero.");
            }
            // 设置同步器的状态为2
            setState(count);
        }
        // 重写tryAcquireShared 方法
        @Override
        protected int tryAcquireShared(int reducuCount) {
            for(;;){
                int current = getState();
                int newCount = current - reducuCount;
                if(newCount < 0 || compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }
        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for(;;){
                int current = getState();
                int newCount = current + returnCount;
                if(compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }

    }

    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
