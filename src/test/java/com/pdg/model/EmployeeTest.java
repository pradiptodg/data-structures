package com.pdg.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testCompare() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("", "", 3));
        list.add(new Employee("", "", 4));
        list.add(new Employee("", "", 6));
        list.add(new Employee("", "", 1));
        list.add(new Employee("", "", 5));
        list.add(new Employee("", "", 2));

        Collections.sort(list, new EmployeeComparator());

        for (Employee e: list) {
            System.out.println(e.getId());
        }
    }
}

class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
    }
}