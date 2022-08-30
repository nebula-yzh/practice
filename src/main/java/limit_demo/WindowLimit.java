package limit_demo;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author yingzhihao
 * @date 2022/7/9 9:54
 * @description: 滑动窗口限流
 * 滑动窗口是对计数器方式的改进, 增加一个时间粒度的度量单位
 * 把一分钟分成若干等分(6份,每份10秒), 在每一份上设置独立计数器,在 00:00-00:09 之间
 * 发生请求计数器累加1.当等分数量越大限流统计就越详细
 */
public class WindowLimit {
    private ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue<>();

    /**
     * 间隔秒数
     */
    private int seconds;

    /**
     * 最大限流
     */
    private int max;


}
