package wiki.laona.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 118. 杨辉三角
 * @author: HuaiAnGG
 * @create: 2021-01-24 23:09
 **/
public class P118_PascalsTriangle {
    public static void main(String[] args) {
        P118_PascalsTriangle pascalsTriangle = new P118_PascalsTriangle();
        List<List<Integer>> generate = pascalsTriangle.generate(5);
        for (List<Integer> integers : generate) {
            System.out.println("integers = " + integers);
        }
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> list;

        for (int i = 0; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    list.add(1);
                }else {
                    Integer num1 = allList.get(i - 1).get(j - 1);
                    Integer num2 = allList.get(i - 1).get(j);
                    list.add(num1 + num2);
                }
            }
            allList.add(list);
        }
        return allList;
    }
}
