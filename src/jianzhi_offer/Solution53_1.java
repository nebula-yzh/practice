package jianzhi_offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution53_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int mid=(start+end)/2;
        int cnt=0;
        while(start<=end){
            if(nums[mid]<target){
                start=mid+1;
                mid=(start+end)/2;
            }
            else if(nums[mid]>target){
                end=mid-1;
                mid=(start+end)/2;
            }
            else{
                while(start<=end)
                {
                    if(nums[start]==target){
                        cnt+=1;
                    }
                    start++;
                }
            }
        }
        return cnt;
    }
}
