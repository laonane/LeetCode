package wiki.laona.leetcode.easy;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 66. 加一
 * @author: HuaiAnGG
 * @create: 2021-01-19 22:28
 **/
public class P066_PlusOne {

    public static void main(String[] args) {
        P066_PlusOne plusOne = new P066_PlusOne();
        int[] digits = new int[]{1, 2, 3};
        System.out.println("digits = " + Arrays.toString(digits));
        int[] res = plusOne.plusOne(digits);
        System.out.println("digits = " + Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 1) {
            digits[0] += 1;
            if (digits[0] == 10) {
                digits = new int[]{1, 0};
            }
            return digits;
        }
        for (int i = len - 1; i >= 0; i--) {
            if ((digits[i] + 1) == 10 && i != 0) {
                digits[i] = 0;
            }else if ((digits[i] + 1) == 10 && i == 0){
                digits = new int[len + 1];
                digits[0] = 1;
            }else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
}
