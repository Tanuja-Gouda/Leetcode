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
    public ListNode reverseKGroup(ListNode head, int k) {
        // if(k<=1 || head == null){
        //     return head;
        // }

        // ListNode prev = null;
        // ListNode cur = head;
        // while(true){
        //     ListNode node = cur;
        //     for (int i = 1; i < k && node != null; i++) {
        //         node = node.next;
        //     }
        //     if (node == null) break;


        //     ListNode last = prev;
        //     ListNode newEnd = cur;
        //     ListNode next = cur.next;
        //     for(int i=0;cur!=null && i<k;i++){
        //         cur.next = prev;
        //         prev = cur;
        //         cur = next;
        //         if(cur != null){
        //             next = cur.next;
        //         }
        //     }
        //     if(last != null){
        //         last.next = prev;
        //     }else{
        //         head = prev;
        //     }
        //     newEnd.next = cur;


        //     prev = newEnd;
        // }
        // return head;

        if (k <= 1 || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            ListNode node = prev;
            // Check if there are k nodes left to reverse
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) break;

            ListNode cur = prev.next;
            ListNode next = null;
            ListNode last = cur;

            // Reverse k nodes
            ListNode prevNode = null;
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = prevNode;
                prevNode = cur;
                cur = next;
            }

            // Connect with previous part
            prev.next = prevNode;
            last.next = cur;
            prev = last;
        }

        return dummy.next;
    }
}