package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author: HuaiAnGG
 * @create: 2021-01-02 23:42
 **/
public class P007_ReverseInteger {
    /**
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * https://leetcode-cn.com/problems/reverse-integer/
     * @param x
     * @return
     */
    public int reverse(int x) {
        Integer num = x;
        char[] chars = num.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("-");
            for (int i = chars.length - 1; i > 0; i--) {
                sb.append(chars[i]);
            }
        } else {
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
