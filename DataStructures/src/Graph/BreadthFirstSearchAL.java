package Graph;
import java.util.*;
public class BreadthFirstSearchAL {
	public static void main(String[] args) {
		ArrayList<Node1> nodeList = new ArrayList<>();
		nodeList.add(new Node1(0,"A"));
		nodeList.add(new Node1(1,"B"));
		nodeList.add(new Node1(2,"C"));
		nodeList.add(new Node1(3,"D"));
		nodeList.add(new Node1(4,"E"));
		BFSAL graph = new BFSAL(nodeList);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		System.out.println(graph.toString());
		graph.bfs();
	}
}

class Node1{
	int index;
	String vertex;
	ArrayList<Node1> neighbours = new ArrayList<>();
	boolean isVisited = false;
	Node1(int index , String vertex){
		this.index = index;
		this.vertex = vertex;
	}
}
class BFSAL{
	ArrayList<Node1> nodeList = new ArrayList<>();
	BFSAL(ArrayList<Node1> nodeList){
		this.nodeList = nodeList;
	}
	public void addEdge(int i , int j) {
		Node1 first = nodeList.get(i);
		Node1 second = nodeList.get(j);
		first.neighbours.add(second);
		second.neighbours.add(first);
	}
	public void bfsVisit(Node1 node) {
		LinkedList<Node1> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node1 temp = queue.remove(0);
			temp.isVisited = true ;
			System.out.print(temp.vertex+"  ");
			ArrayList<Node1> neighbours = temp.neighbours;
			for(Node1 neighbour : neighbours) {
				if(!neighbour.isVisited) {
					queue.add(neighbour);
					neighbour.isVisited = true ;
				}
			}
		}
	}
	public void bfs() {
		System.out.print("The BFS traversal of the graph is : \t");
		for(Node1 node:nodeList) {
			if(!node.isVisited) {
				bfsVisit(node);
			}
		}
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0 ; i<nodeList.size();i++) {
			Node1 first = nodeList.get(i);
			str.append(first.vertex+": ");
			int j = 0 ;
			for(j = 0 ; j<first.neighbours.size()-1;j++) {
				str.append(first.neighbours.get(j).vertex+"->");
			}str.append(first.neighbours.get(j).vertex+"\n");
		}return str.toString();
	}
	
}
