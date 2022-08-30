package codetop.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nebula
 * @date 2022/3/5 14:52
 * @description: 78. 子集 中等
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class S78Subsets {
    public static void main(String[] args) {
        S78Subsets s78Subsets = new S78Subsets();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = s78Subsets.subsets(nums);
        subsets.forEach(System.out::println);
    }

    /**
     * 不要被示例的输出顺序所误导
     * <p>
     * 遍历数组，一个个找子集，需要深搜+回溯（使用递归）
     * [1,2,3]
     * [[1,2,3],[1,2],[1,3],[1],[2,3],[2],[3],[]]
     * 可按照此顺序
     * 1.递归返回条件-当前的下标值cur=nums.length,超过数组下标
     * 2.怎么回溯，回到上一状态
     *
     *
     * @param nums
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    /**
     * 深度优先搜索+回溯
     * @param cur
     * @param nums
     */
    public void dfs(int cur,int[] nums){
        //递归结束条件，已经扫描到最后一个元素
        if (cur==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        //每次添加当前元素进subset
        subset.add(nums[cur]);
        //进行下一个元素的深搜，达到条件后退出
        dfs(cur+1,nums);
        //回溯，返回到上一个状态
        subset.remove(subset.size()-1);
        //当前不取，直接进入下一个递归
        dfs(cur+1,nums);
    }
}
