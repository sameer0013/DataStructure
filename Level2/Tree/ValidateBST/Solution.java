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

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        Tri res = isBst(root);
        return res.isbst;
    }

    private class Tri {
        long max;
        long min;
        boolean isbst;

        Tri(long max, long min, boolean isbst) {
            this.max = max;
            this.min = min;
            this.isbst = isbst;
        }
    }

    private Tri isBst(TreeNode root) {
        if (root == null) {
            return new Tri(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }

        Tri left = isBst(root.left);
        Tri right = isBst(root.right);

        long max = Math.max(left.max, Math.max(root.val, right.max));
        long min = Math.min(left.min, Math.min(root.val, right.min));

        if (left.isbst == true && right.isbst == true && left.max < root.val && root.val < right.min) {
            return new Tri(max, min, true);
        } else {
            return new Tri(max, min, false);
        }

    }
}