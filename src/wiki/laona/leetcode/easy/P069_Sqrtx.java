package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 69. x 的平方根
 * @author: HuaiAnGG
 * @create: 2021-01-21 22:47
 **/
public class P069_Sqrtx {

    public static void main(String[] args) {
        P069_Sqrtx sqrtx = new P069_Sqrtx();
        long sqrt = sqrtx.mySqrt(2147395600);
        System.out.println("sqrt = " + sqrt);
        System.out.println("Math.sqrt(2147395600) = " + Math.sqrt(2147395600));
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        long left = 1;
        long right = x >> 1;
        while (left < right) {
            long mid = (left + right) >> 1;
            long res = mid * mid;
            if (res > x) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return (int) left;

/*        if (x == 0) return 0;
        long count = 1;
        long half = (x >> 1);
        while (count <= half) {
            long res = count * count;
            if (res > x) break;
            count++;
        }
        return (int) (count == 1 ? count : --count);*/
    }
}
