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
        Stack<ListNode> stack=new Stack<>();
        ListNode node=head;
        while(node!=null){
            stack.push(node);
            node=node.next;
        }
        node=stack.pop();
        int max=node.val;
        ListNode result=new ListNode(max);
        while(!stack.isEmpty()){
            node=stack.pop();
            if(node.val<max){
                continue;
            }
            else{
                ListNode newNode=new ListNode(node.val);
                newNode.next=result;
                result=newNode;
                max=node.val;
            }
        }
        return result;
    }
}