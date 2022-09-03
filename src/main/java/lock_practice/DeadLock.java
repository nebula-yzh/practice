package lock_practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yingzhihao
 * @date 2022/8/30 14:58
 * @description: 实现死锁
 * 死锁的条件
 * ● 互斥：被争夺的资源要么分配给了一个进程要么就是可用的
 * ● 请求与保持：已经得到资源的进程依旧可以申请新资源
 * ● 不可抢占：已经分配的资源不可以强制性的被抢占，只能被拥有者显式释放
 * ● 环路等待：有两个或以上的进程形成一条环路。
 * <p>
 * 使用synchronized形成死锁
 */
public class DeadLock {

    public static final Object RESOURCE1 = new Object();
    public static final Object RESOURCE2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        //线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (RESOURCE1) {
                    System.out.println(Thread.currentThread() + "拿到锁1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (RESOURCE2) {
                        System.out.println(Thread.currentThread() + "拿到锁2");
                    }
                }
            }
        });


        //线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (RESOURCE2) {
                    System.out.println(Thread.currentThread() + "拿到锁2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (RESOURCE1) {
                        System.out.println(Thread.currentThread() + "拿到锁1");
                    }
                }
            }
        });

        //thread1.start();
        //thread2.start();
        apiDeadLock();
    }

    /**
     * 通过api锁形成死锁
     * ReentrantLock锁
     */
    public static void apiDeadLock() throws InterruptedException {
        //默认非公平锁
        //等待可中断lock.lockInterruptibly()
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread() + "拿到第一把锁");
                    Thread.sleep(100);
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread() + "拿到第二把锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                    System.out.println(Thread.currentThread() + "锁释放完成");
                }

            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread() + "拿到第二把锁");
                    Thread.sleep(100);
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread() + "拿到第一把锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                    System.out.println(Thread.currentThread() + "锁释放完成");
                }
            }
        });
        thread3.start();
        thread4.start();
        Thread.sleep(1000);
        //中断线程等待，会抛出异常java.lang.InterruptedException
        thread3.interrupt();
    }
}
