package wiki.laona.leetcode.datastructure.stack.list;

/**
 * @program: LeetCode
 * @description: List 抽象类
 * @author: HuaiAnGG
 * @create: 2021-01-16 01:19
 **/
public abstract class AbstractList<E> implements List<E> {

    /**
     * 链表长度
     */
    protected int size;

    /**
     * 列表长度
     *
     * @return 长度
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return empty is true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param ele 元素
     * @return contains is true
     */
    public boolean contains(E ele) {
        return indexOf(ele) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素
     *
     * @param ele 元素
     */
    public void add(E ele) {
        add(size, ele);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
