/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode kthFromStart = first;
        ListNode kthFromEnd = head;

        while (first.next != null) {
            first = first.next;
            kthFromEnd = kthFromEnd.next;
        }

        int temp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = temp;

        return head;
    }
}