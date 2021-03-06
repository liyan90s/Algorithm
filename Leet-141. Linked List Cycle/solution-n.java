/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode walker = head;
        ListNode runner = head;
        
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            
            if (walker == runner) {
                return true;
            }
        }
        
        return false;
    }
}