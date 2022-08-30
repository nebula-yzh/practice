package codetop.medium;

import java.util.*;

/**
 * @author Nebula
 * @date 2022/4/10 16:03
 * @description: 207. 课程表 medium
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，
 * 其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * <p>
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false
 * <p>
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 **/
public class S207CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                {0, 1}
        };
        boolean b = canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

    /**
     * 1、广度优先搜索BFS
     * 有向无环图/就是拓扑排序
     * 关注入度
     * <p>
     * 使用入度数组:
     * 记录每个课程的初始入度0~numCourses-1
     * 邻接表：使用哈希记录
     * key-课号
     * value-依赖这门课的后续课程（一个数组）
     * <p>
     * 让入度为 0 的课入列，它们是能直接选的课。
     * 然后逐个出列，出列代表着课被选，需要减小相关课的入度。
     * 如果相关课的入度新变为 0，安排它入列、再出列……直到没有入度为 0 的课可入列。
     * <p>
     * 怎么判断能否修完所有课？
     * BFS 结束时，如果仍有课的入度不为 0，无法被选，完成不了所有课。否则，能找到一种顺序把所有课上完。
     * 或者：用一个变量 count 记录入列的顶点个数，最后判断 count 是否等于总课程数。
     *
     * @param numCourses    课程数量
     * @param prerequisites 需要先修课程数组
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return bfs(numCourses, prerequisites);
    }


    /**
     * 广度优先搜索(非递归)
     */
    public static boolean bfs(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        //遍历课程记录入度、邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            in[prerequisites[i][0]]++;
            List<Integer> temp = map.get(prerequisites[i][1]);
            //map中存在当前课程
            if (map.containsKey(prerequisites[i][1])) {
                temp.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], temp);
            } else {
                //不存在当前课程，添加
                List<Integer> courses = new ArrayList<>();
                courses.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], courses);
            }
        }
        //入队课程个数
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        //入队入度为零的课程
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                queue.addLast(i);
                count++;
            }
        }
        //这部分是广度优先遍历，使用队列、类似层序遍历
        while (!queue.isEmpty()) {
            Integer course = queue.pollFirst();
            List<Integer> courses = map.get(course);
            if (courses == null) {
                continue;
            }
            //遍历依赖当前课程的后续课程，减小其入度
            for (Integer cours : courses) {
                in[cours]--;
                //若后续课程入度为0，入队
                if (in[cours] == 0) {
                    queue.addLast(cours);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
