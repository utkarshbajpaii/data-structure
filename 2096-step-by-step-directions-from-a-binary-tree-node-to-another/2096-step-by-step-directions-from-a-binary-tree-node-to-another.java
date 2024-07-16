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

    private TreeNode lowestCommonAncestor(TreeNode root, int src, int dest) {
        if (root == null) {
            return null;
        }
        
        if (root.val == src || root.val == dest) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, src, dest);
        TreeNode right = lowestCommonAncestor(root.right, src, dest);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }

    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        path.append('L');
        if (findPath(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = lowestCommonAncestor(root, startValue, destValue);

        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();

        findPath(LCA, startValue, lcaToStart);
        findPath(LCA, destValue, lcaToDest);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lcaToStart.length(); i++) {
            result.append('U');
        }

        result.append(lcaToDest);

        return result.toString();
    }
}