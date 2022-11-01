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

    static int ans;

    private class Pair {
        int val;
        int height;

        Pair(int data) {
            this.val = data;
            this.height = 1;
        }

        Pair(int data, int height) {
            this.val = data;
            this.height = height;
        }
    }

    private Pair helper(TreeNode node) {
        if (node == null)
            return new Pair(Integer.MAX_VALUE, 0);

        Pair left = helper(node.left);
        Pair right = helper(node.right);

        Pair myans = new Pair(node.val);
        if (node.val == left.val && node.val == right.val) {
            ans = Math.max(ans, left.height + right.height + 1);
            myans.height = Math.max(1, Math.max(left.height, right.height) + 1);
            return myans;
        } else if (node.val != left.val && node.val != right.val) {
            myans.height =1;
            ans = Math.max(ans, 1);
            return myans;
        } else if (node.val == left.val) {
            myans.height += left.height;
            ans = Math.max(ans, Math.max(myans.height, right.height));
            return myans;
        } else if (node.val == right.val) {
            myans.height += right.height;
            ans = Math.max(ans, Math.max(myans.height, left.height));
            return myans;
        }

        return null;
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        this.ans = 0;
        helper(root);
        return ans - 1;
    }
}