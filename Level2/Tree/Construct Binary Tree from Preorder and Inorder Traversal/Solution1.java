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
class Solution1 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preidx = 0;
        return preorderTraversal(preorder, inorder, 0, preorder.length - 1);
    }

    private int findInInorder(int[] inorder, int left, int right, int rval) {
        while (left <= right) {
            if (inorder[left] == rval)
                return left;
            left++;
        }
        return -1;
    }

    public TreeNode preorderTraversal(int[] preorder, int[] inorder, int left, int right) {
        if (left > right)
            return null;

        int rval = preorder[preidx++];
        TreeNode root = new TreeNode(rval);

        int idx = findInInorder(inorder, left, right, rval);

        root.left = preorderTraversal(preorder, inorder, left, idx - 1);
        root.right = preorderTraversal(preorder, inorder, idx + 1, right);
        return root;
    }
}