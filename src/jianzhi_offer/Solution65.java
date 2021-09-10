package jianzhi_offer;

public class Solution65 {
    public static void main(String[] args) {
        System.out.println(add(7, 1));
    }

    public static int add(int a, int b) {
        int c;
        while (b != 0) {
            c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
