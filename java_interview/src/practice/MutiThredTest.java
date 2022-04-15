package practice;

/**
 * @author Nebula
 * @date 2022/4/15 14:44
 * @description: TODO
 */
public class MutiThredTest {
    public static void main(String[] args) {
        Task task = new Task();
        ThreadPoolTest.execute(task);
        ThreadPoolTest.execute(task);
        ThreadPoolTest.execute(task);
    }
}
