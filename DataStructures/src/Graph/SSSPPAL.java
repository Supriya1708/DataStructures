package Graph;
import java.util.*;
public class SSSPPAL {
	public static void main(String[] args) {
		ArrayList<SSSPPNode1> nodeList = new ArrayList<>();
		nodeList.add(new SSSPPNode1(0,"A"));
		nodeList.add(new SSSPPNode1(1,"B"));
		nodeList.add(new SSSPPNode1(2,"C"));
		nodeList.add(new SSSPPNode1(3,"D"));
		nodeList.add(new SSSPPNode1(4,"E"));
		nodeList.add(new SSSPPNode1(5,"F"));
		nodeList.add(new SSSPPNode1(6,"G"));
		ShortestPathAdjacencyList graph = new ShortestPathAdjacencyList(nodeList);
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
		graph.shortestPath(nodeList.get(0));
	}
}
class SSSPPNode1{
	int index;
	String vertex;
	boolean isVisited = false;
	SSSPPNode1 parent ;
	ArrayList<SSSPPNode1> neighbours = new ArrayList<>();
	SSSPPNode1(int index, String vertex){
		this.index = index ;
		this.vertex = vertex;
	}
}
class ShortestPathAdjacencyList{
	ArrayList<SSSPPNode1> nodeList = new ArrayList<>();
	ShortestPathAdjacencyList(ArrayList<SSSPPNode1> nodeList){
		this.nodeList = nodeList ;
	}
	public void addUndirectedEdge(int i , int j) {
		SSSPPNode1 first = nodeList.get(i);
		SSSPPNode1 second = nodeList.get(j);
		first.neighbours.add(second);
		second.neighbours.add(first);
	}
	public void printPath(SSSPPNode1 node) {
		if(node.parent!= null) {
			printPath(node.parent);
		}System.out.print(node.vertex+"  ");
	}
	public void shortestPath(SSSPPNode1 node) {
		LinkedList<SSSPPNode1> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			SSSPPNode1 temp = queue.remove(0);
			temp.isVisited = true;
			System.out.print("The shortest path for "+node.vertex+" : ");
			printPath(temp);
			System.out.println();
			for(SSSPPNode1 neighbour : temp.neighbours) {
				if(!neighbour.isVisited) {
					neighbour.isVisited = true ;
					neighbour.parent = temp;
					queue.add(neighbour);
				}
			}
		}
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0 ; i<nodeList.size();i++) {
			SSSPPNode1 first = nodeList.get(i);
			str.append(first.vertex+": ");
			int j = 0 ;
			for(j = 0 ; j<first.neighbours.size()-1;j++) {
				str.append(first.neighbours.get(j).vertex+"->");
			}str.append(first.neighbours.get(j).vertex+"\n");
		}return str.toString();
	}
}