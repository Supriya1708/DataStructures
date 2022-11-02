package Graph;
import java.util.*;
public class BreadthFirstSearch {
	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode("A",0));
		nodeList.add(new GraphNode("B",1));
		nodeList.add(new GraphNode("C",2));
		nodeList.add(new GraphNode("D",3));
		nodeList.add(new GraphNode("E",4));
		BFS graph  = new BFS(nodeList);
		graph.addUndirectedEdge(0, 1);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(0, 3);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(3, 4);
		System.out.println(graph.toString());
		graph.bfs();
	}
	
}

class GraphNode{
	public String name ; 
	public int index ;
	public boolean isVisited = false;
	GraphNode(String name , int index ){
		this.name = name ; 
		this.index  = index ;
	}
}

class BFS{
	ArrayList<GraphNode> nodeList = new ArrayList<>();
	int[][] adjacencyMatrix;
	BFS(ArrayList<GraphNode> nodeList){
		this.nodeList = nodeList ;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	public void addUndirectedEdge(int v1 , int v2) {
		adjacencyMatrix[v1][v2] = 1 ;
		adjacencyMatrix[v2][v1] = 1 ;
	}
	public void bfs() {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(nodeList.get(0));
		while(!queue.isEmpty()) {
			GraphNode temp = queue.remove(0);
			temp.isVisited = true ;
			System.out.print(temp.name+"  ");
			for(int j=0;j<nodeList.size();j++) {
				if(adjacencyMatrix[temp.index][j]==1) {
					if(!nodeList.get(j).isVisited) {
						nodeList.get(j).isVisited = true ;
						queue.add(nodeList.get(j));
					}
				}
			}
		}
	}
	public String toString() {
		StringBuilder str  = new StringBuilder();
		str.append("   ");
		for(int i  = 0 ; i < nodeList.size() ; i++) {
			str.append(nodeList.get(i).name+"  ");
		}str.append("\n");
		for(int i  = 0 ; i < nodeList.size(); i++) {
			str.append(nodeList.get(i).name+"  ");
			for(int j : adjacencyMatrix[i]) {
				str.append(j+"  ");
			}str.append("\n");
		}
		String res = str.toString();
		return res;
	}
}
