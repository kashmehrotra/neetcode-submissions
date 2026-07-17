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
    public boolean isValidBST(TreeNode root) {
        List<Integer> bstInorder = new ArrayList<>();
        inorder(root, bstInorder);
        return isInorderInAscendingOrder(bstInorder);
    }

    private void inorder(TreeNode root, List<Integer> bstInorder) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, bstInorder);
        }
        bstInorder.add(root.val);
        if (root.right != null) {
            inorder(root.right, bstInorder);
        }
    }

    private boolean isInorderInAscendingOrder(List<Integer> bstInorder) {
        for (int i=0;i<bstInorder.size()-1;i++) {
            if (bstInorder.get(i) >= bstInorder.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
