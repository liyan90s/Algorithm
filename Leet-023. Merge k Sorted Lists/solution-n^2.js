/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */


// Time: O(nk^2)
// Note: time complexity is not O(nk) !! Because everytime when 2 lists get merged, 
//       the length of the list1 increases. Thus, elements in list1 are actually 
//       compared multiple times.
//       e.g.: 
//       the length of k lists are: n, n, 2n, 4n, 8n, ...kn -> [(1 + k)k / 2]n -> nk^2
var mergeKListsNaive = function(lists) {
    if (lists === null || lists.length === 0) return null;
    
    var list1 = lists[0];
    for (var i = 1; i < lists.length; i++) {
        list1 = mergeTwoLists(list1, lists[i]);
    }
    
    return list1;
};

var mergeTwoLists = function(l1, l2) {
    var dummyHead = new ListNode(0);
    var curr = dummyHead;
    
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    
    curr.next = l1 !== null ? l1 : l2;
    
    return dummyHead.next;
};