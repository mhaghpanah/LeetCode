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

  public List<List<Integer>> verticalOrder(TreeNode root) {
    Map<Integer, List<Integer>> map = new TreeMap<>();
    if (root != null) {
      Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
      q.add(new Pair<>(root, 0));
      int t = 0;
      while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
          Pair<TreeNode, Integer> top = q.remove();
          TreeNode node = top.getKey();
          int v = top.getValue();
          map.computeIfAbsent(v, k -> new ArrayList<>()).add(node.val);
          if (node.left != null) {
            q.add(new Pair<>(node.left, v - 1));
          }
          if (node.right != null) {
            q.add(new Pair<>(node.right, v + 1));
          }

        }
        t++;
      }
    }
    return new ArrayList<>(map.values());
  }
}
