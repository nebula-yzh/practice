package design_patterns_practice.structuralpatterns.proxy.staticproxy;

/**
 * @author yingzhihao
 * @date 2022/6/25 11:33
 * @description: 静态代理类
 * 需要实现IUserDao接口
 */
public class UserDaoProxy implements IUserDao {

    /**
     * 代理目标
     */
    private final IUserDao target;

    /**
     * 通过构造器将代理目标注入
     *
     * @param target
     */
    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启代理");
        target.save();  //执行原来的方法
        System.out.println("结束代理");
    }
}
