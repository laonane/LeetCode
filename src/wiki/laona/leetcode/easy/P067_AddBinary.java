package wiki.laona.leetcode.easy;

import javafx.scene.effect.Blend;

/**
 * @program: LeetCode
 * @description: 67. 二进制求和
 * @author: HuaiAnGG
 * @create: 2021-01-20 23:11
 **/
public class P067_AddBinary {

    public static void main(String[] args) {
        P067_AddBinary addBinary = new P067_AddBinary();
        String res1 = addBinary.addBinary("11", "1");
        System.out.println("res1 = " + res1);
        String res2 = addBinary.addBinary("1010", "1011");
        System.out.println("res2 = " + res2);
        String res3 = addBinary.addBinary("1011", "11101");
        System.out.println("res3 = " + res3);
    }

    public String addBinary(String a, String b) {
        if (a.charAt(0) == '0') return b;
        if (b.charAt(0) == '0') return a;

        int alen = a.length();
        int blen = b.length();
        StringBuilder str = new StringBuilder();
        char flag = '0';
        if (alen >= blen) {
            for (alen--, blen--; alen >= 0; alen--, blen--) {
                char x = a.charAt(alen);
                char y = '0';
                char z = '0';
                if (blen < 0) {
                    y = '0';
                } else {
                    y = b.charAt(blen);
                }
                z += y;
                z += x;
                z += flag;
                System.out.println("z = " + (int) z);
                if ((int) z == 192) {
                    str.append("0");
                    flag = '0';
                } else if ((int) z == 193) {
                    str.append("1");
                    flag = '0';
                } else if ((int) z == 194) {
                    str.append("0");
                    flag = '1';
                } else if ((int) z == 195) {
                    str.append("1");
                    flag = '1';
                }
            }
        } else {
            for (alen--, blen--; blen >= 0; alen--, blen--) {
                char x = b.charAt(blen);
                char y = '0';
                char z = '0';
                if (alen < 0) {
                    y = '0';
                } else {
                    y = a.charAt(alen);
                }
                z += y;
                z += x;
                z += flag;
                System.out.println("z = " + (int) z);
                if ((int) z == 192) {
                    str.append("0");
                    flag = '0';
                } else if ((int) z == 193) {
                    str.append("1");
                    flag = '0';
                } else if ((int) z == 194) {
                    str.append("0");
                    flag = '1';
                } else if ((int) z == 195) {
                    str.append("1");
                    flag = '1';
                }
            }
        }
        if ( (int)flag == 49) str.append("1");
        return str.reverse().toString();
    }
}
