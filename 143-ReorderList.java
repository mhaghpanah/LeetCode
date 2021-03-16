/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode h = slow.next;
    slow.next = null;
    ListNode prev = null;
    while (h != null) {
      ListNode tmp = h.next;
      h.next = prev;
      prev = h;
      h = tmp;
    }

    h = head;
    while (prev != null) {
      ListNode tmp = prev.next;
      prev.next = h.next;
      h.next = prev;
      h = prev.next;
      prev = tmp;
    }

  }
}
