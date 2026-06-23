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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null,null);     
    }
    private boolean validate(TreeNode node , TreeNode left, TreeNode right){
        if(node == null){
            return true;
        }

        if(left != null &&  node.val <= left.val){
            return false;
        }
        if(right != null && node.val >= right.val){
            return false;
        }

        return validate(node.left , left , node) && validate(node.right , node , right);
    }
}