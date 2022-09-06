package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yingzhihao
 * @date 2022/9/6 20:42
 * @description: 使用ReentrantLock可重入锁实现
 * 消费者生产者
 */
public class ProduceConsumeTestReentrantLock {

    /**
     * 可重入锁，非公平
     */
    private final ReentrantLock lock = new ReentrantLock();
    /**
     * 两个条件，非空和非满
     * 结合使用
     */
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    /**
     * 当前商品个数
     */
    private int size = 0;
    /**
     * 存储商品的容量
     */
    private int capacity;

    public ProduceConsumeTestReentrantLock(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        ProduceConsumeTestReentrantLock produceConsumeTestReentrantLock = new ProduceConsumeTestReentrantLock(10);
        Thread thread1 = new Thread(() -> {
            try {
                produceConsumeTestReentrantLock.produce1(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                produceConsumeTestReentrantLock.consume1(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * 生产者
     *
     * @param produceRate 生产速率
     */
    public void produce1(int produceRate) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (size >= capacity) {
                    //当前个数大于等于容量时，释放锁，等待消费
                    notFull.await();
                }
                //进行生产
                size += produceRate;
                System.out.println("生产后，当前商品个数：" + size);
                //生产后唤醒消费线程
                notEmpty.signal();
            } finally {
                lock.unlock();
            }

        }

    }

    /**
     * 消费者
     *
     * @param consumeRate 消费速率
     */
    public void consume1(int consumeRate) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (size <= 0) {
                    //释放锁
                    notEmpty.await();
                }
                if (size >= consumeRate) {
                    size -= consumeRate;
                    System.out.println("消费后，当前商品个数：" + size);
                    notFull.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
