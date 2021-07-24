package wiki.laona.leetcode.datastructure.tree.binarysearchtree;

import wiki.laona.leetcode.datastructure.tree.binarysearchtree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author laona
 * @description 二叉树
 * @create 2021-04-14 17:15
 **/
public class BinarySearchTree<E> implements IBinarySearchTree<E>, BinaryTreeInfo {

    /**
     * 长度
     */
    private int size;
    /**
     * 根节点
     */
    private Node<E> root;
    /**
     * 比较器
     */
    private final Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            // 保存父节点
            parent = node;

            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                // 重复
                node.element = element;
                return;
            }
        }

        // 待插入的新节点
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    /**
     * 层序遍历
     * 根节点 -> 左子树 -> 右子树（但是必须是层级递进，不能跳级）
     */
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void postOrder(Visitor<E> visitor) {
        postOrder(root, visitor);
    }

    public void postOrder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        postOrder(node.left, visitor);
        postOrder(node.right, visitor);
        if (visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
    }


    /**
     * 后序遍历(结果肯定是升序或者降序)
     * 左子树 ->  右子树 -> 根
     */
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    /**
     * 后序遍历
     *
     * @param node 节点
     */
    public void postorderTraversal(Node<E> node) {
        if (node == null) return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    public void inOrder(Visitor<E> visitor) {
        inOrder(root, visitor);
    }

    public void inOrder(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        if (visitor.stop) {
            return;
        }
        inOrder(node.left, visitor);
        visitor.stop = visitor.visit(node.element);
        inOrder(node.right, visitor);
    }


    /**
     * 中序遍历(结果肯定是升序或者降序)
     * 左子树 -> 根 ->   右子树
     */
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    /**
     * 中序遍历
     *
     * @param node 节点
     */
    public void inorderTraversal(Node<E> node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    public void preOrder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        preOrder(root, visitor);
    }

    public void preOrder(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        if (visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    /**
     * 前序遍历
     * 根 ->  左子树 -> 右子树
     */
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    /**
     * 前序遍历
     *
     * @param node 节点
     */
    public void preorderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 比较大小
     *
     * @return if e1 equal e2, return 0, if e1 > e2 return 1, if e1 < e2 return -1
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }

        return ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * 判空边界检测
     *
     * @param element 传入参数
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public Object root() {
        return this.root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> mNode = (Node<E>) node;
        String parentString = "null";
        if (mNode.parent != null) {
            parentString = mNode.parent.element.toString();
        }
        return parentString + "_" + ((Node<E>) node).element;
    }

    public void levelOrder(Visitor<E> visitor) {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            // System.out.println(node.element);
            visitor.visit(node.element);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static abstract class Visitor<E> {
        /**
         * 停止标志位
         */
        boolean stop;

        /**
         * @return 返回 true 停止遍历
         */
        abstract boolean visit(E element);
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}

/**
 * 二叉搜索树
 *
 * @param <E> 类型
 */
interface IBinarySearchTree<E> {
    /**
     * 元素数量
     *
     * @return the length of the binary tree
     */
    int size();

    /**
     * 是否为空
     *
     * @return it is not empty return true, else return false
     */
    boolean isEmpty();

    /**
     * 清空二叉搜索树
     */
    void clear();

    /**
     * 添加特定元素到二叉树
     *
     * @param element the specific element
     */
    void add(E element);

    /**
     * 移除特定的元素
     *
     * @param element specific element
     */
    void remove(E element);

    /**
     * 是否包含该元素
     *
     * @param element specific element
     * @return contain the specific element return true, else return false
     */
    boolean contains(E element);
}
