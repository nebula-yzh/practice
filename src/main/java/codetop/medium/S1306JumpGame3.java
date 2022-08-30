package codetop.medium;

import java.util.LinkedList;

/**
 * @author Nebula
 * @date 2022/4/11 9:41
 * @description: 1306. 跳跃游戏 III MEDIUM
 * 这里有一个非负整数数组arr，你最开始位于该数组的起始下标start处。
 * 当你位于下标i处时，你可以跳到i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * 示例 1：
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 */
public class S1306JumpGame3 {
    public static void main(String[] args) {
        int[] arr = new int[]{
                3, 0, 2, 1, 2
        };
        int start = 2;
        boolean canReach = canReach(arr, start);
        System.out.println(canReach);
    }

    /**
     * 广度优先搜索（类比层序，使用队列）
     * 每次到达一个位置，就对左右进行遍历
     * 直到找到0，或者都找不到，返回false
     * 既可以往左也可以往右
     */
    public static boolean canReach(int[] arr, int start) {

        int len = arr.length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(start);
        //判断是否访问过
        boolean[] isVisited = new boolean[len];
        while (!queue.isEmpty()) {
            Integer tmp = queue.pollFirst();
            isVisited[tmp] = true;
            //满足条件返回
            if (arr[tmp] == 0) {
                return true;
            }
            if (tmp - arr[tmp] >= 0 && !isVisited[tmp - arr[tmp]]) {
                queue.addLast(tmp - arr[tmp]);
            }
            if (tmp + arr[tmp] < len && !isVisited[tmp + arr[tmp]]) {
                queue.addLast(tmp + arr[tmp]);
            }
        }
        return false;
    }

    /**
     * 通过size进行优化，减小时间复杂度
     */
    public static boolean canReach2(int[] arr, int start) {
        int len = arr.length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(start);
        //通过size进行优化，减小时间复杂度
        int size = queue.size();
        //判断是否访问过
        boolean[] isVisited = new boolean[len];
        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                Integer tmp = queue.pollFirst();
                isVisited[tmp] = true;
                //满足条件返回
                if (arr[tmp] == 0) {
                    return true;
                }
                if (tmp - arr[tmp] >= 0 && !isVisited[tmp - arr[tmp]]) {
                    queue.addLast(tmp - arr[tmp]);
                }
                if (tmp + arr[tmp] < len && !isVisited[tmp + arr[tmp]]) {
                    queue.addLast(tmp + arr[tmp]);
                }
            }
        }
        return false;
    }
}
