package design_patterns_practice.creationalpatterns.factorymethod.example1;

/**
 * @author yingzhihao
 * @date 2022/6/18 14:37
 * @description: 所有按钮的公共接口
 * 通用产品接口
 */
public interface Button {
    void render();

    void onClick();
}
