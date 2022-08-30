package design_patterns_practice.creationalpatterns.factorymethod.example1;

/**
 * @author yingzhihao
 * @date 2022/6/18 14:48
 * @description: 基础工厂类
 * 工厂只是类的一个角色。它应该有一些核心业务逻辑
 * 需要创建不同不同的产品
 */
public abstract class DialogFactory {
    public void renderWindow() {
        // ... 其他业务逻辑代码 ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * 子类将会重写该方法，去创建具体的按钮
     *
     * @return 具体的按钮
     */
    public abstract Button createButton();
}
