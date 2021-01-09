/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node dummyHead = new Node(0);
    Node h0 = head;
    Node h1 = dummyHead;
    while (h0 != null) {
      Node node = new Node(h0.val);
      h1.next = node;
      map.put(h0, node);
      h0 = h0.next;
      h1 = h1.next;
    }

    h0 = head;
    h1 = dummyHead.next;
    while (h0 != null) {
      h1.random = map.get(h0.random);
      h0 = h0.next;
      h1 = h1.next;
    }

    return dummyHead.next;
  }
}
