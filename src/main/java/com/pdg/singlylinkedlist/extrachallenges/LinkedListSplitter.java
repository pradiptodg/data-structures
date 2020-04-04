package com.pdg.singlylinkedlist.extrachallenges;

import com.pdg.singlylinkedlist.ListNode;

public class LinkedListSplitter {
    public ListNode splitIntoTwo(ListNode node) {
        if (node == null) return null;

        ListNode slow = node;
        ListNode fast = node;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            if (fast.getNext() != null) {
                fast = fast.getNext();
                slow = slow.getNext();
            }
        }
        ListNode midNode = slow.getNext();
        slow.setNext(null);
        return midNode;
    }
}
