// Time: O(k * logn), where n is the length of nums1
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(nums1.length, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.x + n1.y - n2.x - n2.y;
            }
        });
        
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new Node(nums1[i], nums2[0], 0));
        }
        
        List<int[]> res = new ArrayList<>();
        for (int j = 0; j < k && !pq.isEmpty(); j++) {
            Node n = pq.poll();
            res.add(new int[] {n.x, n.y});
            if (j == k - 1) {
                return res;
            } else {
                if (n.idx < nums2.length - 1) {
                    pq.offer(new Node(n.x, nums2[n.idx + 1], n.idx + 1));
                }
            }
        }
        
        return res;
    }
}

class Node {
    int x, y, idx;
    public Node(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}