package com.pdg.bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            insert(data, root);
        }
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.value);

    }

    public List<Integer> postOrder() {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);


    }

    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.value);
        preOrder(node.left, list);
        preOrder(node.right, list);


    }

    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void insert(int data, TreeNode root) {
        if (data == root.value) {
            return;
        }

        if (data < root.value) {
            if (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                insert(data, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                insert(data, root.right);
            }
        }
    }

}
