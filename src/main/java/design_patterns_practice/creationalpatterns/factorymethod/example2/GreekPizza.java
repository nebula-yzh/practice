package design_patterns_practice.creationalpatterns.factorymethod.example2;

/**
 * @author yingzhihao
 * @date 2022/6/18 15:45
 * @description: TODO
 */
public class GreekPizza extends Pizza {
    public GreekPizza() {
        super.setName("希腊披萨");
    }

    /**
     * 准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
     */
    @Override
    public void prepare() {
        System.out.println("希腊风味披萨原材料~");
    }
}
