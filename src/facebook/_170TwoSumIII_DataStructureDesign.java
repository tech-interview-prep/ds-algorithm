package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Utils;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 *
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 *
 */
public class _170TwoSumIII_DataStructureDesign {
    public static void main(String[] args) {
        Solution_TwoSum sol = new Solution_TwoSum();

        Utils.printTestArrayln(sol.twoSum_HashMap(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1});
        Utils.printTestArrayln(sol.twoSum_HashMap(new int[] {7, 11, 2, 15}, 9), new int[] {0, 2});
    }
}

class Solution_TwoSumIII_DataStructureDesign {
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)) map.put(number, map.get(number) + 1);
        else {
            map.put(number, 1);
            list.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i), num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------//

    // Add the number to an internal data structure.
    public void add2(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find2(int value) {
        for (Integer key : map.keySet()) {
            if (map.containsKey(value - key)) {
                if (value - key != key) {
                    return true;
                } else if (map.get(key) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
