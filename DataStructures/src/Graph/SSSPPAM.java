package Graph;
import java.util.*;
public class SSSPPAM {
	public static void main(String[] args) {
		ArrayList<SSSPPNode> nodeList = new ArrayList<>();
		nodeList.add(new SSSPPNode(0,"A"));
		nodeList.add(new SSSPPNode(1,"B"));
		nodeList.add(new SSSPPNode(2,"C"));
		nodeList.add(new SSSPPNode(3,"D"));
		nodeList.add(new SSSPPNode(4,"E"));
		nodeList.add(new SSSPPNode(5,"F"));
		nodeList.add(new SSSPPNode(6,"G"));
		SingleSourceShortestPathProblemAM graph = new SingleSourceShortestPathProblemAM(nodeList);
		graph.addUndirectedEdge(0, 1);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(1, 6);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(3, 5);
		graph.addUndirectedEdge(4, 5);
		graph.addUndirectedEdge(5, 6);
		System.out.println(graph.toString());
		graph.SSSPP(nodeList.get(0));
	}
}
class SSSPPNode{
	int index;
	String vertex;
	boolean isVisited = false;
	SSSPPNode parent ;
	SSSPPNode(int index , String vertex){
		this.index = index;
		this.vertex = vertex;
	}
}
class SingleSourceShortestPathProblemAM{
	ArrayList<SSSPPNode> nodeList = new ArrayList<>();
	int[][] adjacencyMatrix ;
	SingleSourceShortestPathProblemAM(ArrayList<SSSPPNode> nodeList){
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	public void addUndirectedEdge(int i , int j) {
		adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 1 ;
	}
	public void printPath( SSSPPNode node) {
		if(node.parent!= null) {
			printPath(node.parent);
		}System.out.print(node.vertex+"  ");
	}
	public ArrayList<SSSPPNode> getNeighbours(SSSPPNode node){
		ArrayList<SSSPPNode> neighbours = new ArrayList<>();
		int nodeIndex = node.index;
		for(int j=0 ; j < adjacencyMatrix.length ; j++) {
			if(adjacencyMatrix[nodeIndex][j] == 1) {
				neighbours.add(nodeList.get(j));
			}
		}return neighbours;
	}
	public void SSSPP( SSSPPNode node) {
		LinkedList<SSSPPNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			SSSPPNode temp = queue.remove(0);
			temp.isVisited = true ;
			System.out.print("The shortest path for "+temp.vertex+" : ");
			printPath(temp);
			System.out.println();
			ArrayList<SSSPPNode> neighbours = getNeighbours(temp);
			for(SSSPPNode neighbour : neighbours) {
				if(!neighbour.isVisited) {
					neighbour.isVisited = true ;
					queue.add(neighbour);
					neighbour.parent = temp;
				}
			}
		}
	}
	//To print graph
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
