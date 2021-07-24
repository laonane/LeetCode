package wiki.laona.leetcode.datastructure.queue.circle;

import wiki.laona.leetcode.datastructure.queue.LinkList;

/**
 * @program: LeetCode
 * @description: 环形队列
 * @author: HuaiAnGG
 * @create: 2021-01-26 00:46
 **/
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void enQueue(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 扩容 1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newElements[i] = elements[index(i)];
        }
        // 重置 front
        front = 0;
        elements = newElements;
    }

    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    public E front() {
        return elements[front];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    /**
     * 返回真实索引
     *
     * @param index
     * @return
     */
    private int index(int index) {
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity = ").append(elements.length)
                .append(", front  = ").append(front)
                .append(", size = ").append(size).append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
