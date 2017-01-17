package leetcode.algorithms.level.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by
 * column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *      /\
 *     /  \
 *     9  20
 *       /\
 *      /  \
 *     15   7
 * return its vertical order traversal as:
 *     [
 *         [9],
 *         [3,15],
 *         [20],
 *         [7]
 *     ]
 * Given binary tree [3,9,8,4,0,1,7],
 *         3
 *        /\
 *       /  \
 *       9   8
 *      /\  /\
 *     /  \/  \
 *     4  01   7
 * return its vertical order traversal as:
 *     [
 *         [4],
 *         [9],
 *         [3,0,1],
 *         [8],
 *         [7]
 *     ]
 * Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 *         3
 *        /\
 *       /  \
 *       9   8
 *      /\  /\
 *     /  \/  \
 *     4  01   7
 *       /\
 *      /  \
 *      5   2
 * return its vertical order traversal as:
 *     [
 *         [4],
 *         [9,5],
 *         [3,0,1],
 *         [8,2],
 *         [7]
 *     ]
 *
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
public class BinaryTreeVerticalOrderTraversal {
}

class Solution_BinaryTreeVerticalOrderTraversal {
    // Hashmap & DFS
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> index = new LinkedList<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        queue.add(root);
        index.add(0);
        int max = 0;
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curIndex = index.poll();
            if (!map.containsKey(curIndex)) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(cur.data);
                map.put(curIndex, tmp);
            } else {
                map.get(curIndex).add(cur.data);
            }
            if (cur.left != null) {
                queue.add(cur.left);
                if (min > curIndex - 1) {
                    min = curIndex - 1;
                }
                index.add(curIndex - 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                if (max < curIndex + 1) {
                    max = curIndex + 1;
                }
                index.add(curIndex + 1);
            }
        }
        for (int i = min; i <= max; ++i) {
            res.add(map.get(i));
        }

        return res;
    }
}