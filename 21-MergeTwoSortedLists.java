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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode();
    ListNode h = dummyHead;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        h.next = l2;
        l2 = l2.next;
      } else if (l2 == null || l1.val < l2.val) {
        h.next = l1;
        l1 = l1.next;
      } else {
        h.next = l2;
        l2 = l2.next;
      }
      h = h.next;
    }
    return dummyHead.next;
  }
}
