package design_patterns_practice.behavioralpatterns.strategies;

/**
 * @author yingzhihao
 * @date 2022/8/30 11:12
 * @description: 信用卡类
 */
public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
