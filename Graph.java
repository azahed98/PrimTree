import java.util.*;
import java.io.*;

public class Graph {
	private HashMap<Integer, Vertex> vMap;
	//private ArrayList<Vertex> vertices;

	public Graph(){
		vMap = new HashMap<Integer, Vertex>(); 
	}
	public Graph(String fname) throws IOException {
		//vertices = new ArrayList<Vertex>();
		this();
		readGraph(fname);
	}

	public void readGraph(String fname) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fname));
		String line = br.readLine();
		while (line != null){
			String[] nums = line.split(" ");
			addEdge(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Double.parseDouble(nums[2]));
			line = br.readLine();
		}
	}

	public HashMap<Integer, Vertex> getVertices(){
		return vMap;
	}
	
	public Vertex getVertex(int label){
		Vertex v = vMap.get(label);
		if(v == null){
			v = new Vertex(label);
			addVertex(v);
		}
		return v;
	}

	protected Vertex vertices(int label){
		Vertex v = vMap.get(label);
		if(v == null){
			v = new Vertex(label);
			addVertex(v);
		}
		return v;
	}

	public void addVertex(Vertex v){
		//vertices.add(v);
		vMap.put(v.getLabel(), v);
	}

	public void addEdge(int from, int to, double e){
		Vertex v = getVertex(from);
		Vertex dest = getVertex(to);
		v.addEdge(dest, e);
		dest.addEdge(v, e);

	}

	public Vertex removeVertex(int label){
		return vMap.remove(label);
	}

	public void output() {
		Vertex v;
		for (int label: vMap.keySet()){
			v = vMap.get(label);
			System.out.println("From: " + label);
			for (Edge e: v.getEdges()){
				System.out.println("\tTo: " + e.getTo() + "\tWeight: " + e.getWeight());
			}
		}
	}

	public boolean isEmpty(){
		return vMap.size() == 0;
	}

	public static void main(String[] args) throws IOException{
		if (args.length != 1) {
            System.err.println ("Wrong number of arguments.");
            System.exit (1);
        }
		Graph g = new Graph(args[0]);
		System.out.println("Output of Graph:\n");
		g.output();

	}
}