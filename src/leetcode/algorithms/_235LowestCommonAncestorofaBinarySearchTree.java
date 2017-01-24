package leetcode.algorithms;

import utils.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes v
 * and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant
 * of itself)."
 *
 *             _______6______
 *            /              \
 *         ___2__          ___8__
 *        /      \        /      \
 *        0      _4       7       9
 *              /  \
 *              3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2,
 * since a node can be a descendant of itself according to the LCA definition.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * https://gist.github.com/zac-xin/4043437
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
public class _235LowestCommonAncestorofaBinarySearchTree {
}

class Solution_LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    public static TreeNode findLCA_BST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.data > Math.max(p.data, q.data)) {
            return findLCA_BST(root.left, p, q);
        }
        if (root.data < Math.min(p.data, q.data)) {
            return findLCA_BST(root.right, p, q);
        }
        return root;
    }
}