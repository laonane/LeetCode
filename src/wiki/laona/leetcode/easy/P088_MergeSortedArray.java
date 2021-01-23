package wiki.laona.leetcode.easy;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 88. 合并两个有序数组
 * @author: HuaiAnGG
 * @create: 2021-01-23 22:15
 **/
public class P088_MergeSortedArray {

    public static void main(String[] args) {
        P088_MergeSortedArray mergeSortedArray = new P088_MergeSortedArray();
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{1, 2, 3};
        int n = 3;
        // int[] nums1 = new int[]{0, 0};
        // int m = 0;
        // int[] nums2 = new int[]{1};
        // int n = 1;

        mergeSortedArray.merge(nums1, m, nums2, n);

        System.out.println("Arrays = " + Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int len = m + n;
        for (int i = len - 1; i > 0; i--) {
            int max;
            if (n == 0) break;
            if (m == 0) {
                for (int j = n - 1; j > 0; j--, i--) {
                    nums1[i] = nums2[j];
                }
                break;
            } else {
                if (nums1[m - 1] > nums2[n - 1]) {
                    max = nums1[m - 1];
                    --m;
                } else {
                    max = nums2[n - 1];
                    --n;
                }
            }
            nums1[i] = max;
        }

        if (n != 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

    }
}
