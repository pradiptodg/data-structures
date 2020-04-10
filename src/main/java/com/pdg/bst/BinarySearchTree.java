package com.pdg.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    TreeNode root;

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

     public TreeNode min() {
        if (root == null) {
            return null;
        }
        return min(root);
     }

    public TreeNode max() {
        if (root == null) {
            return null;
        }
        return max(root);
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



}
