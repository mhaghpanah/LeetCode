/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  int index = 0;

  public void helper(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("null,");
      return;
    }
    sb.append(root.val).append(",");
    helper(root.left, sb);
    helper(root.right, sb);
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    helper(root, sb);
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] strs = data.split(",");
    return solve(strs);
  }

  public TreeNode solve(String[] strs) {
    if (strs[index].equals("null")) {
      index++;
      return null;
    }
    int v = Integer.valueOf(strs[index++]);
    TreeNode ans = new TreeNode(v);
    ans.left = solve(strs);
    ans.right = solve(strs);
    return ans;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
