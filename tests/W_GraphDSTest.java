package ex1.tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import ex1.src.WGraph_DS;
import ex1.src.node_info;
import ex1.src.weighted_graph;

class W_GraphDSTest {

	@Test
	   void nodeSize() {
        weighted_graph graph = new WGraph_DS();
        graph.addNode(1);
        graph.addNode(10);
        graph.addNode(100);
        graph.removeNode(10);
        graph.addNode(1000);
        graph.removeNode(0);
        int size = graph.nodeSize();
        assertEquals(3,size);

    }
	 @Test
	    void edgeSize() {
	        weighted_graph graph = new WGraph_DS();
	        graph.addNode(1);
	        graph.addNode(10);
	        graph.addNode(100);
	        graph.addNode(1000);
	        graph.connect(1,10,1);
	        graph.connect(10,100,2);
	        graph.connect(1,1000,3);
	        graph.connect(1, 1, 1);
	        int e_size =  graph.edgeSize();
	        assertEquals(3, e_size);
	        double w1 = graph.getEdge(1,10);
	        double w10 = graph.getEdge(10,1);
	        assertEquals(w1, w10);
	        assertEquals(w1, 1);
	    }
	 @Test
	    void getV() {
	        weighted_graph graph = new WGraph_DS();
	        graph.addNode(0);
	        graph.addNode(10);
	        graph.addNode(100);
	        graph.addNode(1000);
	        graph.connect(0,10,1);
	        graph.connect(0,100,2);
	        graph.connect(0,1000,3);
	        graph.connect(0,10,1);
	        Collection<node_info> V = graph.getV();
	        Iterator<node_info> t = V.iterator();
	        while (t.hasNext()) {
	            node_info n = t.next();
	            assertNotNull(n);
	        }
	    }
	 @Test
	    void hasEdge() {
		 weighted_graph graph = new WGraph_DS();
		 graph.addNode(0);
		 graph.addNode(10);
		 boolean flag=graph.hasEdge(0,10);
		 assertFalse(flag);
		 graph.connect(0, 10, 8);
		 flag=graph.hasEdge(0, 10);
		 assertTrue(flag);
	    }
	 @Test
	 	void connect() {
	        weighted_graph graph = new WGraph_DS();
	        graph.addNode(0);
	        graph.addNode(10);
	        graph.addNode(100);
	        graph.addNode(1000);
	        graph.connect(0,1,1);
	        graph.connect(0,10,2);
	        graph.connect(9,3,0);
	        graph.connect(0, 0, 9);
	        graph.removeEdge(0,1);
	        assertFalse(graph.hasEdge(1,0));
	        graph.removeEdge(10,1);
	        graph.connect(0,10,1);
	        double w = graph.getEdge(10,0);
	        assertEquals(w,1);
	        graph.connect(0, 8, 9);
	        graph.connect(0, 10, -5);
	    }
	 
	 @Test
	    void removeNode() {
	        weighted_graph graph = new WGraph_DS();
	        graph.addNode(0);
	        graph.addNode(1);
	        graph.addNode(10);
	        graph.addNode(100);
	        graph.connect(0, 5, 9.2);
	        graph.connect(0,10,2);
	        graph.connect(0,1,1);
	        graph.connect(0,3,3);
	        graph.removeNode(1000);
	        graph.removeNode(0);
	        assertFalse(graph.hasEdge(1,0));
	        assertEquals(3,graph.nodeSize());
	    }
	 @Test
	    void removeEdge() {
	        weighted_graph graph = new WGraph_DS();
        	graph.addNode(0);
	        graph.addNode(1);
	        graph.addNode(10);
	        graph.addNode(100);
	        graph.connect(0,1,1);
	        graph.connect(0,10,2);
	        graph.connect(0,100,3);
	        graph.removeEdge(0,100);
	        assertEquals(graph.getEdge(0,100),-1);
	        graph.removeEdge(0, 19);
	    }


}
