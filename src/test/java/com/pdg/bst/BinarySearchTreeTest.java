package com.pdg.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree tree;
    List<Integer> list;



    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(14);
        tree.insert(30);
        tree.insert(1);
        tree.insert(4);
        tree.insert(25);

    }

    @Test
    void testInsert() {
        list = new ArrayList<>(Arrays.asList(4, 1, 14, 25, 30, 20));
        assertEquals(tree.postOrder(), list);
        list = new ArrayList<>(Arrays.asList(1, 4, 14, 20, 25, 30));
        assertEquals(tree.inOrder(), list);
    }

    @Test
    void postOrder() {
        list = new ArrayList<>(Arrays.asList(4, 1, 14, 25, 30, 20));
        assertEquals(tree.postOrder(), list);
    }

    @Test
    void inOrder() {
        list = new ArrayList<>(Arrays.asList(1, 4, 14, 20, 25, 30));
        assertEquals(tree.inOrder(), list);
    }

    @Test
    void preOrder() {
        list = new ArrayList<>(Arrays.asList(20, 14, 1, 4, 30, 25));
        assertEquals(tree.preOrder(), list);
    }
}