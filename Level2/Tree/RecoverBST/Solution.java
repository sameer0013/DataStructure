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
    TreeNode first,second,prev;
    public void recoverTree(TreeNode root) {
        first=second=null;
        prev = new TreeNode(Integer.MIN_VALUE);
        traverse(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    void traverse(TreeNode root){
        if(root==null) return;
        
        traverse(root.left);
        //Inorder
        if(first==null && prev.val>root.val){
            first =prev;
        }
        
        if(first!=null && prev.val>root.val){
            second = root;
            
        }
        prev = root;
        traverse(root.right);
    }
}