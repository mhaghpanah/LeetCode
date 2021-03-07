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
    boolean curr = root.val == p.val || root.val == q.val;
    boolean left = solve(root.left, p, q);
    boolean right = solve(root.right, p, q);
    if ((curr && (left || right)) || (left && right)) {
      ans = root;
    }
    return curr || left || right;

  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    solve(root, p, q);
    return ans;
  }
}
