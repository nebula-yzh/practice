package design_patterns_practice.creationalpatterns.factorymethod.example2;

/**
 * @author yingzhihao
 * @date 2022/6/18 16:06
 * @description: TODO
 */
public class OrderPizza {

    public Pizza order(String pizzaType) {
        Pizza pizza = PizzaSimpleFactory.createPizza2(pizzaType);

        //制作披萨
        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } else {
            System.out.println("订购披萨失败~");
        }

        return pizza;
    }

}
