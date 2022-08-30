package design_patterns_practice.structuralpatterns.proxy.staticproxy;

/**
 * @author yingzhihao
 * @date 2022/6/25 11:31
 * @description: 目标对象
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("save data!");
    }
}
