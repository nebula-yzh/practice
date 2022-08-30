package design_patterns_practice.structuralpatterns.proxy.staticproxy;

/**
 * @author yingzhihao
 * @date 2022/6/25 11:36
 * @description: 测试类
 * 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 */
public class TestProxy {
    public static void main(String[] args) {
        //目标对象
        IUserDao target = new UserDao();

        //代理对象
        IUserDao userDaoProxy = new UserDaoProxy(target);

        userDaoProxy.save();
    }
}
