package com.pdg.stack;

import com.pdg.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LLStackTest {

    LLStack<Employee> stack;
    Employee janeJones = new Employee("Jane", "Jones", 123);
    Employee johnDoe = new Employee("John", "Doe", 4567);
    Employee marySmith = new Employee("Mary", "Smith", 22);
    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

    @BeforeEach
    void setUp() {
        stack = new LLStack<>();
    }

    @Test
    void testPush() {
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        assertEquals(stack.peek().toString(), mikeWilson.toString());
    }

    @Test
    void testPop() {
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.pop();
        assertEquals(stack.peek().toString(), marySmith.toString());
    }

    @Test
    void testIsEmpty() {
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.pop();
        stack.pop();


        assertEquals(stack.isEmpty(), true);
    }

    @Test
    void testPopForEmpty() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
        assertThrows(EmptyStackException.class, () -> {
            stack.push(marySmith);
            stack.pop();
            stack.pop();
        });
    }

    @Test
    void testPeekForEmpty() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }


    @Test
    void testPeek() {
        stack.push(marySmith);
        assertEquals(stack.peek(), marySmith);
    }


    @Test
    void testSize() {
        stack.push(marySmith);
        assertEquals(stack.size(), 1);
    }

}