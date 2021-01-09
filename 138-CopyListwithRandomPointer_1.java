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
      return null;
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
      if (h.random != null) {
        h.next.random = h.random.next;
      }
      h = h.next.next;
    }

    Node hOld = head;
    Node hNew = head.next;
    Node ans = head.next;

    while (hOld != null) {
      hOld.next = hNew.next;
      hOld = hOld.next;
      if (hOld != null) {
        hNew.next = hOld.next;
        hNew = hNew.next;
      }
    }
    return ans;
  }
}
