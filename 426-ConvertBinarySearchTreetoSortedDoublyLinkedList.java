/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

  public void inOrder(Node node, List<Node> ans) {
    if (node == null) {
      return;
    }
    inOrder(node.left, ans);
    ans.add(node);
    inOrder(node.right, ans);
  }

  public Node treeToDoublyList(Node root) {
    List<Node> ans = new ArrayList<>();
    inOrder(root, ans);

    Node prev = null;
    for (Node node : ans) {
      node.left = prev;
      node.right = null;
      if (prev != null) {
        prev.right = node;
      }
      prev = node;
    }

    int n = ans.size();
    if (n == 0) {
      return null;
    }

    Node first = ans.get(0);
    Node last = ans.get(n - 1);
    first.left = last;
    last.right = first;
    return first;
  }
}
