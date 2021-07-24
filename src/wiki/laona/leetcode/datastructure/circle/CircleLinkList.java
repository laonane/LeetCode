package wiki.laona.leetcode.datastructure.circle;


/**
 * @program: LeetCode
 * @description: 双向循环链表
 * @author: HuaiAnGG
 * @create: 2021-01-19 01:51
 **/
public class CircleLinkList<E> extends AbstractList<E> {

    /**
     * 约瑟夫问题
     */
    static void Josephus() {
        CircleLinkList<Integer> list = new CircleLinkList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        // 指向头节点（指向1）
        list.reset();
        System.out.println("list = " + list);
        while (!list.isEmpty()) {
            list.next();
            list.next();
            list.remove();
            System.out.println("list = " + list);
        }
    }


    public static void main(String[] args) {
        List<Integer> linkList = new CircleLinkList<>();
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        linkList.add(5);
        linkList.add(6);  // 2, 3, 4, 5, 6
        linkList.remove(0); //  3, 4, 5, 6
        linkList.remove(linkList.size() - 1);  //  3, 4, 5
        linkList.add(3, 6);        //  3, 4, 5, 6
        linkList.add(0, 222);      //  222, 3, 4, 5, 6
        linkList.add(linkList.size(), 777); //  222, 3, 4, 5, 6, 777
        System.out.println("linkList = " + linkList);
        linkList.clear();
        System.out.println("linkList = " + linkList);

        Josephus();
    }

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
    private Node<E> current;

    public void reset() {
        this.current = first;
    }

    public E next() {
        if (current == null) return null;
        current = current.next;
        return current.element;
    }

    public E remove() {
        if (current == null) return null;

        Node<E> next = current.next;
        E element = remove(current);

        if (size == 0) {
            current = null;
        } else {
            current = next;
        }

        return element;
    }

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
            last = new Node<>(oldLast, ele, first);
            if (oldLast == null) {
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, ele, next);
            next.prev = node;
            prev.next = node;
            if (index == 0) {
                first = node;
                last.next = first;
                first.prev = last;
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
        return remove(node(index));
    }

    private E remove(Node<E> node) {
        if (size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> next = node.next;
            Node<E> prev = node.prev;
            prev.next = next;
            next.prev = prev;
            if (node == first) {    // index == 0
                first = next;
            }
            if (node == last) {     // index == size -1
                last = prev;
            }
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
            sb.append(node.element);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
