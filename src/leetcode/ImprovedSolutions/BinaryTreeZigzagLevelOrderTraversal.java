package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Stack;

import utils.TreeNode;
import utils.Utils;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 *
 * For example:
 *     Given binary tree {3,9,20,#,#,15,7},
 *             3
 *            / \
 *           9  20
 *             /  \
 *            15   7
 *
 * return its zigzag level order traversal as:
 *     [
 *         [3],
 *         [20,9],
 *         [15,7]
 *     ]
 *

 * http://n00tc0d3r.blogspot.com/2013/01/binary-tree-traversals-ii.html
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /*
             1
            / \
           2   5
          / \   \
         3   4   6
    */
    public static void main(String[] args) {
        Solution_BinaryTreeZigzagLevelOrderTraversal sol = new Solution_BinaryTreeZigzagLevelOrderTraversal();
        Utils.printListListln(sol.zigzagLevelOrder(TreeNode.getSampleTree()));
    }
}

class Solution_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        boolean isReverse = false;
        Stack<TreeNode> l1 = new Stack<TreeNode>(), l2 = new Stack<TreeNode>(), tmp;

        l1.add(root);
        while (!l1.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            while (!l1.isEmpty()) {
                TreeNode node = l1.pop();
                if (isReverse) {
                    if (node.right != null) {
                        l2.add(node.right);
                    }
                    if (node.left != null) {
                        l2.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        l2.add(node.left);
                    }
                    if (node.right != null) {
                        l2.add(node.right);
                    }
                }
                level.add(node.data);
            }
            isReverse = !isReverse;
            result.add(level);
            tmp = l2;
            l2 = l1;
            l1 = tmp;
        }

        return result;
    }
}