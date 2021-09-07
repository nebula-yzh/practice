package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字 简单
 */
public class Solution39 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        //利用hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //判断map中是否已存在相应的key，不存在，加入该key并赋值0
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            //若存在相同的键，则值加一
            map.put(num, map.get(num) + 1);
        }
        //个数
        int count = 0;
        //最后返回的key值
        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count = entry.getValue();
            //若个数大于等于数组一半，直接返回
            if (count > nums.length / 2) {
                ret = entry.getKey();
            }

        }
        return ret;
    }
}
