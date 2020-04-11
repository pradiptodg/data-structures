package com.pdg.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public void mirror() {  // disrupts the BST property
        mirror(root);
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

}
