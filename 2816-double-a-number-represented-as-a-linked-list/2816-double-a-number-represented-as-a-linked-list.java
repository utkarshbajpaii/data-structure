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
        int lastCarry=list(head);
        if(lastCarry>0){
            ListNode newNode=new ListNode(lastCarry);
            newNode.next=head;
            return newNode;
        }
       return head; 
    }
    int list(ListNode head){
        if(head==null){
            return 0;
        }
        int carry=list(head.next);
        int newVal=(head.val)*2+carry;
        head.val=newVal%10;
        return newVal/10;
    }
}