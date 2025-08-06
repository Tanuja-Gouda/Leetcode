/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    static int findLength(ListNode slow){
        ListNode temp=slow;
        int length = 0;
        do{
            slow=slow.next;
            length++;
        }while(temp!=slow);
        return length;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = findLength(slow);
                break;
            }
        }

        if(length == 0){
            return null;
        }

        ListNode s = head;
        ListNode f = head;
        while(length>0){
            s = s.next;
            length--;
        }

        while(s != f){
            s = s.next;
            f = f.next;
        }

        return s;
    }
}