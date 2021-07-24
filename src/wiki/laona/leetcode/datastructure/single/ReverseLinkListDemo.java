package wiki.laona.leetcode.datastructure.single;

/**
 * @program: LeetCode
 * @description: 翻转链表
 * @author: HuaiAnGG
 * @create: 2021-01-17 00:20
 **/
public class ReverseLinkListDemo {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        listNode5.next = listNode4;
        listNode4.next = listNode3;
        listNode3.next = listNode2;
        listNode2.next = listNode1;

        ListNode reverse = reverse3(listNode5);
        while (reverse != null) {
            System.out.println("reverse = " + reverse.val);
            reverse = reverse.next;
        }
    }



    private static ListNode reverse3(ListNode head) {
        ListNode newList = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = newList;
            newList = head;
            head = node;
        }
        return newList;
    }















    /**
     * 翻转链表
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = newNode;
            newNode = head;
            head = node;
        }
        return newNode;
    }

    private static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;
        // reverse2 的功能是反转链表
        ListNode node = reverse2(head.next);
        // head -> head.next, 经过 reverse2 后，最后一个节点是 head.next
        head.next.next = head;
        // 此时 head 还指向着 head.next
        head.next = null;
        return node;
    }

    static class ListNode {
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
    }
}
