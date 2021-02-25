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

  List<String> ans;

  public String toString(List<Integer> list) {
    StringBuilder ans = new StringBuilder();
    for (int a : list) {
      if (ans.length() > 0) {
        ans.append("->");
      }
      ans.append(a);
    }
    return ans.toString();
  }

  public void solve(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    list.add(root.val);
    if (root.left == null && root.right == null) {
      ans.add(toString(list));
    } else {
      solve(root.left, list);
      solve(root.right, list);
    }
    list.remove(list.size() - 1);
  }

  public List<String> binaryTreePaths(TreeNode root) {
    ans = new ArrayList<>();
    solve(root, new ArrayList<>());
    return ans;
  }
}
