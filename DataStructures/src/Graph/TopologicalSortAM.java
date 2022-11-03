package Graph;
import java.util.*;
public class TopologicalSortAM {
	public static void main(String[] args) {
		ArrayList<TSNode> nodeList = new ArrayList<>();
		nodeList.add(new TSNode(0,"A"));
		nodeList.add(new TSNode(1,"B"));
		nodeList.add(new TSNode(2,"C"));
		nodeList.add(new TSNode(3,"D"));
		nodeList.add(new TSNode(4,"E"));
		nodeList.add(new TSNode(5,"F"));
		nodeList.add(new TSNode(6,"G"));
		nodeList.add(new TSNode(7,"H"));
		TopologicalSort graph = new TopologicalSort(nodeList);
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
class TSNode{
	int index;
	String vertex;
	boolean isVisited = false;
	TSNode(int index , String vertex){
		this.index = index ;
		this.vertex = vertex ;
	}
}
class TopologicalSort{
	ArrayList<TSNode> nodeList = new ArrayList<>();
	int[][] adjacencyMatrix ;
	TopologicalSort(ArrayList<TSNode> nodeList){
		this.nodeList = nodeList ;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	public void addDirectedEdge(int i , int j) {
		adjacencyMatrix[i][j] = 1;
	}
	private void topologicalSort(TSNode node , Stack<TSNode> stack) {
		for(int i = 0 ; i<nodeList.size();i++) {
			if(adjacencyMatrix[node.index][i] == 1) {
				if(!nodeList.get(i).isVisited) {
					topologicalSort(nodeList.get(i),stack);
				}
			}
		}node.isVisited = true ;
		stack.push(node);
	}
	public void ts() {
		System.out.print("The topological sort of above graph is :  ");
		Stack<TSNode> stack = new Stack<>();
		for(TSNode node : nodeList) {
			if(!node.isVisited) {
				topologicalSort(node,stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().vertex+"  ");
		}
	}
	public String toString() {
		StringBuilder str  = new StringBuilder();
		str.append("   ");
		for(int i  = 0 ; i < nodeList.size() ; i++) {
			str.append(nodeList.get(i).vertex+"  ");
		}str.append("\n");
		for(int i  = 0 ; i < nodeList.size(); i++) {
			str.append(nodeList.get(i).vertex+"  ");
			for(int j : adjacencyMatrix[i]) {
				str.append(j+"  ");
			}str.append("\n");
		}
		String res = str.toString();
		return res;
	}
}
