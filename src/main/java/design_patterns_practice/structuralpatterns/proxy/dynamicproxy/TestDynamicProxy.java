package design_patterns_practice.structuralpatterns.proxy.dynamicproxy;

/**
 * @author yingzhihao
 * @date 2022/6/25 15:28
 * @description: 动态代理对象不需要实现接口，
 * 但是要求目标对象必须实现接口，
 * 否则不能使用动态代理。
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        //目标对象
        IUserDao userDao = new UserDao();
        System.out.println(userDao.getClass());

        //代理对象
        IUserDao proxyInstance = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        System.out.println(proxyInstance.getClass());
        proxyInstance.save();  //执行代理方法
    }
}
