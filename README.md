# Ex1OOP
Seccond assignment in OOP 
In this assignment I build an unirected graph weighted and doing some algorithims (shortest path and checking if the graph is connected)

NodeInfo:
1) public class NodeINfo implements node_info  -> this class is represent the nodes of the graph with a basic methods
2) public void setFather(node_info f) -> set the father of the node
3) public node_info getFather()  -> return the father of the node
4) public void setWeight(double w)  ->  set the weight of the node
5) public double getWeight()  -> get the weight of the node
6) public Collection<node_info> getni()  -> this method gives us the neighbors of our node
7) public NodeInfo(int key)  -> a cunstractur with the key value 
8) public HashMap<node_info, Double> gethmp()  -> return  hashmap that contain the weight between the node and his neighbors
9) public void sethmp(HashMap<node_info, Double> hmp)  -> set the hashmap value
10) public void removenode(int key)  -> this method remove node from the list of the neighbors
11) public int getKey()  -> this method return the key
12) public String getInfo()  -> this method return the info
13) public void setInfo(String s)  -> this method set the value of info
14) public double getTag()  -> this method return the tag
15) public void setTag(double t)  -> this method set the value of tag
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
W_GraphDS:
1) public class W_GraphDS implements weighted_graph -> this class is represent a weighted graph with a basic methods
2) public W_GraphDS() ->a default  cunstractur 
3) public node_info getNode(int key) ->return the node with the key value
4) public boolean hasEdge(int node1, int node2) -> the method takes two nodes and check if they are neighbors
5) public double getEdge(int node1, int node2) -> this method return the weight of the edge between the nodes 
6) public void addNode(int key) -> this method add new node to the graph
7) public void connect(int node1, int node2, double w) -> this method takes two nodes and connect them (make them neighbors)
8) public Collection<node_info> getV() -> this method return the nodes of the graph
9) public Collection<node_info> getV(int node_id) -> this method return the neighbors of the node_id
10) public node_info removeNode(int key) -> this method remove the node with key key 
11) public void removeEdge(int node1, int node2) -> this method remove the edge between two nodes
12) public int nodeSize() ->  return the number of the nodes in the graph
13) public int edgeSize() -> return the number of the edegs in the graph
14) public int getMC() -> return the mc
///////////////////////////////////////////////////////////////////////////////////////////////////////////
WGraph_Algo:
1) public class WGraph_Algo implements weighted_graph_algorithms -> this class is represent a weighted graph with a basic methods complex methods
2) public WGraph_Algo() -> defult cunstractur for the weight_graph_algo class
3) public void init(weighted_graph g) -> init the graph on which this set of algorithms operates on
4) public weighted_graph getGraph() ->  this method return the graph 
5) public weighted_graph copy() ->  this method return acopy of the graph
6) public boolean isConnected() ->  this method check if all the nodes in the graph are connected
7) public double shortestPathDist(int src, int dest) ->  this method return the smallest distance between the two nodes
8) private node_info findMinNode(Collection<node_info> v) ->  this method i built to help me to find the node whit the min weight
9) public List<node_info> shortestPath(int src, int dest) -> this method return the shortestpath between the two node
10) public boolean save(String file) -> 
11) public boolean load(String file) -> 
12) public void BFS(int s) ->  Breadth-first search (BFS) is an algorithm that is used to graph info or searching tree or traversing structures.
Dijkstra’s algorithm is very similar to Prim’s algorithm for minimum spanning tree. 
Like Prim’s MST, we generate a SPT (shortest path tree) with given source as root. We maintain two sets,
 one set contains vertices included in shortest path tree, other set includes vertices not yet included in shortest path tree. 
At every step of the algorithm, we find a vertex which is in the other set (set of not yet included) and has a minimum distance from the source.
