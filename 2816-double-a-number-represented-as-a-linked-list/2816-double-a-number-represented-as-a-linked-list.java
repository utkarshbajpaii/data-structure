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
    public ListNode doubleIt(ListNode head) {
        head=reverseList(head);
        ListNode prev=null;
        ListNode curr=head;
        int carry=0;
        while(curr!=null){
            int newVal=curr.val*2+carry;
            curr.val=newVal%10;
            if(newVal>=10){
                carry=1;
            }
            else{
                carry=0;
            }
            prev=curr;
            curr=curr.next;
        }
        if(carry!=0){
            ListNode newNode=new ListNode(carry);
            prev.next=newNode;
        }
        return reverseList(head);
    }
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}