class Solution {

  public TreeNode helper(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = helper(root.left);
    TreeNode right = helper(root.right);
    if (left == null && right == null) {
      return root;
    } else if (left == null) {
      return right;
    } else if (right == null) {
      root.right = root.left;
      root.left = null;
      return left;
    }
    TreeNode t = root.right;
    root.right = root.left;
    root.left = null;
    left.right = t;
    return right;
  }

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root);
  }
}
