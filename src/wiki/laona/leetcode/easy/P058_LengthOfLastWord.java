package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 58. 最后一个单词的长度
 * @author: HuaiAnGG
 * @create: 2021-01-18 19:40
 **/
public class P058_LengthOfLastWord {

    public static void main(String[] args) {
        P058_LengthOfLastWord lengthOfLastWord = new P058_LengthOfLastWord();
        int len = lengthOfLastWord.lengthOfLastWord1("Hello World");
        System.out.println("len = " + len);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

    public int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int count = 0;
        while (len-- > 0) {
            if (s.charAt(len) == ' ' && count == 0) {
                continue;
            } else if (s.charAt(len) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
