package wiki.laona.leetcode.easy;

import java.time.temporal.Temporal;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 合并两个有序链表
 * @author: HuaiAnGG
 * @create: 2021-01-10 21:57
 **/
public class P021_mergeTwoSortedLists {

    public static void main(String[] args) {
        P021_mergeTwoSortedLists mergeTwoSortedLists = new P021_mergeTwoSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2, new ListNode(4));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3, new ListNode(4));
        l2.next.next = new ListNode(4);

        ListNode mergeList = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        System.out.println("mergeList = " + mergeList);
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        // ListNode listNode = new ListNode();
        // ListNode tmpNode = listNode;
        // while (l1 != null) {
        //     while (l2 != null) {
        //         if (l1.val <= l2.val) {
        //             tmpNode.next = l1;
        //             l1 = l1.next;
        //             tmpNode = tmpNode.next;
        //             tmpNode.next = l2;
        //             l2 = l2.next;
        //             tmpNode = tmpNode.next;
        //             break;
        //         }
        //         tmpNode.next = l2;
        //         l2 = l2.next;
        //         tmpNode = tmpNode.next;
        //     }
        //     l1 = l1.next;
        // }


        // while (true) {
        //     if (l1.val >= l2.val) {
        //         tmpNode.next = l2;
        //         l2 = l2.next;
        //         tmpNode = tmpNode.next;
        //         tmpNode.next = l1;
        //         l1 = l1.next;
        //     } else {
        //         tmpNode.next = l1;
        //         l1 = l1.next;
        //         tmpNode = tmpNode.next;
        //         tmpNode.next = l2;
        //         l2 = l2.next;
        //     }
        //     tmpNode = tmpNode.next;
        //     if (l1 == null || l2 == null) {
        //         tmpNode.next = l1 == null ? l2 : l1;
        //         break;
        //     }
        // }
        // return listNode.next;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public void print() {
        ListNode cur = this;
        System.out.print("cur = {");
        while (cur != null) {
            System.out.print(cur.val +  " ->> ");
            cur = cur.next;
        }
        System.out.println(" }");
    }
}
