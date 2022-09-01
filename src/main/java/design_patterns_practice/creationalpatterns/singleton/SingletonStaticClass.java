package design_patterns_practice.creationalpatterns.singleton;

/**
 * @author yingzhihao
 * @date 2022/9/1 17:23
 * @description: 静态内部类，能够实现懒加载
 */
public class SingletonStaticClass {

    private SingletonStaticClass() {

    }

    public SingletonStaticClass getSingletonStaticClass() {
        return Singleton.SINGLETON_STATIC_CLASS;
    }

    private static class Singleton {
        private static final SingletonStaticClass SINGLETON_STATIC_CLASS = new SingletonStaticClass();
    }
}
