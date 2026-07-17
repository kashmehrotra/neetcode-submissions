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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1, head);
        ListNode first = res, second = res;
        while(n > 0) {
            second = second.next;
            n--;
        }
        while(second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return res.next;
    }























    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode res = new ListNode(0, head);
    //     ListNode first = res, second = res;
    //     while(n > 0) {
    //         second = second.next;
    //         n--;
    //     }
    //     while(second.next != null) {
    //         first = first.next;
    //         second = second.next;
    //     }
    //     first.next = first.next.next;
    //     return res.next;
    // }

    // public ListNode removeNthFromEnd2(ListNode head, int n) {
    //     int len = length(head);
    //     if (len == 0 || n > len) {
    //         return head;
    //     }
    //     if (len == 1 && n == 1) {
    //         return null;
    //     }
    //     if (len == n) {
    //         return head.next;
    //     }
    //     int num = len-n;
    //     ListNode curr = head;
    //     while(num != 1) {
    //         num--;
    //         curr = curr.next;
    //     }
    //     curr.next = curr.next.next;
    //     return head;
    // }

    // private int length(ListNode head) {
    //     int len = 0;
    //     while(head != null) {
    //         len++;
    //         head = head.next;
    //     }
    //     return len;
    // }
}