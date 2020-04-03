package com.pdg.singlylinkedlist.challenge2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerNodeTest {

    @Test
    void setValue() {
        IntegerNode node = new IntegerNode(3);
        node.setValue(4);

        assertEquals(node.getValue(), 4);
    }

    @Test
    void setNext() {
        IntegerNode node1 = new IntegerNode(3);
        IntegerNode node2 = new IntegerNode(4);

        node1.setNext(node2);

        assertEquals(node1.getNext(), node2);
    }
}