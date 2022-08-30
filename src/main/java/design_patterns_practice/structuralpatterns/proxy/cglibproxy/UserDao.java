package design_patterns_practice.structuralpatterns.proxy.cglibproxy;

/**
 * @author yingzhihao
 * @date 2022/6/25 16:56
 * @description: 目标对象，无需实现接口
 */
public class UserDao {

    public void save() {
        System.out.println("保存数据");
    }
}
