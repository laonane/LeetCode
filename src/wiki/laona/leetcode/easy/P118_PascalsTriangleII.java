package wiki.laona.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 118. 杨辉三角
 * @author: HuaiAnGG
 * @create: 2021-01-24 23:09
 **/
public class P118_PascalsTriangleII {
    public static void main(String[] args) {
        P118_PascalsTriangleII pascalsTriangle = new P118_PascalsTriangleII();
        List<Integer> generate = pascalsTriangle.generate(3);
        System.out.println("generate = " + generate);
    }


    public List<Integer> generate(int rowIndex) {
        int len = rowIndex + 1;
        Integer[][] arr = new Integer[len][];
        for (int i = 0; i < len; i++) {
            arr[i] = new Integer[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        return Arrays.asList(arr[rowIndex]);
    }
}
