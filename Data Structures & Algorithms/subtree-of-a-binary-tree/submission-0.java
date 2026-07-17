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
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot);
    }

    private boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (areTreesSame(root, subRoot)) {
            return true;
        }
        return helper(root.left, subRoot) || helper(root.right, subRoot);
    }

    private boolean areTreesSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return areTreesSame(root.left, subRoot.left) && areTreesSame(root.right, subRoot.right);
    }
}