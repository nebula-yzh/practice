package practice;

import java.util.concurrent.*;

/**
 * @author Nebula
 * @date 2022/4/15 14:32
 * @description: TODO
 */
public class ThreadPoolTest {
    private static final ArrayBlockingQueue<Runnable> BLOCKING_QUEUE = new ArrayBlockingQueue<>(2);
    /**
     * 默认使用 AbortPolicy()丢弃策略
     */
    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(2, 3,
            1, TimeUnit.SECONDS, BLOCKING_QUEUE, Executors.defaultThreadFactory());

    public static void execute(Runnable task) {
        EXECUTOR.execute(task);
    }

    public static <T> Future<T> submit(Callable<T> callable) {
        return EXECUTOR.submit(callable);
    }

    public static ExecutorService getExecutor() {
        return EXECUTOR;
    }
}
