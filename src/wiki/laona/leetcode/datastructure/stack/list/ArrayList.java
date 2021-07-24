package wiki.laona.leetcode.datastructure.stack.list;

import org.omg.CORBA.Object;

/**
 * @program: LeetCode
 * @description:
 * @author: HuaiAnGG
 * @create: 2021-01-16 01:54
 **/
@SuppressWarnings("ALL")
class ArrayList<E> extends AbstractList<E> {

    private E[] elements;
    /**
     * 初始化长度
     */
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E ele) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = ele;
        return old;
    }

    @Override
    public void add(int index, E ele) {
        // if (ele == null) return;
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = ele;
        size++;
    }

    /**
     * 扩容 1.5 倍
     *
     * @param capacity 索引值
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为就容量的 1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        // System.out.println(oldCapacity + " -> " + capacity);
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        trim();
        return old;
    }

    /**
     * 数组动态缩容
     */
    private void trim() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        if (size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;
        // 右移一位，即除2
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public void remove(E ele) {
        remove(indexOf(ele));
    }

    @Override
    public int indexOf(E ele) {
        if (ele == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == ele) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(ele)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
