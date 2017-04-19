import java.util.*;
import java.io.*;

public class Tree extends Graph{
	//ArrayList to keep track of visitedVertices
	private ArrayList<Vertex> visitedV;
	private Graph original;
	private double totalCost;
	private int tracker;

	public Tree(String fname, int init) throws IOException {
		super();
		original = new Graph(fname);
		visitedV = new ArrayList<Vertex>();
		totalCost = 0.0;
		tracker = 0;
		prim(init);
	}


	public void prim(int init){
		//vMap = vertices();
		//ArrayList<Vertex> origV = original.getVertices();

		Vertex v = original.getVertex(init);
		visitedV.add(v);
		original.removeVertex(init);
		addVertex(new Vertex(v.getLabel()));
		//vMap is our set Q of unvisited vertices
		while(!original.isEmpty()){
			Edge e = getSmallestEdge();
			v = e.getTo();
			visitedV.add(v);
			original.removeVertex(v.getLabel());
			addEdge(e.getFrom().getLabel(), e.getTo().getLabel(), e.getWeight());
			//vMap.get(e.getFrom().label).addEdge(e);
			totalCost += e.getWeight();
			tracker ++;
		}
	}

	public Edge getSmallestEdge(){
		Edge smallest = null;
		for (Vertex v: visitedV){
			for(Edge e: v.getEdges()){
				if(!visitedV.contains(e.getTo())){
					if(smallest == null)
						smallest = e;
					else if (e.getWeight() < smallest.getWeight())
						smallest = e;
					tracker ++;
				}
			}
		}
		return smallest;

	}

	public void output(){
		super.output();
		System.out.println("\nTotal Cost: " + totalCost + "\tRuntime Tracker:"+ tracker +"\n");
	}

	public static void main(String[] args) throws IOException{
		if (args.length != 1) {
            System.err.println ("Wrong number of arguments.");
            System.exit (1);
        }
        for (int i = 1; i<7; i++){
        	Tree t = new Tree(args[0], i);
        	System.out.println("Output of Tree (init "+ i+ "):\n");
        	t.output();
        }
	
	}
	
}

/*
Output:
calvisitor-10-105-187-14:minspan arshzahed$ java Tree data.txt
Output of Tree (init 1):

From: 1
	To: 2	Weight: 1.0
From: 2
	To: 1	Weight: 1.0
	To: 3	Weight: 1.0
	To: 4	Weight: 1.0
From: 3
	To: 2	Weight: 1.0
	To: 6	Weight: 1.0
From: 4
	To: 2	Weight: 1.0
From: 5
	To: 6	Weight: 1.0
From: 6
	To: 3	Weight: 1.0
	To: 5	Weight: 1.0

Total Cost: 5.0	Runtime Tracker:22

Output of Tree (init 2):

From: 1
	To: 2	Weight: 1.0
From: 2
	To: 1	Weight: 1.0
	To: 3	Weight: 1.0
	To: 4	Weight: 1.0
From: 3
	To: 2	Weight: 1.0
	To: 6	Weight: 1.0
From: 4
	To: 2	Weight: 1.0
From: 5
	To: 6	Weight: 1.0
From: 6
	To: 3	Weight: 1.0
	To: 5	Weight: 1.0

Total Cost: 5.0	Runtime Tracker:24

Output of Tree (init 3):

From: 1
	To: 2	Weight: 1.0
From: 2
	To: 3	Weight: 1.0
	To: 1	Weight: 1.0
	To: 4	Weight: 1.0
From: 3
	To: 2	Weight: 1.0
	To: 6	Weight: 1.0
From: 4
	To: 2	Weight: 1.0
From: 5
	To: 6	Weight: 1.0
From: 6
	To: 3	Weight: 1.0
	To: 5	Weight: 1.0

Total Cost: 5.0	Runtime Tracker:30

Output of Tree (init 4):

From: 1
	To: 2	Weight: 1.0
From: 2
	To: 4	Weight: 1.0
	To: 1	Weight: 1.0
	To: 3	Weight: 1.0
From: 3
	To: 2	Weight: 1.0
From: 4
	To: 2	Weight: 1.0
	To: 6	Weight: 1.0
From: 5
	To: 6	Weight: 1.0
From: 6
	To: 4	Weight: 1.0
	To: 5	Weight: 1.0

Total Cost: 5.0	Runtime Tracker:32

Output of Tree (init 5):

From: 1
	To: 2	Weight: 1.0
From: 2
	To: 3	Weight: 1.0
	To: 1	Weight: 1.0
From: 3
	To: 6	Weight: 1.0
	To: 2	Weight: 1.0
From: 4
	To: 6	Weight: 1.0
From: 5
	To: 6	Weight: 1.0
From: 6
	To: 5	Weight: 1.0
	To: 3	Weight: 1.0
	To: 4	Weight: 1.0

Total Cost: 5.0	Runtime Tracker:24

Output of Tree (init 6):

From: 1
	To: 2	Weight: 1.0
From: 2
	To: 3	Weight: 1.0
	To: 1	Weight: 1.0
From: 3
	To: 6	Weight: 1.0
	To: 2	Weight: 1.0
From: 4
	To: 6	Weight: 1.0
From: 5
	To: 6	Weight: 1.0
From: 6
	To: 3	Weight: 1.0
	To: 4	Weight: 1.0
	To: 5	Weight: 1.0

Total Cost: 5.0	Runtime Tracker:24*/