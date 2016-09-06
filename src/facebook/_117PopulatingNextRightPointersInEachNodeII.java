    /*
    Follow up for problem "Populating Next Right Pointers in Each Node".

    What if the given tree could be any binary tree? Would your previous solution still work?

    Note:

    You may only use constant extra space.
    For example,
    Given the following binary tree,
             1
           /  \
          2    3
         / \    \
        4   5    7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \    \
        4-> 5 -> 7 -> NULL
     */
package facebook;

import java.util.Queue;

import utils.TreeLinkNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author bkoteshwarreddy
 */

public class _117PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
      Solution_PopulatingNextRightPointersInEachNodeII sol = new Solution_PopulatingNextRightPointersInEachNodeII();
      TreeLinkNode root = new TreeLinkNode(1);
      root.left = new TreeLinkNode(2);

      sol.connect(root);

      sol.connect2(root);
    }
}

class Solution_PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode leftMostNode = root;
        Queue<TreeLinkNode> child = new LinkedList<TreeLinkNode>();

        while (leftMostNode != null) {
            TreeLinkNode preNode, nextNode, node = leftMostNode;
            while (node != null && child.isEmpty()) {
                if (node.left != null) {
                    child.add(node.left);
                }
                if (node.right != null) {
                    child.add(node.right);
                }
                node = node.next;
            }

            if (child.isEmpty()) {
                return;
            }

            preNode = leftMostNode = child.remove();
            if (!child.isEmpty()) {
                nextNode = child.remove();
                preNode.next = nextNode;
                preNode = nextNode;
            }

            while (node != null) {
                if (node.left != null) {
                    child.add(node.left);
                }
                if (node.right != null) {
                    child.add(node.right);
                }
                while (!child.isEmpty()) {
                    nextNode = child.remove();
                    preNode.next = nextNode;
                    preNode = nextNode;
                }
                node = node.next;
            }
        }
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode leftMostNode = root, dummyNode = new TreeLinkNode(0);
        while (leftMostNode != null) {
            TreeLinkNode node = leftMostNode, preNode = dummyNode;
            while (node != null) {
                if (node.left != null) {
                    preNode.next = node.left;
                    preNode = node.left;
                }
                if (node.right != null) {
                    preNode.next = node.right;
                    preNode = preNode.next;
                }
                node = node.next;
            }
            leftMostNode = dummyNode.next;
            dummyNode.next = null;
        }
    }
}