import java.util.*;

/*
@Author: Arsh Zahed
A basic Vertex class for implementing a Graph
Contains a label of int type, and an ArrayList of Edges (representing adjacencies)
*/
public class Vertex {
	private int label;
	private ArrayList<Edge> edges;

	public Vertex(int label){
		this.label = label;
		edges = new ArrayList<Edge>();
	}
	public Vertex(int label, ArrayList<Edge> edges){
		this(label);
		addEdges(edges);
	}
	public int getLabel(){
		return label;
	}
	
	public void setLabel(int newLabel){
		label = newLabel;
	}

	public void setEdges(ArrayList<Edge> newEdges){
		edges = newEdges;
	}

	public ArrayList<Edge> getEdges(){
		return edges;
	}

	public void addEdge(Vertex v, double weight){
		edges.add(new Edge(this, v, weight));
	}

	public void addEdge(Edge e){
		edges.add(e);
	}

	public void addEdges(ArrayList<Edge> edges){
		for (Edge e: edges){
			this.edges.add(e);
		}
	}

	public String toString(){
		return String.valueOf(label);
	}

	public boolean equals(Object v){
		if(v == this)
			return true;
		if (getClass() != v.getClass())
			return false;
		if (v == null)
			return false;
		return label == ((Vertex) v).getLabel();
	}

}