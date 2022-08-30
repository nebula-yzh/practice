package design_patterns_practice.structuralpatterns.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author yingzhihao
 * @date 2022/6/25 14:53
 * @description: 动态代理对象
 */
public class ProxyFactory {
    /**
     * 维护一个目标对象，
     * 使用object没有限定对象
     */
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启代理");

                    //执行目标对象方法
                    Object retVal = method.invoke(target, args);

                    System.out.println("结束代理");

                    return retVal;
                });
    }

}
