package com.pdg.binarytree;

import java.util.*;

public class BinaryTree {


    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public Integer height() {
        if (root == null) return 0;
        return height(root) - 1;
    }

    public List<Integer> postOrder() {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public List<Integer> levelOrder() {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
            list.add(node.data);
        }

        return list;
    }

    public Integer min() {
        return min(root);
    }

    public Integer max() {
        return max(root);
    }

    public void mirror() {  // disrupts the BST property
        mirror(root);
    }

    public int sum() {
        return sum(root);
    }

    public int size() {
        return size(root);
    }

    private Integer height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int hleft = height(node.left);
        int hright = height(node.right);
        return Math.max(hleft, hright) + 1;
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.data);

    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);


    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.data);
        preOrder(node.left, list);
        preOrder(node.right, list);


    }

    private void mirror(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    private int size(TreeNode node) {
        if (node == null) return 0;
        return 1 + sum(node.left) + sum(node.right);
    }

    private int min(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        int left = min(node.left);
        int right = min(node.right);

        return Math.min(Math.min(left, right), node.data);
    }

    private int max(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int left = max(node.left);
        int right = max(node.right);

        return Math.max(Math.max(left, right), node.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTree)) return false;
        BinaryTree that = (BinaryTree) o;
        return equals(root, that.root);
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 == null || node2 == null) return false;
        else return node1.data == node2.data && equals(node1.left, node2.left) && equals(node1.right, node2.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}
