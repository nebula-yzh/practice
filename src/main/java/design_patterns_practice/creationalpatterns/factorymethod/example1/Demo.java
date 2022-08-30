package design_patterns_practice.creationalpatterns.factorymethod.example1;

/**
 * @author yingzhihao
 * @date 2022/6/18 14:59
 * @description: demo执行类
 */
public class Demo {
    private static DialogFactory dialogFactory;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        //根据一定的条件创建对应的对象
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialogFactory = new WindowsDialog();
        } else {
            dialogFactory = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialogFactory.renderWindow();
    }
}
