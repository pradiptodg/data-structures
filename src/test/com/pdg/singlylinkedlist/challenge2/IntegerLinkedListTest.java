package com.pdg.singlylinkedlist.challenge2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


class IntegerLinkedListTest {

    private IntegerLinkedList linkedList;

    @Before
    void setUp() {
        linkedList = new IntegerLinkedList();
    }

    @Test
    void testAddToFront() {
        linkedList.addToFront(1);
        assertEquals(linkedList.toString(), "HEAD -> 1 -> null");

        linkedList.addToFront(2);
        assertEquals(linkedList.toString(), "HEAD -> 2 -> 1 -> null");
    }

    @Test
    void testInsertSortedForEmpty() {
        linkedList.insertSorted(4);
        assertEquals(linkedList.toString(), "HEAD -> 4 -> null");
    }

    @Test
    void testInsertSortedForValueLesserThanHead() {
        linkedList.insertSorted(2);
        linkedList.insertSorted(1);
        assertEquals(linkedList.toString(), "HEAD -> 1 -> 2 -> null");
    }

    @Test
    void testInsertSortedForMiddle() {
        linkedList.insertSorted(4);
        linkedList.insertSorted(1);
        linkedList.insertSorted(2);
        assertEquals(linkedList.toString(), "HEAD -> 1 -> 2 -> 4 -> null");
    }

    @Test
    void testInsertSortedForEnd() {
        linkedList.insertSorted(1);
        linkedList.insertSorted(2);
        linkedList.insertSorted(4);
        assertEquals(linkedList.toString(), "HEAD -> 1 -> 2 -> 4 -> null");
        assertEquals(linkedList.getSize(), 3);
    }
}