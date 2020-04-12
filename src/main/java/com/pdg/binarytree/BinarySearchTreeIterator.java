package com.pdg.binarytree;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreeIterator implements Iterator<TreeNode> {

    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        findMin(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        TreeNode node = stack.pop();
        findMin(node.right);
        return node;
    }

    private void findMin(TreeNode curr) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
}
