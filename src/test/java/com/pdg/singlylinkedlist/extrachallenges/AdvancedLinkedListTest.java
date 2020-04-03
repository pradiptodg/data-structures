package com.pdg.singlylinkedlist.extrachallenges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdvancedLinkedListTest {

    AdvancedLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new AdvancedLinkedList();
    }

    @Test
    void testReverseForNull() {
        linkedList.reverse();

        assertEquals(linkedList.toString(), "HEAD -> null");
    }

    @Test
    void testReverseForSingleNode() {
        linkedList.addToFront(3);
        linkedList.reverse();

        assertEquals(linkedList.toString(), "HEAD -> 3 -> null");
    }

    @Test
    void testReverseNormal() {
        linkedList.addToFront(3);
        linkedList.addToFront(2);
        linkedList.addToFront(1);
        linkedList.reverse();

        assertEquals(linkedList.toString(), "HEAD -> 3 -> 2 -> 1 -> null");
    }

    @Test
    void testMergeSortForEmpty() {
        linkedList.mergeSort();
        assertEquals(linkedList.toString(), "HEAD -> null");
    }

    @Test
    void testMerSortForSingle() {
        linkedList.addToFront(3);
        linkedList.mergeSort();
        assertEquals(linkedList.toString(), "HEAD -> 3 -> null");
    }

    @Test
    void testMergeSortForEven() {
        linkedList.addToFront(3);
        linkedList.addToFront(2);
        linkedList.addToFront(7);
        linkedList.addToFront(10);
        linkedList.addToFront(1);
        linkedList.addToFront(5);
        linkedList.mergeSort();
        assertEquals(linkedList.toString(), "HEAD -> 1 -> 2 -> 3 -> 5 -> 7 -> 10 -> null");
    }

    @Test
    void testMergeSortForOdd() {
        linkedList.addToFront(3);
        linkedList.addToFront(2);
        linkedList.addToFront(7);
        linkedList.addToFront(10);
        linkedList.addToFront(1);
        linkedList.mergeSort();
        assertEquals(linkedList.toString(), "HEAD -> 1 -> 2 -> 3 -> 7 -> 10 -> null");
    }


}