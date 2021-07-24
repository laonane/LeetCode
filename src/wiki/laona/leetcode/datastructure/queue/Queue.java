package wiki.laona.leetcode.datastructure.queue;

/**
 * @program: LeetCode
 * @description: 队列
 * @author: HuaiAnGG
 * @create: 2021-01-22 00:41
 **/
public class Queue<E> {
    private LinkList<E> list = new LinkList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "list=" + list +
                '}';
    }
}
