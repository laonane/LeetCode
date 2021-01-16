package wiki.laona.leetcode.easy;

/**
 * @program: LeetCode
 * @description: 83. 删除排序链表中的重复元素
 * @author: HuaiAnGG
 * @create: 2021-01-16 21:39
 **/
public class P083_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        P083_RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList =
                new P083_RemoveDuplicatesFromSortedList();
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
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
