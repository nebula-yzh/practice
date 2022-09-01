package design_patterns_practice.creationalpatterns.singleton;

/**
 * @author yingzhihao
 * @date 2022/9/1 16:00
 * @description: TODO
 */
public class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck singletonDoubleCheck;

    private SingletonDoubleCheck() {

    }

    public static SingletonDoubleCheck getSingletonDoubleCheck() {
        if (singletonDoubleCheck == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (singletonDoubleCheck == null) {
                    singletonDoubleCheck = new SingletonDoubleCheck();
                }
            }
        }
        return singletonDoubleCheck;
    }
}
