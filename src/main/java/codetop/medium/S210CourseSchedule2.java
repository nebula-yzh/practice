package codetop.medium;

import java.util.*;

/**
 * @author Nebula
 * @date 2022/4/10 17:54
 * @description: TODO
 */
public class S210CourseSchedule2 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                {0, 1}
        };
        int[] order = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    /**
     * 将课程表1进行修改
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        return bfs(numCourses, prerequisites);
    }

    public static int[] bfs(int numCourses, int[][] prerequisites) {
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
            }
        }
        int[] res = new int[numCourses];
        //这部分是广度优先遍历，使用队列、类似层序遍历
        while (!queue.isEmpty()) {
            Integer course = queue.pollFirst();
            //当前出队的课程
            res[count] = course;
            count++;  //出队的时候加
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
                }
            }
        }
        if (count != numCourses) {
            return new int[0];
        }
        return res;
    }
}
