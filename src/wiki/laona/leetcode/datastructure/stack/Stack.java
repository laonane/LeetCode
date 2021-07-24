package wiki.laona.leetcode.datastructure.stack;

import java.util.ArrayList;

/**
 * @program: LeetCode
 * @description: 栈
 * @author: HuaiAnGG
 * @create: 2021-01-20 01:57
 **/
public class Stack<E> {
    /**
     * 成员变量
     */
    private ArrayList<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(size() - 1);
    }

    public E top() {
        return list.get(size() - 1);
    }
}
