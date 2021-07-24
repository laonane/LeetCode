package wiki.laona.leetcode.datastructure.deque.circle;

/**
 * @program: LeetCode
 * @description: 循环双端队列
 * @author: HuaiAnGG
 * @create: 2021-01-26 01:45
 **/
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
    private int front;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return elements.length;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    /**
     * 从队尾入队
     *
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }

    /**
     * 从对头出队
     *
     * @return
     */
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 从对头入队
     *
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);

        front = index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从队尾出队
     *
     * @return
     */
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E element = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return element;
    }

    /**
     * 查看头部元素
     *
     * @return
     */
    public E front() {
        return elements[front];
    }

    /**
     * 查看对位元素
     *
     * @return
     */
    public E rear() {
        return elements[index(size - 1)];
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
    }


    /**
     * 动态扩容
     *
     * @param capacity
     */
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

    /**
     * 返回真实索引
     *
     * @param index
     * @return
     */
    private int index(int index) {
        index += front;
        if (index < 0) return index + elements.length;
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
