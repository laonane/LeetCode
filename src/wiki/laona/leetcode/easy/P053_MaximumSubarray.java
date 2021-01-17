package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 53. 最大子序和
 * @author: HuaiAnGG
 * @create: 2021-01-18 00:07
 **/
public class P053_MaximumSubarray {

    public static void main(String[] args) {
        P053_MaximumSubarray maximumSubarray = new P053_MaximumSubarray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = maximumSubarray.maxSubArray(nums);
        System.out.println("res = " + res);
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for (int x : nums) {
            sum += x;
            if (sum < x) {
                sum = x;
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
