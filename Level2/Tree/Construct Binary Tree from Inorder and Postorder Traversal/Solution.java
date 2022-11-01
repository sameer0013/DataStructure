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
import java.util.*;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int postidx ;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postidx=postorder.length-1;
        map = new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            int val = inorder[i];
            map.put(val,i);
        }
        
        return revPreorderTraversal(postorder,0,postorder.length-1);
        
        
    }
    
    private  TreeNode revPreorderTraversal(int[] postorder,int left,int right){
        if(left>right) return null;
        
        int rval = postorder[postidx--];
        TreeNode root = new TreeNode(rval);
        
        int idx = map.get(rval);
        
        root.right = revPreorderTraversal(postorder,idx+1,right);
        root.left = revPreorderTraversal(postorder,left,idx-1);
        
        return root;
    }
}