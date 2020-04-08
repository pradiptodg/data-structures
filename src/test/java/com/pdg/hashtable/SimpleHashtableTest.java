package com.pdg.hashtable;

import com.pdg.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashtableTest {

    SimpleHashtable<Employee> ht;
    Employee janeJones = new Employee("Jane", "Jones", 123);
    Employee johnDoe = new Employee("John", "Doe", 4567);
    Employee marySmith = new Employee("Mary", "Smith", 22);
    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
    Employee billEnd = new Employee("Bill", "End", 78);

    @BeforeEach
    void setUp() {
        ht = new SimpleHashtable<>();
    }

    @Test
    void testPutAndGet() {
        ht.put("Jones", janeJones);
        assertEquals(ht.get("Jones"), janeJones);
    }



    @Test
    void testCollision() {
        ht.put("Jones", johnDoe);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);
        ht.printHashtable();
        assertEquals(ht.get("Wilson"), mikeWilson);
        assertEquals(ht.get("Smith"), marySmith);
    }
}