package com.pdg.binarytree;

import java.util.*;

public class BinarySearchTree extends BinaryTree implements Iterable<TreeNode> {

    public BinarySearchTree() {
    }

    public BinarySearchTree(int[] input) {
        root = setUp(0, input.length - 1, input);
    }

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            insert(data, root);
        }
    }

    public TreeNode get(int value) {
        return get(value, root);
    }

    public void delete(int value) {
        root = delete(value, root);
    }

    @Override
    public Integer min() {
        if (root == null) {
            return null;
        }
        return min(root).data;
    }

    @Override
    public Integer max() {
        if (root == null) {
            return null;
        }
        return max(root).data;
    }

    private TreeNode setUp(int start, int end, int[] input) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(input[mid]);
        node.left = setUp(start, mid - 1, input);
        node.right = setUp(mid + 1, end, input);
        return node;
    }

    private void insert(int data, TreeNode root) {
        if (data == root.data) {
            return;
        }

        if (data < root.data) {
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

    private TreeNode get(int value, TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.data == value) return node;

        if (node.data > value) {
            return get(value, node.left);
        } else {
            return get(value, node.right);
        }
    }


    private TreeNode delete(int value, TreeNode root) {
        if (root == null) return root;
        else if (value < root.data) {
            root.left = delete(value, root.left);
        } else if (value > root.data) {
            root.right = delete(value, root.right);
        } else {  // if the value has been found, i.e value == root.data
            // no child
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode temp = min(root.right);
                root.data = temp.data;
                delete(temp.data, temp);
            }
        }
        return root;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    private TreeNode max(TreeNode node) {
        if (node.right == null) {
            return node;
        }

        return max(node.right);
    }

    @Override
    public Iterator<TreeNode> iterator() {
        return new BinarySearchTreeIterator(root);
    }
}
