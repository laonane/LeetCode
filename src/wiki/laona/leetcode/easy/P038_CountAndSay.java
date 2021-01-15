package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 38. 外观数列
 * @author: HuaiAnGG
 * @create: 2021-01-15 23:19
 **/
public class P038_CountAndSay {

    public static void main(String[] args) {

        P038_CountAndSay countAndSay = new P038_CountAndSay();
        String say = countAndSay.countAndSay(5);
        System.out.println("say = " + say);
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        String res = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) == res.charAt(i - 1)) {
                count++;
            } else if (i == 1) {
                sb.append(count).append(res.charAt(0));
                count = 1;
            } else {
                sb.append(count).append(res.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(res.charAt(res.length() - 1));
        return sb.toString();
    }
}
