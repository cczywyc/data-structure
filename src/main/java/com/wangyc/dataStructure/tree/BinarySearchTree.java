package com.wangyc.dataStructure.tree;

/**
 * Binary search tree
 *
 * @author cczywyc
 */

public class BinarySearchTree {

    /**
     * binary search tree root node
     */
    private TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    TreeNode search(int num) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < num) {
                cur = cur.right;
            } else if (cur.val > num) {
                cur = cur.left;
            } else {
                break;
            }
        }
        return cur;
    }

    void insert(int num) {
        if (root == null) {
            root = new TreeNode(num);
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val == num) {
                return;
            }
            parent = cur;
            if (cur.val < num) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        // insert, init the node
        TreeNode newNode = new TreeNode(num);
        // find the position
        if (parent.val < num) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
    }
}
