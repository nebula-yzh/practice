package jianzhi_offer;

/**
 * 二进制中1的个数 简单
 */
public class Solution15 {
    public static void main(String[] args) {
//        int num = hammingWeight(12);
//        System.out.println(num);
    }

    /**
     *  you need to treat n as an unsigned value
      */
    public static int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            count+=n&1;
            n>>>=1;
        }

        return count;
    }
}
