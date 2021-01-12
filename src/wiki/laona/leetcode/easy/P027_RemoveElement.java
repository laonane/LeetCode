package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 移除元素
 * @author: HuaiAnGG
 * @create: 2021-01-12 22:48
 **/
public class P027_RemoveElement {
    public static void main(String[] args) {
        P027_RemoveElement removeElement = new P027_RemoveElement();
        int[] nums = new int[]{3,2,2,3};
        int count = removeElement.removeElement(nums, 3);
        for (int i = 0; i < count; i++) {
            System.out.println("nums[i] = " + nums[i]);
        }
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[fast++] = nums[i];
            }
        }
        return fast;
    }
}
