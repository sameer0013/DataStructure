
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        ArrayList<TreeNode> lis = nodeToRoot(root, target);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < lis.size(); i++) {
            TreeNode node = lis.get(i);
            TreeNode block = null;
            if (i != 0)
                block = lis.get(i - 1);
            kLevelDown(node, k, block, ans);
            k--;
        }
        return ans;
    }

    private void kLevelDown(TreeNode node, int k, TreeNode block, List<Integer> ans) {

        if (node == null)
            return;
        if (node == block)
            return;
        if (k == 0) {
            ans.add(node.val);
            return;
        }
        kLevelDown(node.left, k - 1, block, ans);
        kLevelDown(node.right, k - 1, block, ans);

    }

    private ArrayList<TreeNode> nodeToRoot(TreeNode root, TreeNode target) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (root == null)
            return ans;
        if (root == target) {
            ans.add(root);
            return ans;
        }
        ArrayList<TreeNode> llis = nodeToRoot(root.left, target);
        if (llis.size() != 0) {
            llis.add(root);
            return llis;
        }
        ArrayList<TreeNode> rlis = nodeToRoot(root.right, target);
        if (rlis.size() != 0) {
            rlis.add(root);
            return rlis;
        }

        return ans;
    }
}