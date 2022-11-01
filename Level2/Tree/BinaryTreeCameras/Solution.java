/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
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

    public int minCameraCover(TreeNode root) {
        this.count = 0;
        int status = cameraStatus(root);
        if (status == -1)  // if camera needed to root
            this.count++;
        return count;
    }

    static int count;

    private int cameraStatus(TreeNode root){
        if(root == null) return 1;
        int ls = cameraStatus(root.left);
        int rs = cameraStatus(root.right);
        if(ls==-1||rs==-1){ // camera needed=0
            this.count++;
            return 0;
        }
        else if(ls==0||rs==0){ // already covered=1
            return 1;
        }
        
        return -1; // if both rs and ls is covered then -1
    }
}