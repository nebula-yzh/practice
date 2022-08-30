package design_patterns_practice.creationalpatterns.factorymethod.example1;

/**
 * @author yingzhihao
 * @date 2022/6/18 14:57
 * @description: 另一个按钮的具体创建者
 */
public class WindowsDialog extends DialogFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
