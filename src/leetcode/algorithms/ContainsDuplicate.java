package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Tags: Array, Hash Table
 * Similar Problems: (E) Contains Duplicate II, (M) Contains Duplicate III
 */
public class ContainsDuplicate {

    private ContainsDuplicate cd;

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }
}
