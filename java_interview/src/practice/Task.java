package practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Nebula
 * @date 2022/4/15 14:46
 * @description: TODO
 */
public class Task implements Runnable {
    private final AtomicInteger val = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.print("测试线程池：");
        System.out.println(val.incrementAndGet());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
