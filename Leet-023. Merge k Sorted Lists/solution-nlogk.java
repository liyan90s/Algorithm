/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode dummyHead = new ListNode(0);
        ListNode runner = dummyHead;
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);    
            }            
        }
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            runner.next = node;
            
            runner = runner.next;
            if (node.next != null) {
                pq.add(node.next);    
            }            
        }
        
        return dummyHead.next;
    }
}