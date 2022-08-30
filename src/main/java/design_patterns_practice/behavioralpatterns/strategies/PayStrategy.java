package design_patterns_practice.behavioralpatterns.strategies;

/**
 * @author yingzhihao
 * @date 2022/8/30 10:56
 * @description: 通用支付方法接口
 * https://refactoringguru.cn/design-patterns/strategy/java/example#lang-features
 */
public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();

}
