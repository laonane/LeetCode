package wiki.laona.leetcode.datastructure.deque;

/**
 * @program: LeetCode
 * @description: 测试
 * @author: HuaiAnGG
 * @create: 2021-01-22 00:41
 **/
public class Main {

    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<>();
        queue.enQueueFront(4);
        queue.enQueueFront(3);
        queue.enQueueFront(2);
        queue.enQueueRear(5);
        queue.enQueueRear(6);  // 2, 3, 4, 5, 6

        while (!queue.isEmpty()) {
            System.out.println("queue = " + queue.deQueueRear());
        }
    }
}
