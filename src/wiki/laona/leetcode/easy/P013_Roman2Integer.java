package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 13. 罗马数字转整数
 * @author: HuaiAnGG
 * @create: 2021-01-05 23:34
 **/
public class P013_Roman2Integer {

    public static void main(String[] args) {
        int result = new P013_Roman2Integer().romanToInt("VII");
        System.out.println("result = " + result);
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * I = 73	V = 86	X = 88	L = 76	C = 67	D = 68	M = 77
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int res = 0;
        int len = ch.length;
        for (int i = 0; i < len; i++) {
            System.out.println("ch = " + ch[i]);
            switch (ch[i]) {
                case 73:
                    // I    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
                    if (i + 1 < len && ch[i + 1] == 86) {
                        res += 4;
                        i++;
                        continue;
                    } else if (i + 1 < len && ch[i + 1] == 88) {
                        res += 9;
                        i++;
                        continue;
                    } else {
                        res += 1;
                    }
                    break;
                case 86:
                    //    V
                    res += 5;
                    break;
                case 88:
                    // X    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
                    if (i + 1 < len && ch[i + 1] == 76) {
                        res += 40;
                        i++;
                        continue;
                    } else if (i + 1 < len && ch[i + 1] == 67) {
                        res += 90;
                        i++;
                        continue;
                    } else {
                        res += 10;
                    }
                    break;
                case 76:
                    //    L
                    res += 50;
                    break;
                case 67:
                    //  C   C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
                    if (i + 1 < len && ch[i + 1] == 68) {
                        res += 400;
                        i++;
                        continue;
                    } else if (i + 1 < len && ch[i + 1] == 77) {
                        res += 900;
                        i++;
                        continue;
                    } else {
                        res += 100;
                    }
                    break;
                case 68:
                    //    D
                    res += 500;
                    break;
                case 77:
                    //    M
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
