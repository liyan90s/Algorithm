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
        ListNode runner = head.next;
        
        while (walker != runner) {
            if (runner == null || runner.next == null) {
                return false;
            }
            
            walker = walker.next;
            runner = runner.next.next;
        }
        
        return true;
    }
}