package Graph;
import java.util.*;
public class DepthFirstSearch {
	public static void main(String[] args) {
		ArrayList<DFSNode> nodeList = new ArrayList<>();
		nodeList.add(new DFSNode(0,"A"));
		nodeList.add(new DFSNode(1,"B"));
		nodeList.add(new DFSNode(2,"C"));
		nodeList.add(new DFSNode(3,"D"));
		nodeList.add(new DFSNode(4,"E"));
		DFS graph = new DFS(nodeList);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		System.out.println(graph.toString());
		graph.dfs();
	}
}
class DFSNode{
	int index;
	String vertex;
	boolean isVisited = false;
	DFSNode(int index, String vertex){
		this.index = index;
		this.vertex = vertex;
	}
}
class DFS{
	ArrayList<DFSNode> nodeList = new ArrayList<>();
	int[][] adjacencyMatrix ;
	DFS(ArrayList<DFSNode> nodeList){
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	public void addEdge(int i , int j) {
		adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 1 ;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("  ");
		for(int i=0; i<nodeList.size();i++) {
			str.append(nodeList.get(i).vertex+" ");
		}str.append("\n");
		for(int i = 0 ; i<nodeList.size();i++) {
			str.append(nodeList.get(i).vertex+" ");
			for(int j=0 ; j<nodeList.size();j++) {
				str.append(adjacencyMatrix[i][j]+" ");
			}str.append("\n");
		}
		return str.toString();
	}
	public void dfsVisit(DFSNode node) {
		Stack<DFSNode> stack = new Stack<>();
		stack.push(node); 
		while(!stack.isEmpty()) {
			DFSNode temp = stack.pop();
			temp.isVisited = true ;
			System.out.print(temp.vertex+" ");
			for(int i=0; i<nodeList.size();i++) {
				if(adjacencyMatrix[temp.index][i] == 1) {
					if(!nodeList.get(i).isVisited) {
						nodeList.get(i).isVisited = true ;
						stack.add(nodeList.get(i));
					}
				}
			}
		}
	}
	public void dfs() {
		System.out.print("The DFS traversal of the given graph is :  ");
		for(DFSNode node : nodeList) {
			if(!node.isVisited) {
				dfsVisit(node);
			}
		}
	}
	
}
