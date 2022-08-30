package design_patterns_practice.creationalpatterns.factorymethod.example2;

/**
 * @author yingzhihao
 * @date 2022/6/18 15:46
 * @description: TODO
 */
public class CheesePizza extends Pizza {

    public CheesePizza() {
        super.setName("芝士披萨");
    }

    /**
     * 准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
     */
    @Override
    public void prepare() {
        System.out.println("芝士风味披萨原材料~");
    }
}
