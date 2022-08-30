package design_patterns_practice.behavioralpatterns.strategies;

/**
 * @author yingzhihao
 * @date 2022/8/30 11:14
 * @description: 订单类
 */
public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    /**
     * 订单处理
     *
     * @param strategy 处理策略-不同支付方式
     */
    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
        // Here we could collect and store payment data from the strategy.
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
