import java.util.*;

//Definition for a binary tree node.
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

    public List<Integer> reversePreorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            if (root.right == null) {
                ans.add(root.val);
                root = root.left;
            } else {
                TreeNode rootp1 = root.right;
                while (rootp1.left != null && rootp1.left != root) {
                    rootp1 = rootp1.left;
                }

                if (rootp1.left == null) {
                    ans.add(root.val);
                    rootp1.left = root;
                    root = root.right;
                } else if (rootp1.left == root) {

                    rootp1.left = null;
                    root = root.left;
                }
            }
        }
        return ans;
    }

    private void reverse(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            Integer rightval = list.get(right);
            Integer leftval = list.get(left);
            list.set(left, rightval);
            list.set(right, leftval);
            left++;
            right--;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = reversePreorderTraversal(root);

        reverse(ans);

        return ans;

    }
}