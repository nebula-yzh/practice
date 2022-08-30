package design_patterns_practice.creationalpatterns.factorymethod.example1;

/**
 * @author yingzhihao
 * @date 2022/6/18 14:56
 * @description: 具体按钮的创建者
 */
public class HtmlDialog extends DialogFactory {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
