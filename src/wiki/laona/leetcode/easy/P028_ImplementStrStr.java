package wiki.laona.leetcode.easy;

import java.util.concurrent.Delayed;

/**
 * @program: LeetCode
 * @description: 实现C语言 strStr()
 * @author: HuaiAnGG
 * @create: 2021-01-13 16:58
 **/
public class P028_ImplementStrStr {

    public static void main(String[] args) {
        P028_ImplementStrStr implementStrStr = new P028_ImplementStrStr();
        int res = implementStrStr.strStr("mississippi", "issip");
        System.out.println("res = " + res);
    }

    /**
     * 实现 strStr()函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int tarLen = needle.length();
        if (tarLen == 0) return 0;
        int oldLen = haystack.length();
        if (oldLen == 0 || oldLen < tarLen) return -1;
        // int start = -1;
        // int idx = 0;
        // for (int i = 0; i < oldLen; i++) {
        //     if (haystack.charAt(i) == needle.charAt(idx)) {
        //         idx++;
        //         if (start == -1) {
        //             start = i;
        //         }
        //         if (idx == tarLen) {
        //             break;
        //         }
        //     } else {
        //         if (start != -1) {
        //             i -= start;
        //         }
        //         idx = 0;
        //         start = -1;
        //     }
        // }
        // return (start + tarLen) <= oldLen ? start : -1;
        return haystack.indexOf(needle);
    }
}
