/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode runner = dummyHead;
        ListNode walker = dummyHead;
        
        int len = 0;
        while (runner.next != null) {
            runner = runner.next;
            len++;
        }
        
        k = k % len;
        runner = dummyHead;
        for (int i = 0; i < k; i++) {
            runner = runner.next;
        }
        
        while (runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }
        
        runner.next = head;     // update tail first !!
        ListNode newHead = walker.next;
        walker.next = null;
        
        return newHead;
    }
}