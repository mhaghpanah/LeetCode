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

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Stack<TreeNode> nodeStack = new Stack<>();
    Stack<String> pathStack = new Stack<>();
    nodeStack.push(root);
    pathStack.push(Integer.toString(root.val));

    while (!nodeStack.isEmpty()) {
      TreeNode top = nodeStack.pop();
      String path = pathStack.pop();
      if (top.left == null && top.right == null) {
        ans.add(path);
      }

      if (top.left != null) {
        nodeStack.push(top.left);
        pathStack.push(path + "->" + top.left.val);
      }

      if (top.right != null) {
        nodeStack.push(top.right);
        pathStack.push(path + "->" + top.right.val);
      }
    }

    return ans;
  }
}
