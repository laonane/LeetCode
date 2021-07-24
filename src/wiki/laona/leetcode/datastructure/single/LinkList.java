package wiki.laona.leetcode.datastructure.single;

/**
 * @program: LeetCode
 * @description:
 * @author: HuaiAnGG
 * @create: 2021-01-19 03:02
 **/
public class LinkList<E> extends AbstractList<E> {

    public static void main(String[] args) {
        List<Integer> linkList = new LinkList<>();
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        linkList.add(5);
        linkList.add(6);
        linkList.remove(0);
        linkList.remove(linkList.size() - 1);
        linkList.add(3, 11);
        linkList.add(0, 4444);
        System.out.println("linkList = " + linkList);
        linkList.clear();
        System.out.println("linkList = " + linkList);
    }

    /**
     * 节点类
     *
     * @param <E> 节点类型
     */
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 第一个节点
     */
    private Node<E> first;

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
        if (index == 0) {
            Node<E> node = first;
            first = new Node<>(ele, node);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<E>(ele, prev.next);
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

        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
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

    }

    /**
     * 获取 index 位置的节点
     *
     * @param index 位置
     * @return 节点
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(node.element);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
