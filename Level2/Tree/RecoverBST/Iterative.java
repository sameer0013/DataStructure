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
class Iterative {
    TreeNode first,second,prev;
    public void recoverTree(TreeNode root) {
        first = null;
        second =null;
        prev = new TreeNode(Integer.MIN_VALUE);
        while(root!=null){
            if(root.left==null){
                set(root);
                root=root.right;
            }else{
                TreeNode rnode = root.left;
                while(rnode.right!=null &&rnode.right!=root){
                    rnode = rnode.right;
                }
                if(rnode.right==null){
                    rnode.right = root;
                    root=root.left;
                }else if(rnode.right==root){
                    set(root);
                    rnode.right=null;
                    root = root.right;
                }
                
            }
        }
        
        int tmp = first.val;
        first.val = second.val;
        second.val= tmp;
    }
    private void set(TreeNode root){
        if(first == null && prev.val>root.val){
            first = prev;
         }
         if(first!=null && prev.val>root.val){
                second = root;
         }
        prev=root;
    }
}
