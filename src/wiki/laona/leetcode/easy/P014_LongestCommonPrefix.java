package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author: HuaiAnGG
 * @create: 2021-01-06 23:50
 **/
public class P014_LongestCommonPrefix {


    public static void main(String[] args) {
        P014_LongestCommonPrefix longestCommonPrefix = new P014_LongestCommonPrefix();
        String[] strs1 = {"dog", "racecar", "car"};
        String[] strs2 = {"ab", "a"};
        String[] strs3 = {"cir", "car"};
        String[] strs4 = {"flower", "flow", "flight"};
        String s = longestCommonPrefix.longestCommonPrefix(strs4);
        System.out.println("s = " + s);
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || ch != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

/*    // 第一次提交
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        if (len == 1) {
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        int miniEleLen = strs[0].length();
        for (int i = 1; i < len; i++) {
            if (strs[i].length() < miniEleLen) {
                miniEleLen = strs[i].length();
            }
        }
        // 长度 -1 为字符串最大索引下标
        boolean flag = true;
        for (int i = 0; i < miniEleLen && flag; i++) {
            String tmp = "";
            for (int j = 1; j < len; j++) {
                if (strs[j].charAt(i) == strs[0].charAt(i)) {
                    tmp = strs[0].charAt(i) + "";
                    continue;
                }
                tmp = "";
                flag = false;
                break;
            }
            res.append(tmp);
        }
        return res.toString();
    }*/
}
