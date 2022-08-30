package design_patterns_practice.creationalpatterns.factorymethod.example2;

/**
 * @author yingzhihao
 * @date 2022/6/18 15:32
 * @description: 披萨基类
 */
public abstract class Pizza {

    /**
     * 披萨种类名字
     */
    protected String name;

    /**
     * 准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
     */
    public abstract void prepare();


    /**
     * 烤制
     */
    public void bake() {
        System.out.println(name + " baking;");
    }

    /**
     * 切片
     */
    public void cut() {
        System.out.println(name + " cutting;");
    }

    /**
     * 打包
     */
    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
