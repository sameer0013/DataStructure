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
    class Pair{
        int inc,exc;
        Pair(int inc, int exc){
            this.inc=inc;
            this.exc = exc;
        }
        
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    public int rob(TreeNode root) {
        Pair ans = helper(root);
        return Math.max(ans.inc,ans.exc);
    }
    
    public Pair helper(TreeNode root){
        if(root == null) return new Pair(0,0);
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int include = root.val+left.exc+right.exc;
        int exclude = Math.max(left.inc,left.exc)+Math.max(right.inc,right.exc);
        return new Pair(include,exclude);
    }
}