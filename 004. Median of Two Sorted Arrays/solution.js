/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */

// Time: O(log(m + n)), Space: O(log(m + n))
var findMedianSortedArrays = function(nums1, nums2) {
    if (nums1 === null || nums2 === null) return 0;

    var len = nums1.length + nums2.length;
    if (len % 2 === 0) {
        return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2;
    } else {
        return findKth(nums1, 0, nums2, 0, ~~(len / 2) + 1);
    }
}

var findKth = function(a, startIdxA, b, startIdxB, k) {
    var lenA = a.length, lenB = b.length;

    if (startIdxA >= lenA) {
        return b[startIdxB + k - 1];
    } else if (startIdxB >= lenB) {
        return a[startIdxA + k - 1];
    }

    if (k === 1) {
        return Math.min(a[startIdxA], b[startIdxB]);
    }

    // index starts from 0
    var midIdx = ~~(k / 2) - 1;
    var valA = startIdxA + midIdx >= lenA ? Number.MAX_SAFE_INTEGER : a[startIdxA + midIdx];
    var valB = startIdxB + midIdx >= lenB ? Number.MAX_SAFE_INTEGER : b[startIdxB + midIdx];

    if (valA < valB) {
        return findKth(a, startIdxA + midIdx + 1, b, startIdxB, k - ~~(k / 2));
    } else {
        return findKth(a, startIdxA, b, startIdxB + midIdx + 1, k - ~~(k / 2));
    }
}
