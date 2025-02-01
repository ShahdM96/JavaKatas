package katas.exercises;

import katas.exercises.GraphCloner.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphClonerTest {

    @Test
    void testSingleNode() {
        Node node1 = new Node(1);

        Node clonedNode = GraphCloner.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
        assertNotSame(node1, clonedNode);
    }

    @Test
    void testSimpleGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        node1.neighbors.add(node2);

        Node clonedNode = GraphCloner.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertNotSame(node1, clonedNode);
        assertNotSame(node2, clonedNode.neighbors.get(0));
    }

    @Test
    void testCyclicGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1); // Creates a cycle

        Node clonedNode = GraphCloner.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(0).neighbors.get(0).val);
        assertEquals(1, clonedNode.neighbors.get(0).neighbors.get(0).neighbors.get(0).val);
    }


    @Test
    void testComplexGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1); //Cycle

        Node clonedNode = GraphCloner.cloneGraph(node1);
//
//        System.out.println("Original Graph:");
//        GraphCloner.printGraph(node1, new HashSet<>());
//
//        System.out.println("\nCloned Graph:");
//        GraphCloner.printGraph(clonedNode, new HashSet<>());

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(4, clonedNode.neighbors.get(1).val);
        assertEquals(3, clonedNode.neighbors.get(0).neighbors.get(0).val);
        assertEquals(1, clonedNode.neighbors.get(1).neighbors.get(0).val);
    }
}
