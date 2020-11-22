package ex1.src;
import java.util.HashMap;
import java.util.*;
import java.util.LinkedList;
public class NodeInfo implements node_info{ // this class is represent the nodes of the graph with a basic methods 

	private int key;
	private String info;
	private double tag;
	private node_info father;
	private double weight;
	private HashMap<node_info, Double> hmp=new HashMap<node_info, Double>();// this hashmap is represent the weight between the node and his neighbors
	private Collection<node_info> ni= new LinkedList<node_info>();// this list contain the neighbors of our node
	public void setFather(node_info f) // set the father of the node
	{
		this.father=f;
	}
	public node_info getFather()// return the father of the node
	{
		return this.father;
	}
	public void setWeight(double w) //  set the weight of the node
	{
		this.weight=w;
	}
	public double getWeight() // get the weight of the node
	{
		return this.weight;
	}
	public Collection<node_info> getni() // this method gives us the neighbors of our node
	{
		return this.ni;
	}
	public NodeInfo(int key) // a cunstractur with the key value 
	{
		this.father=null;
		this.weight=0;
		this.key =key;
		this.tag=0;
		this.info="";
	}
	public HashMap<node_info, Double> gethmp() // return  hashmap that contain the weight between the node and his neighbors
	{
		return this.hmp;
	}
	public void sethmp(HashMap<node_info, Double> hmp) // set the hashmap value
	{
		this.hmp=hmp;
	}
	public void removenode(int key) // this method remove node from the list of the neighbors
	{
		node_info n=new NodeInfo(key);
		this.ni.remove(n);
	}
	@Override
	public int getKey() { // this method return the key
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public String getInfo() { // this method return the info
		// TODO Auto-generated method stub
		return this.info;
	}

	@Override
	public void setInfo(String s) {// this method set the value of info
		// TODO Auto-generated method stub
		this.info=s;
	}

	@Override
	public double getTag() { // this method return the tag
		// TODO Auto-generated method stub
		return this.tag;
	}

	@Override
	public void setTag(double t) { // this method set the value of tag
		// TODO Auto-generated method stub
		this.tag=t;
	}

}