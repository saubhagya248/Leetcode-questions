/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head){
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }

        if(slow!=fast){
            return null;
        }
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }

        return slow;
    }
    public int getSize(ListNode head){
        ListNode curr = head;
        int size=0;
        while(curr!=null){
            size++;
            curr=curr.next;
        }

        return size;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p2 = headB;
        while(p2.next!=null){
            p2=p2.next;
        }
        p2.next=headB;
        ListNode ans = detectCycle(headA);
        p2.next=null;
        return ans;
    }
}