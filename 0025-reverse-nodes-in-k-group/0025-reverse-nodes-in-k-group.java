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
        if(k<=1 || head == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        while(true){
            ListNode node = cur;
            for (int i = 1; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) break;


            ListNode last = prev;
            ListNode newEnd = cur;
            ListNode next = cur.next;
            for(int i=0;cur!=null && i<k;i++){
                cur.next = prev;
                prev = cur;
                cur = next;
                if(cur != null){
                    next = cur.next;
                }
            }
            if(last != null){
                last.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = cur;


            prev = newEnd;
        }
        return head;
    }
}