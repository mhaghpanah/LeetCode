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

  public int height(TreeNode node) {
    int h = 0;
    while (node != null) {
      node = node.left;
      h++;
    }
    return h;
  }

  public boolean isExists(TreeNode node, int h, int idx) {
    for (int i = h - 2; i >= 0; i--) {
      if ((idx & (1 << i)) != 0) {
        node = node.right;
      } else {
        node = node.left;
      }
    }
    return node != null;
  }

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int h = height(root);
    int lo = 1 << (h - 1);
    int hi = (1 << h) - 1;
    int ans = lo;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (isExists(root, h, mid)) {
        ans = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return ans;
  }
}
