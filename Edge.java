/*
@Author: Arsh Zahed
A basic edge class for graph implementation
Contains the weight and the to Vertex
*/
public class Edge {
	private Vertex from;
	private Vertex to;
	private double weight;

	public Edge(Vertex from, Vertex to, double weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public Vertex getFrom(){
		return from;
	}

	public Vertex getTo(){
		return to;
	}

	public double getWeight(){
		return weight;
	}

	public void setFrom(Vertex newFrom){
		from = newFrom;
	}

	public void setTo(Vertex newTo){
		to = newTo;
	}

	public void setWeight(double newWeight){
		weight = newWeight;
	}
}