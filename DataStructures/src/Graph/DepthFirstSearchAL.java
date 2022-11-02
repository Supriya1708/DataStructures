package Graph;
import java.util.*;
public class DepthFirstSearchAL {
	public static void main(String[] args) {
		ArrayList<DFSNode1> nodeList = new ArrayList<>();
		nodeList.add(new DFSNode1(0,"A"));
		nodeList.add(new DFSNode1(1,"B"));
		nodeList.add(new DFSNode1(2,"C"));
		nodeList.add(new DFSNode1(3,"D"));
		nodeList.add(new DFSNode1(4,"E"));
		DFSAL graph = new DFSAL(nodeList);
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
class DFSNode1{
	int index ; 
	String vertex ; 
	boolean isVisited = false ;
	ArrayList<DFSNode1> neighbours = new ArrayList<>();
	DFSNode1(int index , String vertex){
		this.index = index ;
		this.vertex = vertex ;
	}
}
class DFSAL{
	ArrayList<DFSNode1> nodeList = new ArrayList<>();
	DFSAL(ArrayList<DFSNode1> nodeList){
		this.nodeList = nodeList;
	}
	public void addEdge(int i , int j) {
		DFSNode1 first = nodeList.get(i);
		DFSNode1 second = nodeList.get(j);
		first.neighbours.add(second);
		second.neighbours.add(first);
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0 ; i<nodeList.size();i++) {
			DFSNode1 first = nodeList.get(i);
			str.append(first.vertex+": ");
			int j = 0 ;
			for(j = 0 ; j<first.neighbours.size()-1;j++) {
				str.append(first.neighbours.get(j).vertex+"->");
			}str.append(first.neighbours.get(j).vertex+"\n");
		}return str.toString();
	}
	public void dfsVisit(DFSNode1 node) {
		Stack<DFSNode1> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			DFSNode1 temp = stack.pop();
			temp.isVisited = true ;
			System.out.print(temp.vertex+" ");
			ArrayList<DFSNode1> neighbours = temp.neighbours;
			for(DFSNode1 neighbour : neighbours) {
				if(!neighbour.isVisited) {
					stack.push(neighbour);
					neighbour.isVisited = true ;
				}
			}
		}
	}
	public void dfs() {
		System.out.println("The DFS traversal of the given graph is :  ");
		for(DFSNode1 node : nodeList) {
			if(!node.isVisited) {
				dfsVisit(node);
			}
		}
	}
}
