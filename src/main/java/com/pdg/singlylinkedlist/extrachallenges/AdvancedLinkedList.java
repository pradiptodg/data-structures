package com.pdg.singlylinkedlist.extrachallenges;

import com.pdg.singlylinkedlist.ListNode;
import com.pdg.singlylinkedlist.challenge2.IntegerLinkedList;

import java.util.LinkedList;

public class AdvancedLinkedList extends IntegerLinkedList{

    private LinkedListSplitter splitter = new LinkedListSplitter();

    public void reverse() {
        if (size > 1) {
            ListNode<Integer> prev = null;
            ListNode<Integer> curr = head;
            ListNode<Integer> next = null;

            while (curr != null) {
                next = curr.getNext();
                curr.setNext(prev);
                prev = curr;
                curr = next;
            }

            head = prev;

  //Alternate solution
//            BaseNode<Integer> next = curr.getNext();
//
//            while (curr != null) { // 1 2 3
//                System.out.println(prev + " " + curr + " " + next);
//                curr.setNext(prev);
//                prev = curr;
//                curr = next;
//                if (curr != null)
//                    next = curr.getNext();
//            }
//
//            head = prev;
        }
    }

    public void mergeSort () {
        head = mergeSort(head);
    }

    private ListNode<Integer> mergeSort(ListNode<Integer> node) {
        if (node == null || node.getNext() == null) return node;
        ListNode<Integer> midNode = splitter.splitIntoTwo(node);

        ListNode<Integer> l1 = mergeSort(node);
        ListNode<Integer> l2 = mergeSort(midNode);

        return merge(l1, l2);
    }

    private ListNode<Integer> merge(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> curr1 = l1;
        ListNode<Integer> curr2 = l2;
        ListNode<Integer> tempHead = new ListNode<>(Integer.MIN_VALUE);
        ListNode<Integer> temp = tempHead;
        while (curr1 != null && curr2 != null) {
            if (curr1.getValue() < curr2.getValue()) {
                temp.setNext(curr1);
                curr1 = curr1.getNext();
            } else {
                temp.setNext(curr2);
                curr2 = curr2.getNext();
            }
            temp = temp.getNext();
        }

        while (curr1 != null) {
            temp.setNext(curr1);
            curr1 = curr1.getNext();
            temp = temp.getNext();
        }

        while (curr2 != null) {
            temp.setNext(curr2);
            curr2 = curr2.getNext();
            temp = temp.getNext();
        }
        return tempHead.getNext();
    }

}
