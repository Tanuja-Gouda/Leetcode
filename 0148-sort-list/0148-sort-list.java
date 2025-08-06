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
    static ListNode getMid(ListNode head)
    {
        ListNode midPrev = null;
        while(head!=null && head.next!=null)
        {
            midPrev = (midPrev==null) ? head : midPrev.next;
            head = head.next.next; 
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    static ListNode merge(ListNode left, ListNode right){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(left!=null && right!=null){
            if(left.val < right.val){
                tail.next = left;
                left = left.next;
                tail = tail.next;
            }else{
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        tail.next = (left!=null) ? left : right;
        return dummyHead.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
}