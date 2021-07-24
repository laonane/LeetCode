package wiki.laona.leetcode.datastructure.queue;

import wiki.laona.leetcode.datastructure.doubly.AbstractList;

/**
 * @program: LeetCode
 * @description: 双向链表
 * @author: HuaiAnGG
 * @create: 2021-01-19 01:51
 **/
public class LinkList<E> extends AbstractList<E> {

    /**
     * 节点类
     *
     * @param <E> 节点类型
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }

    /**
     * 第一个节点
     */
    private Node<E> first;
    private Node<E> last;

    /**
     * 根据下标获取某个元素
     *
     * @param index element index
     * @return 元素
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 替换 index 位置 ele 元素
     *
     * @param index 下标
     * @param ele   元素
     * @return 被替换的元素
     */
    @Override
    public E set(int index, E ele) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = ele;
        return oldElement;
    }

    /**
     * 往 index 位置添加元素
     *
     * @param index 索引下标
     * @param ele   元素
     */
    @Override
    public void add(int index, E ele) {
        rangeCheckForAdd(index);
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, ele, null);
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, ele, next);
            next.prev = node;
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
        }

        size++;
    }

    /**
     * 移除 index 位置的元素
     *
     * @param index 索引
     * @return 被移除的元素
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> next = node.next;
        Node<E> prev = node.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    /**
     * 删除某个元素
     *
     * @param ele 被删除元素
     */
    @Override
    public void remove(E ele) {

    }

    /**
     * 查找第一次出现 ele 的索引
     *
     * @param ele 元素
     * @return 索引值
     */
    @Override
    public int indexOf(E ele) {
        Node<E> node = first;
        if (ele == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(ele)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 清空列表
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    /**
     * 获取 index 位置的节点
     *
     * @param index 位置
     * @return 节点
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = null;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public String toString() {
        Node<E> node = first;
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
