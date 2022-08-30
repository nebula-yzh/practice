package design_patterns_practice.creationalpatterns.factorymethod.example2;

/**
 * @author yingzhihao
 * @date 2022/6/18 15:48
 * @description: 简单工厂模式
 * 将创建对象放在工厂中，通过类型判断创建何种子类
 */
public class PizzaSimpleFactory {

    /**
     * 根据类型创建披萨
     * 静态方法
     *
     * @param pizzaType
     * @return
     */
    public static Pizza createPizza2(String pizzaType) {
        Pizza pizza;
        System.out.println("简单工厂模式2");
        switch (pizzaType) {
            case "greek":
                pizza = new GreekPizza();
                break;
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                pizza = null;
                break;
        }
        return pizza;
    }

    /**
     * 根据类型创建披萨
     *
     * @param pizzaType
     * @return
     */
    public Pizza createPizza(String pizzaType) {
        Pizza pizza;
        System.out.println("简单工厂模式");
        switch (pizzaType) {
            case "greek":
                pizza = new GreekPizza();
                break;
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                pizza = null;
                break;
        }
        return pizza;
    }
}
