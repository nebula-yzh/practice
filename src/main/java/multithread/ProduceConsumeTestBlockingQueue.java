package multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yingzhihao
 * @date 2022/9/6 21:06
 * @description: 通过阻塞队列的形式实现生产消费者
 * 与synchronized和可重入锁实现不同的是，其生产者和消费者可以同时进行
 * 只有在满，或者空的时候进行阻塞。这才是真正的生产者消费者模型。
 */
public class ProduceConsumeTestBlockingQueue {
    private BlockingQueue<Integer> queue;

    public ProduceConsumeTestBlockingQueue(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public static void main(String[] args) {
        ProduceConsumeTestBlockingQueue produceConsumeTestBlockingQueue = new ProduceConsumeTestBlockingQueue(10);
        Thread thread1 = new Thread(() -> {
            try {
                produceConsumeTestBlockingQueue.produce1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                produceConsumeTestBlockingQueue.consume1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * 生产者
     */
    public void produce1() throws InterruptedException {
        while (true) {
            //进行生产
            queue.put(1);
            System.out.println("生产后，当前商品个数：" + queue.size());
        }

    }

    /**
     * 消费者
     */
    public void consume1() throws InterruptedException {
        while (true) {
            queue.take();
            System.out.println("消费后，当前商品个数：" + queue.size());
        }
    }

}
