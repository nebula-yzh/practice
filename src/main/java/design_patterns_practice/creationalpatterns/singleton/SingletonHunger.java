package design_patterns_practice.creationalpatterns.singleton;

/**
 * @author yingzhihao
 * @date 2022/9/1 17:16
 * @description: TODO
 */
public class SingletonHunger {
    private static final SingletonHunger SINGLETON_HUNGER = new SingletonHunger();

    private SingletonHunger() {

    }

    public SingletonHunger getSingletonHunger() {
        return SINGLETON_HUNGER;
    }
}
