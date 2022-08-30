package limit_demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yingzhihao
 * @date 2022/7/8 8:18
 * @description: 计数器限流
 * 控制单位时间内的请求数量
 * 限频
 * 劣势
 * 假设在 00:01时发生一个请求,在 00:01-00:58之间不再发送请求,在 00:59时发送剩下的所
 * 有请求 n-1(n为限流请求数量),在下一分钟的 00:01发送n个请求,
 * 这样在2秒钟内请求 到达了 2n - 1 个.设每分钟请求数量为60个,每秒可以处理1个请求,
 * 用户在 00:59 发送 60 个请求,在01:00 发送 60 个请求 此时2秒钟有120个请求(每秒60个请求),
 * 远远大于了每秒钟处理数量的阈值
 */
public class CounterLimit {
    /**
     * 最大访问数量
     */
    private final int limit;

    /**
     * 访问时间差 ms
     */
    private final long timeout;
    /**
     * 当前计数器
     * 单机时可以这么使用原子类
     * 分布式时可以使用redis作为计数器
     * 可以通过注解形式，对接口进行限流，单机限频
     * 使用redis更简便，通过设置过期时间即可
     */
    private final AtomicInteger reqCount = new AtomicInteger(0);
    /**
     * 请求时间
     */
    private long time = -1L;

    public CounterLimit(int limit, long timeout) {
        this.limit = limit;
        this.timeout = timeout;
    }

    public static void main(String[] args) {
        CounterLimit counterLimit = new CounterLimit(5, 1000);

        for (int i = 0; i < 12; i++) {
            int finalI = i;
            new Thread(() -> {
                if (finalI == 5) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                boolean isLimit = counterLimit.isLimit();
                System.out.println(Thread.currentThread().getName() + " 是否限流：" + isLimit);
            }).start();
        }


    }

    /**
     * 是否限制
     *
     * @return true 是，false 否
     */
    public boolean isLimit() {
        long now = System.currentTimeMillis();
        //第一次访问
        if (time < 0L) {
            time = now;
            int request = reqCount.incrementAndGet();
            System.out.println("first:" + request);
            return request > limit;
        }
        //后续访问
        if (now < time + timeout) {
            // 单位时间内
            int request = reqCount.incrementAndGet();
            System.out.println("request:" + request);
            return request > limit;
        } else {
            //超出单位时间
            time = now;
            //重新开始计数
            reqCount.getAndSet(1);
            return false;
        }
    }

}
