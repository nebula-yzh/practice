package design_patterns_practice.creationalpatterns.factorymethod.example2;

/**
 * @author yingzhihao
 * @date 2022/6/18 15:36
 * @description: 胡椒披萨
 */
public class PepperPizza extends Pizza {
    public PepperPizza() {
        super.setName("胡椒披萨");
    }

    /**
     * 准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
     */
    @Override
    public void prepare() {
        System.out.println("给胡椒披萨准备原材料~");
    }
}
