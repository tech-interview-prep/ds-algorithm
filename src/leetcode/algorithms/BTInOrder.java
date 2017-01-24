package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Tags: Tree, HashTable, Stack
 */
class BTInOrder {

    public static void main(String[] args) {

    }

    /**
     * Stack solution, O(n) Space
     * Use a stack to store TreeNodes
     * Go to left most and add each node
     * Pop the node from stack, add its value, and try to go right
     * Stop if stack is empty or node is null
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (!s.isEmpty() || root != null) {
            // check whether current node is null
            if (root != null) { // current node is not null
                s.push(root);
                root = root.left;
            } else { // current node is null, pop and go right
                root = s.pop();
                result.add(root.data); // visit()
                root = root.right;
            }
        }
        return result;
    }

    /**
     * <strong>Morris Traversal</strong>
     * O(1) space
     * Use cur for current node, pre for predecessor of cur node
     * Check whether left subtree exists
     * If yes, find rightmost node in left subtree
     * Check whether rightmost node is connected with cur node
     * If connected, break the connection and visit and move to right subtree
     * Otherwise, connect and traverse left subtree
     * If no, visit cur node and traverse right subtree
     */
    public static List<Integer> inorderTraversalB(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.data); // visit
                cur = cur.right; // move to right
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) { // connect with cur
                    pre.right = cur;
                    cur = cur.left; // traverse left subtree
                } else { // left subtree is done
                    pre.right = null;
                    res.add(cur.data); // visit
                    cur = cur.right; // move to right
                }
            }
        }
        return res;
    }
}
