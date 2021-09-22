package jianzhi_offer;

/**
 * 剑指 Offer 66. 构建乘积数组 中等
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class Solution66 {

    /**
     * 动态规划 O(n)
     * 计算每个元素左右所有元素的乘积
     * 当用到该元素时，直接将该元素的左右元素乘积相乘即可
     * 普通方法，两层循环，时间复杂度为O(n^2)
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int len = a.length;
        //若数组长度为1，则无左右，返回空数组
        if (len == 1 || len == 0) {
            return new int[0];
        }
        //左右元素乘积数组，不包含自己本身
        int[] resLeft = new int[len];
        int[] resRight = new int[len];
        //最后返回数组
        int[] res = new int[len];
        resLeft[0] = 1;
        resRight[len - 1] = 1;
        //当前元素左边所有元素乘积
        for (int i = 1; i < len; i++) {
            resLeft[i] = resLeft[i - 1] * a[i - 1];
        }
        //当前元素右边所有元素乘积
        for (int i = len - 2; i >= 0; i--) {
            resRight[i] = resRight[i + 1] * a[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = resLeft[i] * resRight[i];
        }
        return res;
    }
}
