package ua.nure.uvarov.Practice6.part4;

public class Part4 {
	
	public static void main(String[] args) {
		Graph graph = new Graph(22);
		System.out.println(graph.addEdge(1,2));
		System.out.println(graph.addEdge(2,1));
		System.out.println(graph.addEdge(21,12));
		System.out.println(graph.addEdge(12,21));
		System.out.println(graph.removeEdge(2, 1));
		System.out.println(graph.addEdge(1,2));
	}

}
