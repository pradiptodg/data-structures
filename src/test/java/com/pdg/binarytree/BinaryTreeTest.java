package com.pdg.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    BinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree(new TreeNode(5));
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        tree.getRoot().left = seven;
        tree.getRoot().right = six;
        tree.getRoot().left.left = nine;
        tree.getRoot().left.right = one;
        tree.getRoot().right.left = two;
        tree.getRoot().right.right = four;
    }


    @Test
    void testSize() {
        assertEquals(tree.size(), 7);
    }

    @Test
    void testSum() {
        assertEquals(tree.sum(), 34);
    }

    @Test
    void testAllLeaves() {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 1, 2, 4));
        assertEquals(tree.getAllLeaves(), list);
    }
}