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
    public ListNode removeNodes(ListNode head) {
     if(head==null||head.next==null){
         return head;
     }
        ListNode newNode=removeNodes(head.next);
        if(head.val<newNode.val){
            head=null;
            return newNode;
        }
        head.next=newNode;
        return head;
    }
}