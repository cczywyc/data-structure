package com.wangyc.leetcode;


/**
 * leetcode 226: invertTree
 *
 * @author wangyc
 */
public class InvertTree {
    public TreeNode solution(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        solution(root.left);
        solution(root.right);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
