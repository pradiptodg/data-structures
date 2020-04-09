package com.pdg.singlylinkedlist.extrachallenges;

import com.pdg.singlylinkedlist.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pdg.singlylinkedlist.extrachallenges.LinkedListGrouping.getGroupSize;
import static com.pdg.singlylinkedlist.extrachallenges.LinkedListGrouping.getGroups;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListGroupingTest {

    private ListNode<Integer> one = new ListNode<>(1);
    private ListNode<Integer> two = new ListNode<>(2);
    private ListNode<Integer> three = new ListNode<>(3);
    private ListNode<Integer> four = new ListNode<>(4);
    private ListNode<Integer> five = new ListNode<>(5);
    private ListNode<Integer> six = new ListNode<>(6);
    private ListNode<Integer> seven = new ListNode<>(7);
    private ListNode<Integer> eight = new ListNode<>(8);

    private ListNode<Integer>[] heads;

    @BeforeEach
    void setup() {
        two.setNext(three);
        one.setNext(two);
        four.setNext(five);
        five.setNext(two);
        six.setNext(seven);

        heads = new ListNode[]{one, four, six, eight};
    }

    @Test
    void testSize() {
        assertEquals(getGroupSize(heads), 3);
        assertEquals(getGroups(heads).size(), 3);
    }

}