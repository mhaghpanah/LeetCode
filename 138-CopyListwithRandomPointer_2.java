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
    if (head == null) {
      return head;
    }

    Node h = head;
    while (h != null) {
      Node node = new Node(h.val);
      node.next = h.next;
      h.next = node;
      h = node.next;
    }

    h = head;
    while (h != null) {
      Node node = h.next;
      if (h.random != null) {
        node.random = h.random.next;
      }
      h = node.next;
    }

    h = head;
    Node ans = head.next;
    while (h != null) {
      Node cloneH = h.next;
      h.next = h.next.next;
      if (cloneH.next != null) {
        cloneH.next = cloneH.next.next;
      }
      h = h.next;
    }
    return ans;
  }
}
