package ex1.src;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.LinkedList;;

public class WGraph_Algo implements weighted_graph_algorithms // this class is represent a weighted graph with a basic methods complex methods

{

	private weighted_graph MyGraph;
	private int W=0,B=1,G=2;
    private int V;
    private Queue<Integer> Q;
    private int P[];
    private int sizeofarr;
    private int color[] ;
    final int nill=-1;
    ///////////////////////////////////////////////////////////////////////////////////////////

    public WGraph_Algo() //defult cunstractur for the weight_graph_algo class
    {
    	this.MyGraph=new WGraph_DS();
    }
   
    ///////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void init(weighted_graph g) {//init the graph on which this set of algorithms operates on
		// TODO Auto-generated method stub
		this.MyGraph=g;
	    Iterator<node_info> itr = MyGraph.getV().iterator();
	    int maxkey=0;
	    while(itr.hasNext()) {
	    	int n =itr.next().getKey();
	    	if(maxkey<n)
	    		maxkey=n;
	    }
	    maxkey++;
	    sizeofarr=maxkey;
	    V=0;
	    P=new int[sizeofarr];
	    color=new int[sizeofarr];
	    Q=new ArrayBlockingQueue<Integer>(sizeofarr);	
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public weighted_graph getGraph() {// this method return the graph 
		// TODO Auto-generated method stub
		return this.MyGraph;
	}
//////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public weighted_graph copy() {// this method return acopy of the graph
		// TODO Auto-generated method stub
		return this.MyGraph;
	}

	@Override
	public boolean isConnected() {//// this method check if all the nodes in the graph are connected
		// TODO Auto-generated method stub
		if(MyGraph.getV().isEmpty())return true;  //check if the graph is empty
	       BFS(sizeofarr-1); 
	       for(node_info u : MyGraph.getV()){
	    	   if (color[u.getKey()]!=B) {
				return false;
			}
	    	   
	       }
	       return true;
	}

	@Override
	public double shortestPathDist(int src, int dest) {// this method return the smallest distance between the two nodes
		
		if(MyGraph.hasEdge(src, dest)==false) // if there is no path between the two nodes
			return -1;
		if(src==dest) // if the two nodes are the same 
			return ((NodeInfo) MyGraph.getNode(dest)).getWeight();
		if(MyGraph.getNode(dest)==null || MyGraph.getNode(src)==null)// if one of the nodes ar'nt exist return -1
			return -1;
		for (node_info currV : this.MyGraph.getV()) {
			currV.setTag(0);
			currV.setInfo("");
			((NodeInfo) currV).setWeight(Double.POSITIVE_INFINITY);
		}
		((NodeInfo) this.MyGraph.getNode(src)).setWeight(0);// her we start to check the short path distance and count
		node_info min = this.MyGraph.getNode(src);
		node_info prev=this.MyGraph.getNode(src);
		while (prev!= this.MyGraph.getNode(dest) && min.getInfo()!="empty"){
			min.setTag(1);
			if (this.MyGraph.getV(min.getKey())!=null) {
				for (node_info currE : this.MyGraph.getV(min.getKey())) {
				{
					if ( (this.MyGraph.getNode(currE.getKey()).getTag()==0) && (((NodeInfo) min).getWeight() + MyGraph.getEdge(min.getKey(), currE.getKey()) < ((NodeInfo) this.MyGraph.getNode(currE.getKey())).getWeight()) )
						((NodeInfo) this.MyGraph.getNode(currE.getKey())).setWeight(((NodeInfo) min).getWeight() + MyGraph.getEdge(min.getKey(), currE.getKey()));
						this.MyGraph.getNode(currE.getKey()).setInfo("" + min.getKey());
						prev = min;
					}
				}

			}
			min = findMinNode(this.MyGraph.getV());
		}
		if(((NodeInfo) this.MyGraph.getNode(dest)).getWeight()==Double.POSITIVE_INFINITY){
			return Double.POSITIVE_INFINITY;
		}
		return ((NodeInfo) this.MyGraph.getNode(dest)).getWeight();
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	private node_info findMinNode(Collection<node_info> v) { // this method i built to help me to find the node whit the min weight
		node_info toReturn= new NodeInfo(0);
		((NodeInfo) toReturn).setWeight(Double.POSITIVE_INFINITY);
		toReturn.setInfo("empty");
		toReturn.setTag(1);
		for (node_info currV : v){
			if (currV.getTag()==0 && ((NodeInfo) currV).getWeight()<((NodeInfo) toReturn).getWeight()){
				toReturn = currV;
			}
		}
		return toReturn;
	}
///////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<node_info> shortestPath(int src, int dest) { ////this method return the shortestpath between the two node
		// TODO Auto-generated method stub	
		List<node_info> list =new LinkedList<node_info>();
		if(MyGraph.hasEdge(src, dest)==false) // if there ar'nt a path between the nodes return -1
			return list;
		if(src==dest) // if the nodes are the same we return a list that contain one of them
		{
			node_info nodedest=MyGraph.getNode(dest);
			list.add(nodedest);
			return list;
		}
		if(MyGraph.getNode(dest)==null || MyGraph.getNode(src)==null) // if one of the nodes ar'nt exist we return null
			return null;
		list.add(MyGraph.getNode(src));
		for (node_info currV : this.MyGraph.getV()) {
			currV.setTag(0);
			currV.setInfo("");
			((NodeInfo) currV).setWeight(Double.POSITIVE_INFINITY);
		}
		((NodeInfo) this.MyGraph.getNode(src)).setWeight(0);
		node_info min = this.MyGraph.getNode(src);
		node_info prev=this.MyGraph.getNode(src);
		while (prev!= this.MyGraph.getNode(dest) && min.getInfo()!="empty"){// her we start to find the shortest path between the nodes and put them in the list
			min.setTag(1);
			if (this.MyGraph.getV(min.getKey())!=null) {
				for (node_info currE : this.MyGraph.getV(min.getKey())) {
				{
					if ( (this.MyGraph.getNode(currE.getKey()).getTag()==0) && (((NodeInfo) min).getWeight() + MyGraph.getEdge(min.getKey(), currE.getKey()) < ((NodeInfo) this.MyGraph.getNode(currE.getKey())).getWeight()))
						((NodeInfo) this.MyGraph.getNode(currE.getKey())).setWeight(((NodeInfo) min).getWeight() + MyGraph.getEdge(min.getKey(), currE.getKey()));
						this.MyGraph.getNode(currE.getKey()).setInfo("" + min.getKey());
						prev = min;
				}
				}

			}
			min = findMinNode(this.MyGraph.getV());
			boolean bool=true;
			for(node_info n: list)
			{
				if(((NodeInfo) prev).getWeight()>((NodeInfo) n).getWeight())
					bool=false;
			}
			if(bool)
				list.add(min);
		}
		if(((NodeInfo) this.MyGraph.getNode(dest)).getWeight()==Double.POSITIVE_INFINITY){
			return null;
		}
		if(list.contains(MyGraph.getNode(dest))==false)
			list.add(MyGraph.getNode(dest));
		return list;
	}

	@Override
	public boolean save(String file) {
		// TODO Auto-generated method stub
				try {
		            FileOutputStream myGraphFile = new FileOutputStream(file);
		            ObjectOutputStream OtherGraphFile = new ObjectOutputStream(myGraphFile);

		            OtherGraphFile.writeObject(this.MyGraph);

		            myGraphFile.close();
		                OtherGraphFile.close();
		                     return true;
		        } catch (IOException ex) {
		                     return false;
		        }
			}
    

	@Override
	public boolean load(String file) {
		// TODO Auto-generated method stub
		try {
            FileInputStream MygraphhFile = new FileInputStream(file);
            ObjectInputStream OtherGraphFile = new ObjectInputStream(MygraphhFile);
            MyGraph = (weighted_graph)
    		   OtherGraphFile.readObject();
               OtherGraphFile.close();
               MygraphhFile.close();
                  return true;
        } 
		catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
	    } 
	
	///////////////////////////////////////////////////////////////////////////////////////////
	 public void BFS(int s) {//Breadth-first search (BFS) is an algorithm that is used to graph info or searching tree or traversing structures. 
		// The full form of BFS is the Breadth-first search.
	        for (int i = 0; i <sizeofarr; i++) {
	            color[i] = W;
	            P[i] = nill;
	        }//end for
	        V = s;
	        color[s] = G;
	        Q.add(V);
	        while (!Q.isEmpty()) {
	            int u = Q.poll();
	            if(MyGraph.getV(u)!=null)
	            {
	            for (node_info n : MyGraph.getV(u)) {
	                int v = n.getKey();
	                if (color[v] == W) {
	                    color[v] = G;
	                    P[v] = u;
	                    Q.add(v);
	                }
	                }
	               
	            }
	            color[u] = B;
	        }
	    }
	    

		
}