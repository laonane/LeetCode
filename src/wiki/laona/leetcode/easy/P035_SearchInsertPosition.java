package wiki.laona.leetcode.easy;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 35. 搜索插入位置
 * @author: HuaiAnGG
 * @create: 2021-01-14 22:23
 **/
public class P035_SearchInsertPosition {

    public static void main(String[] args) {
        P035_SearchInsertPosition insertPosition = new P035_SearchInsertPosition();
        int[] nums = new int[]{1, 3};
        int target = 2;
        System.out.println("nums = " + Arrays.toString(nums));
        int pos = insertPosition.searchInsert(nums, target);
        System.out.println("pos = " + pos);
        System.out.println("nums = " + Arrays.toString(nums));
    }


    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0]) {
            return 0;
        }
        int len = nums.length;
        int pos = len;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target <= nums[mid]) {
                right = mid - 1;
                pos = mid;
            }else {
                left = mid + 1;
            }
        }
        return pos;


        // if (nums.length == 0 || target <= nums[0]) {
        //     nums = new int[1];
        //     nums[0] = target;
        //     return 0;
        // }
        // int pos = 0;
        // int len = nums.length;
        // if (target > nums[len - 1]) return len;
        // for (int i = 1; i < len ; i++) {
        //     if (target <= nums[i]) {
        //         pos = i;
        //         break;
        //     } else {
        //         pos = i + 1;
        //     }
        // }
        // return pos;

        // if (nums.length == 0 || target <= nums[0]) {
        //     nums = new int[1];
        //     nums[0] = target;
        //     return 0;
        // }
        // int pos = 0;
        // int len = nums.length;
        // if (target > nums[len - 1]) return len + 1;
        // for (int i = 1; i < len; i++) {
        //     if (target <= nums[i]) {
        //         pos = i;
        //         break;
        //     } else {
        //         pos = i + 1;
        //     }
        // }
        // return pos;

    }
}
