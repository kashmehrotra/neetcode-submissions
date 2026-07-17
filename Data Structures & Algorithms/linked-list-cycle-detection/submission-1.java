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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode curr = head, next = head.next;
        while(curr != null && next != null && curr != next) {
            curr = curr.next;
            next = next.next;
            if (next == null) {
                return false;
            }
            next = next.next;
        }
        return curr == next;
    }
}
