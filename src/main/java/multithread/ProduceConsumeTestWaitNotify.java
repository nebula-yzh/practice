package multithread;

/**
 * @author yingzhihao
 * @date 2022/9/6 18:47
 * @description: 生产者消费者测试
 * 生产者，一直生产商品，当商品现有个数大于等于容量，则停止生产，直到个数小于容量
 * 消费者，一直消费商品，当商品现有个数小于等于0，则停止消费，直到个数大于0
 * <p>
 * 使用wait notifyAll，synchronized 实现，生产者消费者，基本是交替进行。
 * 同一时刻只有生产者或消费者其中一个在执行，因为锁，只有拿到锁的线程才能执行
 * 无论通过synchronized还是可重入锁，都是交替进行，因为需要唤醒对方。
 */
public class ProduceConsumeTestWaitNotify {
    /**
     * 当前商品个数
     */
    private int size = 0;
    /**
     * 存储商品的容量
     */
    private int capacity;

    public ProduceConsumeTestWaitNotify(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        ProduceConsumeTestWaitNotify produceConsumeTestWaitNotify = new ProduceConsumeTestWaitNotify(10);
        Thread thread1 = new Thread(() -> {
            try {
                produceConsumeTestWaitNotify.produce1(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                produceConsumeTestWaitNotify.consume1(1);
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
            synchronized (this) {
                while (size >= capacity) {
                    //当前个数大于等于容量时，释放锁，等待消费
                    wait();
                }
                //进行生产
                size += produceRate;
                System.out.println("生产后，当前商品个数：" + size);
                //生产后唤醒消费线程
                notifyAll();
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
            synchronized (this) {
                while (size <= 0) {
                    //释放锁
                    wait();
                }
                if (size >= consumeRate) {
                    size -= consumeRate;
                    System.out.println("消费后，当前商品个数：" + size);
                    notifyAll();
                }
            }
        }
    }
}
