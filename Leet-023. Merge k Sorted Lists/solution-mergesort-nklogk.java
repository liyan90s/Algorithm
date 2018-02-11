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
        
        return mergeSort(lists, 0, lists.length - 1);
    }
    
    public ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        
        int mid = left + (right - left) / 2;
        ListNode leftLists = mergeSort(lists, left, mid);
        ListNode rightLists = mergeSort(lists, mid + 1, right);
        
        return merge(leftLists, rightLists);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummyHead = new ListNode(0);
        ListNode runner = dummyHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                runner.next = l1;
                l1 = l1.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
            }
            
            runner = runner.next;
        }
        
        runner.next = l1 != null ? l1 : l2;
        
        return dummyHead.next;
    }
}