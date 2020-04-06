package com.pdg.queue;

import com.pdg.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    Queue<Employee> queue;
    Employee janeJones = new Employee("Jane", "Jones", 123);
    Employee johnDoe = new Employee("John", "Doe", 4567);
    Employee marySmith = new Employee("Mary", "Smith", 22);
    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
    Employee billEnd = new Employee("Bill", "End", 78);

    @BeforeEach
    void setUp() {
        queue = new ArrayQueue<>(10);
    }

    @Test
    void testAdd() {
        queue.add(janeJones);
        assertEquals(1, queue.size());
    }

    @Test
    void testRemove() {
        queue.add(marySmith);
        queue.add(janeJones);
        assertEquals(marySmith, queue.remove());
    }

    @Test
    void testPeek() {
        queue.add(marySmith);
        queue.add(janeJones);
        assertEquals(marySmith, queue.peek());
    }



    @Test
    void testSize() {
        queue.add(marySmith);
        queue.add(janeJones);
        assertEquals(2, queue.size());
    }

    @Test
    void testRemoveAndPeekForEmpty() {
        queue.add(marySmith);
        queue.add(mikeWilson);
        queue.remove();
        queue.remove();
        assertThrows(NoSuchElementException.class, () -> queue.peek() );
        assertThrows(NoSuchElementException.class, () -> queue.remove() );
    }
}