package wiki.laona.leetcode.datastructure.deque;

/**
 * @program: LeetCode
 * @description: 双端队列
 * @author: HuaiAnGG
 * @create: 2021-01-26 00:31
 **/
public class Deque<E> {

    private List<E> list = new LinkList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueueRear(E element) {
        list.add(element);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public void enQueueFront(E element) {
        list.add(0, element);
    }

    public void clear() {
        list.clear();
    }

    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    public E front() {
        return list.get(0);
    }

    public E rear() {
        return list.get(list.size() - 1);
    }
}
