class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null || A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        }
        
        List<Integer> sumAB = new ArrayList<>();
        List<Integer> sumCD = new ArrayList<>();
        for (int a : A) {
            for (int b : B) {
                sumAB.add(a + b);
            }
        }
        
        for (int c : C) {
            for (int d : D) {
                sumCD.add(c + d);
            }
        }
        
        Collections.sort(sumAB);
        Collections.sort(sumCD);
        
        int count = 0;
        int prev = 0;
        for (int i = 0; i < sumAB.size(); i++) {
            if (i > 0 && sumAB.get(i) == sumAB.get(i - 1)) {
                count += prev;
            } else {
                prev = binarySearch(sumCD, -sumAB.get(i));
                count += prev;
            }
        }
        
        return count;
    }
    
    public int binarySearch(List<Integer> list, int target) {
        int leftBound = findLeft(list, target);
        int rightBound = findRight(list, target);
        
        if (leftBound == -1) {
            return 0;
        } else {
            return rightBound - leftBound + 1;
        }
    }
    
    public int findLeft(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (list.get(left) == target) {
            return left;
        }
        
        if (list.get(right) == target) {
            return right;
        }
        
        return -1;
    }
    
    public int findRight(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid) <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (list.get(right) == target) {
            return right;
        }
        
        return list.get(left) == target ? left : -1;
    }
}