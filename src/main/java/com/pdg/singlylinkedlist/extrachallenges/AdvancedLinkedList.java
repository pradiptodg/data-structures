package com.pdg.singlylinkedlist.extrachallenges;

import com.pdg.singlylinkedlist.challenge2.IntegerLinkedList;
import com.pdg.singlylinkedlist.challenge2.IntegerNode;

public class AdvancedLinkedList extends IntegerLinkedList{

    public void reverse() {
        if (size > 1) {
            IntegerNode prev = null;
            IntegerNode curr = head;
            IntegerNode next = null;

            while (curr != null) {
                next = curr.getNext();
                curr.setNext(prev);
                prev = curr;
                curr = next;
            }

            head = prev;

  //Alternate solution
//            IntegerNode next = curr.getNext();
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

    public void mergeSort (int start, int end) {
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        mergeLinkedList();
    }

    public void mergeLinkedList(int start, int mid, int end) {
        AdvancedLinkedList temp;
        int i = start;
        int j = mid;
        IntegerNode iNode =
    }

    public IntegerNode traverse(IntegerNode node, int pos) {

        while (pos > 0) {
            node = node.getNext();
            pos--;
        }
        return node;
    }
}
