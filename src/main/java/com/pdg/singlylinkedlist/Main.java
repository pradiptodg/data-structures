package com.pdg.singlylinkedlist;

import com.pdg.model.Employee;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.removeFromFront());

        list.printList();

        System.out.println(list.getSize());

        System.out.println(list.isEmpty());


    }
}
