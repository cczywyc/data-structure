package com.wangyc.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * binary tree depth-first traversal
 *
 * @author cczywyc
 */
public class BinaryTreeDFS {

    private List<Integer> list = new ArrayList<>();

    /**
     * pre-order traversal. root -> left -> right
     *
     * @param root binary tree root node
     */
    void preOrder(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * in-order traversal. left -> root -> right
     *
     * @param root binary tree root node
     */
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /**
     * post-order traversal. left -> right -> root
     * @param root binary tree root node
     */
    void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
}
