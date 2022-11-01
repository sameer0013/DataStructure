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

class Solution2 {
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

    int preidx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preidx=0;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            int  val = inorder[i];
            map.put(val,i);
        }
        return preorderTraversal(preorder,inorder,0,preorder.length-1);
    }

    public TreeNode preorderTraversal(int[] preorder,int[] inorder,int left,int right){
        if(left>right) return null;
        
        int rval = preorder[preidx++];
        TreeNode root = new TreeNode(rval);
        
        int idx = map.get(rval);
        
        root.left = preorderTraversal(preorder,inorder,left,idx-1);
        root.right = preorderTraversal(preorder,inorder,idx+1,right);
        return root;
    }
}
