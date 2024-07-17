/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int it:to_delete){
            set.add(it);
        }
        helper(root,result,set);
        if(!set.contains(root.val)){
            result.add(root);
        }
        return result;
    }
    public TreeNode helper(TreeNode root,List<TreeNode> result,Set<Integer> set){
        if(root==null){
            return null;
        }
        root.left=helper(root.left,result,set);
        root.right=helper(root.right,result,set);
        if(set.contains(root.val)){
            if(root.left!=null){
                result.add(root.left);
            }
            if(root.right!=null){
                result.add(root.right);
            }
            return  null;
        }
        return root;
    }
}