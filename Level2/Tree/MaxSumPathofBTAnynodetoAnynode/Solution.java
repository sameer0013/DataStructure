
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

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        return maxPathSum_(root).ntn_maxsum;
    }

    private class PairSum {
        int rtn_maxsum = -(int) 1e9;
        int ntn_maxsum = -(int) 1e9;
    }

    private PairSum maxPathSum_(TreeNode root) {
        if (root == null)
            return new PairSum();

        PairSum lp = maxPathSum_(root.left);
        PairSum rp = maxPathSum_(root.right);

        PairSum myans = new PairSum();
        int rtn_sum = Math.max(lp.rtn_maxsum, rp.rtn_maxsum) + root.val;
        int ntn_sum = getMaximum(lp.ntn_maxsum, rp.ntn_maxsum, lp.rtn_maxsum + root.val + rp.rtn_maxsum, root.val,
                rtn_sum);

        myans.rtn_maxsum = Math.max(rtn_sum, root.val);
        myans.ntn_maxsum = ntn_sum;

        return myans;
    }

    private int getMaximum(int... arr) {
        int max = arr[0];
        for (int ele : arr)
            max = Math.max(max, ele);
        return max;
    }
}