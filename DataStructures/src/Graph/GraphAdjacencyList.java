package Graph;
import java.util.*;
public class GraphAdjacencyList {
	public static void main(String[] args) {
		ArrayList<Node> nodeList = new ArrayList<>();
		nodeList.add(new Node('A',0));
		nodeList.add(new Node('B',1));
		nodeList.add(new Node('C',2));
		nodeList.add(new Node('D',3));
		nodeList.add(new Node('E',4));
		GAL graph = new GAL(nodeList);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		System.out.println(graph.toString());
	}
}
class Node{
	int index;
	char vertex;
	ArrayList<Node> neighbours  = new ArrayList<>();
	Node(char vertex,int index){
		this.index = index;
		this.vertex = vertex;
	}
}
class GAL{
	ArrayList<Node> nodeList = new ArrayList<>();
	GAL(ArrayList<Node> nodeList){
		this.nodeList = nodeList;
	}
	public void addEdge(int i , int j) {
		Node first = nodeList.get(i);
		Node second = nodeList.get(j);
		first.neighbours.add(second);
		second.neighbours.add(first);
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0 ; i<nodeList.size();i++) {
			Node first = nodeList.get(i);
			str.append(first.vertex+": ");
			int j = 0 ;
			for(j = 0 ; j<first.neighbours.size()-1;j++) {
				str.append(first.neighbours.get(j).vertex+"->");
			}str.append(first.neighbours.get(j).vertex+"\n");
		}return str.toString();
	}
}
