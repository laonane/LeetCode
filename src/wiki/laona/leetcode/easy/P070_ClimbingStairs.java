package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 70. 爬楼梯
 * @author: HuaiAnGG
 * @create: 2021-01-22 23:19
 **/
public class P070_ClimbingStairs {
    public static void main(String[] args) {
        P070_ClimbingStairs climbingStairs = new P070_ClimbingStairs();
        int step = climbingStairs.climbStairs(5);
        System.out.println("step = " + step);
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int res = 2;
        int prev = 0;
        int curr = 1;
        for (int i = 2; i < n; i++) {
            prev = curr;
            curr = res;
            res = prev + curr;
        }
        return res;
    }
}
