/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {

  public Node solve(Node node, Map<Node, Node> map) {
    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node copyNode = new Node(node.val, new ArrayList<>());
    map.put(node, copyNode);

    for (Node nei : node.neighbors) {
      copyNode.neighbors.add(solve(nei, map));
    }

    return copyNode;
  }

  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }
    return solve(node, new HashMap<>());
  }
}
