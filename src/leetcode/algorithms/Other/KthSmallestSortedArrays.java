package leetcode.algorithms.Other;

/**
 * Given two sorted arrays A, B of size m and n respectively. Find the k-th
 * smallest element in the union of A and B. You can assume that there are no
 * duplicate elements.
 * 
 * Tags: Array, 
 */
class KthSmallestSortedArrays {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6 };
        int[] B = { 2, 3, 4, 5, 6, 7 };
        System.out.println(kthSmallest(0, A, B));
        System.out.println(kthSmallest(1, A, B));
        System.out.println(kthSmallest(10, A, B));
        System.out.println(kthSmallest(11, A, B));
        System.out.println(kthSmallest(12, A, B));
        System.out.println(kthSmallest(13, A, B));
    }

    /**
     * Two pointers start from the head of A & B
     * O(k)
     */
    public static int kthSmallest(int k, int[] A, int[] B) {
        k -= 1;
        int lenA = A.length;
        int lenB = B.length;
        if (k < 0 || k > lenA + lenB - 1) return -1; // out of range, 1 <= k <= A.length + B.length
        if (k == 0) return A[0] < B[0] ? A[0] : B[0];
        if (k == lenA + lenB - 1) return A[lenA - 1] < B[lenB - 1] ? B[lenB - 1] : A[lenA - 1];

        int i = 0;
        int j = 0;
        while (i + j < k) {
            if (A[i] < B[j] && i < A.length) {
                i++;
            } else if (A[i] >= B[j] && j < B.length){
                j++;
            }
            if (i + j == k && A[i] < B[j]) {
                return A[i];
            } else if (i + j == k && A[i] >= B[j]) {
                return B[j];
            }
        }
        return -1;
    }
}
