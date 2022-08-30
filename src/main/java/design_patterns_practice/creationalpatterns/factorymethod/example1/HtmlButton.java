package design_patterns_practice.creationalpatterns.factorymethod.example1;

/**
 * @author yingzhihao
 * @date 2022/6/18 14:40
 * @description: html 按钮实现
 * 具体产品
 */
public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
