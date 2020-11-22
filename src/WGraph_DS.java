package ex1.src;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
public class WGraph_DS implements weighted_graph { //// this class is represent a weighted graph with a basic methods

	private int mc;
	private int edge;
	private HashMap<Integer, node_info> mynodes;// this hashmap is represent the nodes of the graph
	public WGraph_DS()//a default  cunstractur 
	{
		this.mynodes=new HashMap<Integer, node_info>();
		this.edge=0;
		this.mc=0;
	}
	@Override
	public node_info getNode(int key) { //return the node with the key value
		// TODO Auto-generated method stub
		return this.mynodes.get(key);
	}

	@Override
	public boolean hasEdge(int node1, int node2) { // the method takes two nodes and check if they are neighbors
		// TODO Auto-generated method stub
		if(mynodes.get(node1)==null|| mynodes.get(node2)==null) // if one of the nodes is null we return false
			return false;
		node_info node22=mynodes.get(node2);
		return ((NodeInfo) this.mynodes.get(node1)).gethmp().containsKey(node22) ;
	}

	@Override
	public double getEdge(int node1, int node2) {// this method return the weight of the edge between the nodes 
		// TODO Auto-generated method stub
		if(node1==node2) // if they are the same we return 0
			return 0;
		if(hasEdge(node1, node2)==false) // if they are not neighbors return -1
			return -1;
		if(mynodes.get(node1)==null||mynodes.get(node2)==null)
			return -1;
		return ((NodeInfo) this.mynodes.get(node1)).gethmp().get(mynodes.get(node2));
	}

	@Override
	public void addNode(int key) { // this method add new node to the graph
		// TODO Auto-generated method stub
		NodeInfo n1=new NodeInfo(key);
		this.mynodes.put((int)key,n1 );
		
	}

	@Override
	public void connect(int node1, int node2, double w) {// this method takes two nodes and connect them (make them neighbors)
		// TODO Auto-generated method stub
		node_info n2=this.mynodes.get(node2);
		node_info n1=this.mynodes.get(node1);
		
		if(n1==null || n2==null)
			return;
		if(node1==node2)  // connecting anode to himself doesnt do anything so this if check if nodes are the same
			return;
		if(hasEdge(node1, node2)==false) 
		{
			((NodeInfo) mynodes.get(node1)).gethmp().put(n2, w);
			((NodeInfo) mynodes.get(node2)).gethmp().put(n1, w);
			((NodeInfo) mynodes.get(node1)).getni().add(n2);
			((NodeInfo) mynodes.get(node2)).getni().add(n1);
			edge++;
		}
		else  //// if the two nodes are neighbors we can't connect so we change the weight to w
		{
			((NodeInfo) mynodes.get(node1)).gethmp().remove(n2);
			((NodeInfo) mynodes.get(node2)).gethmp().remove(n1);
			((NodeInfo) mynodes.get(node1)).gethmp().put(n2, w);
			((NodeInfo) mynodes.get(node2)).gethmp().put(n1, w);
		}
		mc++;
	}

	@Override
	public Collection<node_info> getV() { // this method return the nodes of the graph 
		// TODO Auto-generated method stub
		Collection<node_info> collection1;
	    collection1=mynodes.values();
	    return collection1;
	}

	@Override
	public Collection<node_info> getV(int node_id) { // this method return the neighbors of the node_id
		// TODO Auto-generated method stub
		  return ((NodeInfo) this.mynodes.get(node_id)).getni();
	}

	@Override
	public node_info removeNode(int key) {// this method remove the node with key key 
		// TODO Auto-generated method stub
		 if(mynodes.get(key)!=null) {
	    	   
	    	   if(((NodeInfo) mynodes.get(key)).getni()!=null)// we must remove the node from its neighbors list of neighbor if it has neighbors
	    	   {
	    		   for(node_info n:((NodeInfo) mynodes.get(key)).getni()) // we must remove the node from its neighbors list of neighbors
	    		   {
	    			   ((NodeInfo) n).removenode((mynodes.get(key)).getKey());
	    		   }
	    		   for(node_info n:((NodeInfo) mynodes.get(key)).gethmp().keySet()) // we must remove the node from the hashmp of the weight
	    		   {
	    			   NodeInfo newn=(NodeInfo) n;
	    			   newn.gethmp().remove((mynodes.get(key)));
	    		   }
	    		   this.mc++;
	    		   this.edge-=((NodeInfo) mynodes.get(key)).getni().size();
	    	   }
	    	   return mynodes.remove(key);
	    	   
	       }
	       return null;
	}

	@Override
	public void removeEdge(int node1, int node2) {// this method remove the edge between two nodes
		// TODO Auto-generated method stub
		if(hasEdge(node1, node2)==false) // if the nodes is not connected we don't do any thing 
			return;
		node_info n2=   this.mynodes.get(node2);
		node_info n1=   this.mynodes.get(node1);
		if(n1==null|| n2==null) // if one of the two nodes ar'nt exist we don't do any thing 
			return;
		 ((NodeInfo) this.mynodes.get(node1)).getni().remove(mynodes.get(node2));
	     ((NodeInfo) this.mynodes.get(node2)).getni().remove(mynodes.get(node1));
	     ((NodeInfo) this.mynodes.get(node1)).gethmp().remove(n2);
	     ((NodeInfo) this.mynodes.get(node2)).gethmp().remove(n1);
	     edge--;
	     mc++;
		
	}

	@Override
	public int nodeSize() { //  return the number of the nodes in the graph 
		// TODO Auto-generated method stub
		return this.mynodes.size();
	}

	@Override
	public int edgeSize() { // return the number of the edegs in the graph
		// TODO Auto-generated method stub
		return this.edge;
	}

	@Override
    public boolean equals(Object o) {
        if (this.mynodes == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WGraph_DS wGraph_ds = (WGraph_DS) o;
        if(mc == wGraph_ds.mc && edge == wGraph_ds.edge && nodeSize() == wGraph_ds.nodeSize()&& Objects.equals(mynodes.getClass(),wGraph_ds.mynodes.getClass())==true)
        	return true;
        return false;
    }
	@Override
	public int getMC() {// return the mc
		// TODO Auto-generated method stub
		return this.mc;
	}

}