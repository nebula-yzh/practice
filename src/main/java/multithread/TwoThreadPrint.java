package multithread;

/**
 * @author yingzhihao
 * @date 2022/8/30 16:09
 * @description: 两个线程交替打印，需要线程同步,还需要锁,同一把锁
 * notify和notifyAll使用的前提是加锁
 */
public class TwoThreadPrint {
    private static final Object RESOURCE = new Object();
    private static int number = 0;

    public static void main(String[] args) {
        TwoThreadPrint twoThreadPrint = new TwoThreadPrint();
        Thread thread1 = new Thread(() -> twoThreadPrint.print(10), "thread1");
        Thread thread2 = new Thread(() -> twoThreadPrint.print(10), "thread2");
        thread1.start();
        thread2.start();
    }

    public void print(int limit) {
        synchronized (RESOURCE) {
            while (number < limit) {
                try {
                    System.out.println(Thread.currentThread().getName() + " number:" + (number++));
                    RESOURCE.notifyAll();
                    RESOURCE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
