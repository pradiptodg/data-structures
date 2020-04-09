package com.pdg.singlylinkedlist.extrachallenges;

import com.pdg.singlylinkedlist.ListNode;

import java.util.*;

public class LinkedListGrouping {

    public static int getGroupSize(ListNode<Integer>[] heads) {
        Set<ListNode<Integer>> set = new HashSet<>();
        for (int i = 0; i < heads.length; i++) {
            set.add(getLastNode(heads[i]));
        }

        return set.size();
    }

    public static List<List<ListNode>> getGroups(ListNode<Integer>[] heads) {
        Map<ListNode<Integer>, List<ListNode>> map = new HashMap<>();
        for (int i = 0; i < heads.length; i++) {
            ListNode<Integer> head = heads[i];
            ListNode<Integer> last = getLastNode(heads[i]);

            if (!map.containsKey(last)) {
                map.put(last, new ArrayList<>());
            }

            map.get(last).add(head);
        }



        return new ArrayList<>(map.values());
    }

    private static ListNode<Integer> getLastNode(ListNode<Integer> head) {
        ListNode<Integer> curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        return curr;
    }
}
