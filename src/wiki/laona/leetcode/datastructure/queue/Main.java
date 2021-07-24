package wiki.laona.leetcode.datastructure.queue;

/**
 * @program: LeetCode
 * @description: 测试
 * @author: HuaiAnGG
 * @create: 2021-01-22 00:41
 **/
public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);  // 2, 3, 4, 5, 6

        while (!queue.isEmpty()) {
            System.out.println("queue = " + queue.deQueue());
        }
    }
}
