package wiki.laona.leetcode.easy;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 20. 有效的括号
 * @author: HuaiAnGG
 * @create: 2021-01-07 23:14
 **/
public class P020_ValidParentheses {

    public static void main(String[] args) {
        P020_ValidParentheses validParentheses = new P020_ValidParentheses();
        boolean valid = validParentheses.isValid("((");
        System.out.println("valid = " + valid);
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // 空字符串可被认为是有效字符串。
        if (s == null || s.length() == 0) {
            return true;
        } else if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> validStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                validStack.push(s.charAt(i));
            } else {
                if (validStack.empty()){
                    return false;
                }
                Character pop = validStack.pop();
                char c = charAdapter(pop);
                if (c != s.charAt(i)) {
                    return false;
                }
            }
        }
        return validStack.empty();
    }

    char charAdapter(char ch) {
        switch (ch) {
            case '(':
                ch = ')';
                break;
            case '{':
                ch = '}';
                break;
            case '[':
                ch = ']';
                break;
        }
        return ch;
    }
}
