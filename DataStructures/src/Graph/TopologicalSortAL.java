package Graph;
import java.util.*;
public class TopologicalSortAL {
	public static void main(String[] args) {
		ArrayList<TSNode1> nodeList = new ArrayList<>();
		nodeList.add(new TSNode1(0,"A"));
		nodeList.add(new TSNode1(1,"B"));
		nodeList.add(new TSNode1(2,"C"));
		nodeList.add(new TSNode1(3,"D"));
		nodeList.add(new TSNode1(4,"E"));
		nodeList.add(new TSNode1(5,"F"));
		nodeList.add(new TSNode1(6,"G"));
		nodeList.add(new TSNode1(7,"H"));
		TSAM graph = new TSAM(nodeList);
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(2, 4);
		graph.addDirectedEdge(4, 7);
		graph.addDirectedEdge(4, 5);
		graph.addDirectedEdge(5, 6);
		graph.addDirectedEdge(1, 2);
		graph.addDirectedEdge(1, 3);
		graph.addDirectedEdge(3, 5);
		System.out.println(	graph.toString());
		graph.ts();
	}
}
class TSNode1{
	int index;
	String vertex;
	boolean isVisited = false;
	ArrayList<TSNode1> neighbours = new ArrayList<>();
	TSNode1(int index , String vertex){
		this.index = index ;
		this.vertex = vertex ;
	}
}
class TSAM{
	ArrayList<TSNode1> nodeList = new ArrayList<>();
	TSAM(ArrayList<TSNode1> nodeList){
		this.nodeList = nodeList ;
	}
	public void addDirectedEdge(int i , int j) {
		TSNode1 first = nodeList.get(i);
		TSNode1 second = nodeList.get(j);
		first.neighbours.add(second);
	}
	private void topologicalSort(TSNode1 node , Stack<TSNode1> stack) {
		for(TSNode1 neighbour : node.neighbours) {
			if(!neighbour.isVisited) {
				topologicalSort(neighbour , stack);
			}
		}
		stack.push(node);
		node.isVisited = true;
	}
	public void ts() {
		System.out.print("The topological sort of above graph is :  ");
		Stack<TSNode1> stack = new Stack<>();
		for(TSNode1 node : nodeList) {
			if(!node.isVisited) {
				topologicalSort(node,stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().vertex+"  ");
		}
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0 ; i<nodeList.size();i++) {
			TSNode1 first = nodeList.get(i);
			str.append(first.vertex+": ");
			int j ;
			for(j = 0 ; j<first.neighbours.size();j++) {
				str.append(first.neighbours.get(j).vertex+"  ");
			}str.append("\n");
		}return str.toString();
	}
}
