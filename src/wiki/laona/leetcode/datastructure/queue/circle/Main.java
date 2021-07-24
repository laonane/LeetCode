package wiki.laona.leetcode.datastructure.queue.circle;

/**
 * @program: LeetCode
 * @description: 环形队列测试
 * @author: HuaiAnGG
 * @create: 2021-01-26 01:00
 **/
public class Main {
    public static void main(String[] args) {
        CircleQueue<Integer> circleQueue = new CircleQueue<>();

        for (int i = 0; i < 15; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println("circleQueue = " + circleQueue);

        for (int i = 0; i < 5; i++) {
            circleQueue.deQueue();
        }
        System.out.println("circleQueue = " + circleQueue);

        for (int i = 15; i < 20; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println("circleQueue = " + circleQueue);

        for (int i = 20; i < 35; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println("circleQueue = " + circleQueue);

        while (!circleQueue.isEmpty()) {
            System.out.println("circleQueue.deQueue() = " + circleQueue.deQueue());
        }
    }
}
