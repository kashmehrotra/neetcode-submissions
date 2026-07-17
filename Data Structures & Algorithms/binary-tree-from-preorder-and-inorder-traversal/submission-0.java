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

    int preorder_index = 0;
    Map<Integer, Integer> pos;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    //        1
    //     2     3
    //    4 5   6 7
    //   8

    //    pre 1 2 4 8 5 3 6 7
    //    in  8 4 2 5 1 6 3 7

        pos = new HashMap<>();
        for (int i=0 ; i < inorder.length; i++) {
            pos.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int root_val = preorder[preorder_index++];
        TreeNode root = new TreeNode(root_val);
        int mid = pos.get(root_val);
        root.left = dfs(preorder, l, mid-1);
        root.right = dfs(preorder, mid+1, r);
        return root;
    }
}
