package edu.tongji.lintcode;

/**
 * lintcode: 35. Reverse Linked List
 * Created by huang on 2019/4/3.
 */
public class Solution_35 {
    private  class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;

        while (currentNode != null) {
            if (currentNode.next == null) {
                currentNode.next = previousNode;
                head = currentNode;
                break;
            }

            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }

        return head;
    }
}
