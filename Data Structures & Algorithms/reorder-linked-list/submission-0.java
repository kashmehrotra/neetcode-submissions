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
        Stack<ListNode> stack = new Stack<>();
        ListNode one = head, two = head;
        while(two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        while(one != null) {
            stack.push(one);
            one = one.next;
        }
        ListNode node = head, next;
        while(!stack.isEmpty()) {
            if (node == stack.peek()) {
                node.next = null;
                break;
            }
            next = node.next;
            node.next = stack.pop();
            if (node.next == next) {
                node.next.next = null;
                break;
            }
            node.next.next = next;
            node = next;
        }
    }
}
