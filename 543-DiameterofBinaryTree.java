/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

  int ans;

  public int solve(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = solve(root.left);
    int right = solve(root.right);
    ans = Math.max(ans, left + right);
    return Math.max(left, right) + 1;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    ans = 0;
    solve(root);
    return ans;
  }
}
