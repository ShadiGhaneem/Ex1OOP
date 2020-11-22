package ex1.tests;


import org.junit.jupiter.api.Test;

import ex1.src.WGraph_Algo;
import ex1.src.WGraph_DS;
import ex1.src.node_info;
import ex1.src.weighted_graph;
import ex1.src.weighted_graph_algorithms;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WGraph_AlgoTest {

    @Test
    void isConnected() {
        weighted_graph graph = new WGraph_DS();
        graph.addNode(1);
        graph.addNode(10);
        graph.addNode(100);
        graph.connect(1, 10, 4);
        graph.connect(9, 100, 9);
        weighted_graph_algorithms graphalgo = new WGraph_Algo();
        graphalgo.init(graph);
        assertFalse(graphalgo.isConnected());
        
       weighted_graph graph2=new WGraph_DS();
       graph2.addNode(1);
       graph2.addNode(10);
       graph2.addNode(100);
       graph2.addNode(3);
       graph2.addNode(7);
       graph2.addNode(9);
       graph2.connect(1, 7, 9);
       graph2.connect(1, 9, 9);
       graph2.connect(1, 3, 2);
       graph2.connect(1, 10, 5);
       graph2.connect(10, 100, 8);
       weighted_graph_algorithms graphalgo2 = new WGraph_Algo();
       graphalgo.init(graph2);
       assertTrue(graphalgo2.isConnected());
  
    
    }

    @Test
    void shortestPathDist() {
        weighted_graph graph = new WGraph_DS();
        graph.addNode(1);
        graph.addNode(10);
        graph.addNode(100);
        graph.connect(1, 10, 4);
        graph.connect(10, 100, 9);
        graph.connect(1, 100, 90);
        weighted_graph_algorithms graphalgo = new WGraph_Algo();
        graphalgo.init(graph);
        assertTrue(graphalgo.isConnected());
        double d = graphalgo.shortestPathDist(1,100);
        assertEquals(d, 13);
        
        weighted_graph graph2=new WGraph_DS();
        graph.addNode(9);
        graph.addNode(2);
        graph.addNode(300);
        graph.connect(2, 9, 5);
        weighted_graph_algorithms graphalgo2 = new WGraph_Algo();
        graphalgo2.init(graph2);
        assertFalse(graphalgo.isConnected());
        double d2 = graphalgo2.shortestPathDist(9,300);
        assertEquals(d2, -1);
        
    }

    @Test
    void shortestPath() {
    	  weighted_graph graph = new WGraph_DS();
          graph.addNode(1);
          graph.addNode(10);
          graph.addNode(100);
          graph.connect(1, 10, 4);
          graph.connect(10, 100, 9);
          graph.connect(1, 100, 90);
          weighted_graph_algorithms graphalgo = new WGraph_Algo();
          graphalgo.init(graph);
        List<node_info> sp = graphalgo.shortestPath(1,100);
        int[] checkKey = {1,10,100};
        int i = 0;
        for(node_info n: sp) {
        	assertEquals(n.getKey(), checkKey[i]);
        	i++;
        }
        
        weighted_graph graph2=new WGraph_DS();
        graph.addNode(9);
        graph.addNode(2);
        graph.addNode(300);
        graph.connect(2, 9, 5);
        weighted_graph_algorithms graphalgo2 = new WGraph_Algo();
        graphalgo2.init(graph2);
        List<node_info> sp1 = graphalgo2.shortestPath(2,9);
        int[] checkKey2 = {2,9};
        i=0;
        for(node_info nn: sp1) {
        	assertEquals(nn.getKey(), checkKey2[i]);
        	i++;
    }
        sp1=graphalgo2.shortestPath(2, 2);
        int[] checkKey3 = {2};
        i=0;
        for(node_info nn: sp1) {
        	assertEquals(nn.getKey(), checkKey3[i]);
        	i++;
    }
    }
    

}