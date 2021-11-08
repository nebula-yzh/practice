package codetop.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nebula
 * @date 2021/10/21 20:49
 * @description: 46. 全排列 中等
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class PermutationsS46 {
    public static void main(String[] args) {
        PermutationsS46 permutationsS46 = new PermutationsS46();
        System.out.println(permutationsS46.permute(new int[]{
                1,2,3
        }));
    }
    /**
     * 求出⼀个数组的排列组合中的所有排列，可以使⽤ DFS 深搜。
     * 使用递归，注意深搜返回条件
     * 每个使用的方法相同，找出共性，要使用used数组标记已使用的数字。
     * @param nums
     * @return
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return Collections.emptyList();
        }
        //判断当前数字是否被使用过
        boolean[] used = new boolean[len];
        dfs(nums, used);
        return res;
    }

    public void dfs(int[] nums, boolean[] used) {
        //dfs退出条件，当temp集合满了
        if (temp.size() == nums.length) {
            //将该次排列放入结果res中
            res.add(new ArrayList<>(temp));
            return;
        }
        //每个位置使用的方法相同
        //每次都是循环当前数组，判断是否使用过该数字进行排列
        //将数组中元素挨个放到最前面，对后面的元素进行排列
        for (int i = 0; i < nums.length; i++) {
            //若当前数字被使用过则下一个
            if (used[i]) {
                continue;
            }
            //将当前数字加入temp，并标记为已使用，后续不使用
            temp.add(nums[i]);
            used[i] = true;
            //对当前位置的数字，进行深度优先搜索，找出其可能的排列
            dfs(nums, used);
            //若已找到当前数字的一种排列，移除临时集合中的最后一个数字，并将used置为false
            temp.removeLast();
            used[i] = false;

        }
    }

}
