package wiki.laona.leetcode.datastructure.deque.circle;

import wiki.laona.leetcode.datastructure.deque.circle.CircleDeque;

/**
 * @program: LeetCode
 * @description: 双向环形队列测试类
 * @author: HuaiAnGG
 * @create: 2021-01-26 02:06
 **/
public class Main {
    public static void main(String[] args) {
        CircleDeque<Integer> circleDeque = new CircleDeque<>();

        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        for (int i = 0; i < 15; i++) {
            circleDeque.enQueueRear(i);
        }
        System.out.println("circleDeque = " + circleDeque);

        System.out.println(" = =======================");
        // null, null, null, null, null, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        for (int i = 0; i < 5; i++) {
            circleDeque.deQueueFront();
            System.out.println("circleDeque = " + circleDeque);
        }
        System.out.println(" = =======================");

        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        for (int i = 4; i >= 0; i--) {
            circleDeque.enQueueFront(i);
        }
        System.out.println("circleDeque = " + circleDeque);

        System.out.println(" = =======================");
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        for (int i = 4; i >= 0; i--) {
            circleDeque.deQueueRear();
            System.out.println("circleDeque = " + circleDeque);
        }
        System.out.println("circleDeque = " + circleDeque);
        System.out.println(" = =======================");
    }
}
