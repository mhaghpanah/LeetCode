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
    // System.out.printf("val: %d left: %d right: %d\n", root.val, left, right);
    ans = Math.max(ans, root.val + left + right);
    return Math.max(0, root.val + Math.max(left, right));
  }

  public int maxPathSum(TreeNode root) {
    ans = Integer.MIN_VALUE;
    solve(root);
    return ans;
  }
}
