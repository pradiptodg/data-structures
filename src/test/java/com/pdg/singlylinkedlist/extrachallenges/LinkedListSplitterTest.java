package com.pdg.singlylinkedlist.extrachallenges;

import com.pdg.singlylinkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListSplitterTest {

    private LinkedListSplitter splitter;
    private AdvancedLinkedList advancedLinkedList;

    @BeforeEach
    void setUp() {
        splitter = new LinkedListSplitter();
        advancedLinkedList = new AdvancedLinkedList();
    }

    @Test
    void testSplitForEven() {
        advancedLinkedList.addToFront(1);
        advancedLinkedList.addToFront(3);
        advancedLinkedList.addToFront(4);
        advancedLinkedList.addToFront(2);

        ListNode<Integer> midNode = splitter.splitIntoTwo(advancedLinkedList.getHead());

        assertEquals(advancedLinkedList.toString(), "HEAD -> 2 -> 4 -> null");
        assertEquals(midNode.getValue(), 3);
    }

    @Test
    void testSplitForOdd() {
        advancedLinkedList.addToFront(3);
        advancedLinkedList.addToFront(4);
        advancedLinkedList.addToFront(2);

        ListNode<Integer> midNode = splitter.splitIntoTwo(advancedLinkedList.getHead());

        assertEquals(advancedLinkedList.toString(), "HEAD -> 2 -> 4 -> null");
        assertEquals(midNode.getValue(), 3);
    }

    @Test
    void testSplitForOneElement() {
        advancedLinkedList.addToFront(3);

        ListNode<Integer> midNode = splitter.splitIntoTwo(advancedLinkedList.getHead());

        assertEquals(advancedLinkedList.toString(), "HEAD -> 3 -> null");
        assertEquals(midNode, null);
    }

    @Test
    void testSplitForEmptyList() {

        ListNode<Integer> midNode = splitter.splitIntoTwo(advancedLinkedList.getHead());

        assertEquals(advancedLinkedList.toString(), "HEAD -> null");
        assertEquals(midNode, null);
    }


}