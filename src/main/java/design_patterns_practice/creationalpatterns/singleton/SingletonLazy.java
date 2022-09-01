package design_patterns_practice.creationalpatterns.singleton;

/**
 * @author yingzhihao
 * @date 2022/9/1 17:18
 * @description: 懒汉式，线程不安全
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private SingletonLazy() {

    }

    public static SingletonLazy getSingletonLazy() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
