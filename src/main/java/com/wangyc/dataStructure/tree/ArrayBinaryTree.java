package com.wangyc.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Array represents binary tree
 *
 * @author cczywyc
 */

public class ArrayBinaryTree {

    private List<Integer> tree;

    public ArrayBinaryTree(List<Integer> tree) {
        this.tree = new ArrayList<>(tree);
    }

    /**
     * the size of tree
     *
     * @return result
     */
    public int size() {
        return tree.size();
    }

    /**
     * get the index value
     *
     * @param i index
     * @return value
     */
    public Integer getVal(int i) {
        if (i < 0 || i >= tree.size()) return null;
        return tree.get(i);
    }

    /**
     * get the index node's left index
     *
     * @param i index
     * @return the left index
     */
    public Integer getLeftIndex(int i) {
        return i * 2 + 1;
    }

    /**
     * get the index node's right index
     *
     * @param i index
     * @return the right index
     */
    public Integer getRightIndex(int i) {
        return i * 2 + 2;
    }

    /**
     * geth the index node's parent index
     *
     * @param i index
     * @return the parent index
     */
    public Integer getParentIndex(int i) {
        return (i - 1) / 2;
    }

    /**
     * level order traversal
     *
     * @return result
     */
    public List<Integer> levelOrder() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            if (getVal(i) != null) {
                result.add(getVal(i));
            }
        }
        return result;
    }

    /**
     * array binary tree pre-order traversal
     *
     * @return result
     */
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        dfs(0, "pre", result);
        return result;
    }

    /**
     * array binary tree in-order traversal
     *
     * @return result
     */
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        dfs(0, "in", result);
        return result;
    }

    /**
     * array binary tree post-order traversal
     *
     * @return result
     */
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        dfs(0, "post", result);
        return result;
    }

    public void dfs(int i, String type, List<Integer> result) {
        if (getVal(i) == null) return;
        if ("pre".equals(type)) {
            result.add(getVal(i));
        }
        dfs(getLeftIndex(i), type, result);
        if ("in".equals(type)) {
            result.add(getVal(i));
        }
        dfs(getRightIndex(i), type, result);
        if ("post".equals(type)) {
            result.add(getVal(i));
        }
    }

}
