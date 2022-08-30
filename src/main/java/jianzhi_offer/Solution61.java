package jianzhi_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子, easy
 * <p>
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Solution61 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,5,6};
        System.out.println(isStraight(nums));
    }
    public static boolean isStraight(int[] nums) {
        //关键是数组中最大值减除大小王外的最小值<5,nums[max]-nums[joker]<5,joker为大小王个数
        //大小王个数
        int joker = 0;
        //先对数据进行排序
        Arrays.sort(nums);
        //从0到3，四个
        for (int i = 0; i < 4; i++) {
            //计算大小王个数
            if (nums[i] == 0) {
                joker++;
            }
            //若有重复直接返回false
            else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        //进行判断
        return nums[4] - nums[joker] < 5;
    }
}
