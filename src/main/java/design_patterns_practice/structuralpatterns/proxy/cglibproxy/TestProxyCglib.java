package design_patterns_practice.structuralpatterns.proxy.cglibproxy;

/**
 * @author yingzhihao
 * @date 2022/6/25 17:03
 * @description: TODO
 */
public class TestProxyCglib {
    public static void main(String[] args) {
        //目标对象
        UserDao userDao = new UserDao();
        System.out.println(userDao.getClass());
        //代理对象
        UserDao proxyInstance = (UserDao) new ProxyFactory(userDao).getProxyInstance();
        System.out.println(proxyInstance.getClass());
        proxyInstance.save();
    }
}
