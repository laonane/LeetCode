package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author: HuaiAnGG
 * @create: 2021-01-11 23:44
 **/
public class P026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        P026_RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray =
                new P026_RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums 数组
     * @return 去重后的数组
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}
