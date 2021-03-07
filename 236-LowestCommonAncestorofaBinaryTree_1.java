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

  TreeNode ans;

  public boolean solve(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }
    int curr = root.val == p.val || root.val == q.val ? 1 : 0;
    int left = solve(root.left, p, q) ? 1 : 0;
    int right = solve(root.right, p, q) ? 1 : 0;
    if ((curr + left + right) == 2) {
      ans = root;
    }
    return curr + left + right != 0;

  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    solve(root, p, q);
    return ans;
  }
}
