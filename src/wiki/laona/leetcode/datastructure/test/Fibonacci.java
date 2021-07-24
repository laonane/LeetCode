package wiki.laona.leetcode.datastructure.test;

import wiki.laona.leetcode.util.TimeTool;

import java.sql.Time;

/**
 * @program: LeetCode
 * @description: 斐波那契数列
 * @author: HuaiAnGG
 * @create: 2021-01-12 00:51
 **/
public class Fibonacci {

    public static void main(String[] args) {
        int count = 46;
        TimeTool.check("fib1", new TimeTool.Task() {
            @Override
            public void execute() {
                fib1(count);
            }
        });

        TimeTool.check("fib2", new TimeTool.Task() {
            @Override
            public void execute() {
                fib2(count);
            }
        });
    }

    /**
     * 递归算法
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
