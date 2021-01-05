package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 9. 回文数
 * @author: HuaiAnGG
 * @create: 2021-01-05 23:27
 **/
public class P009_palindromeNumber {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int res = 0;
        int tmp = x;
        while(x != 0) {
            res = x % 10  + res * 10;
            x /= 10;
        }
        if(tmp == res) {
            return true;
        }else{
            return false;
        }
    }
}
