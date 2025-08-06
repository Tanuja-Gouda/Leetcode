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

    static ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode reverseList(ListNode cur){
        if(cur == null){
            return cur;
        }
        ListNode prev = null;
        ListNode next = cur.next;
        while(cur!=null){
            cur.next = prev;
            prev=cur;
            cur=next;
            if(cur!=null){
                next = cur.next;
            }
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        ListNode mid = getMid(head);
        ListNode secondHead = reverseList(mid.next);
        mid.next = null;

        while(head!=null && secondHead!=null){
            ListNode temp = head.next;
            head.next = secondHead;
            head = temp;
            temp = secondHead.next;
            secondHead.next = head;
            secondHead = temp;
        }

    }
}