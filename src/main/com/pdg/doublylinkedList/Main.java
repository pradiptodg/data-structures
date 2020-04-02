package com.pdg.doublylinkedList;

public class Main {
    public static void main(String[] args) {
        EmployeeDoublyListedList list = new EmployeeDoublyListedList();

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        System.out.println("isEmpty = " + list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        list.printList();

        System.out.println(list.getSize());

        System.out.println("isEmpty = "+list.isEmpty());

        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);
        list.printList();
        System.out.println(list.getSize());
        System.out.println("isEmpty = "+list.isEmpty());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());
        System.out.println("isEmpty = "+list.isEmpty());

        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());
        System.out.println("isEmpty = "+list.isEmpty());

        Employee norahJames = new Employee("Norah", "James", 12);
        list.addBefore(norahJames, janeJones);
        list.printList();
        System.out.println(list.getSize());
        System.out.println("isEmpty = "+list.isEmpty());


    }
}
