package Graph;
import java.util.*;
public class DijkstraAlgorithm {
	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode(0,"A"));
		nodeList.add(new WeightedNode(1,"B"));
		nodeList.add(new WeightedNode(2,"C"));
		nodeList.add(new WeightedNode(3,"D"));
		nodeList.add(new WeightedNode(4,"E"));
		nodeList.add(new WeightedNode(5,"F"));
		nodeList.add(new WeightedNode(6,"G"));
		Dijkstra graph = new Dijkstra(nodeList);
		graph.addWeightedEdge(0, 1, 2);
		graph.addWeightedEdge(0, 2, 5);
		graph.addWeightedEdge(1, 2, 6);
		graph.addWeightedEdge(1, 3, 1);
		graph.addWeightedEdge(1, 4, 3);
		graph.addWeightedEdge(2, 5, 8);
		graph.addWeightedEdge(3, 4, 4);
		graph.addWeightedEdge(4, 6, 9);
		graph.addWeightedEdge(5, 6, 7);
		graph.dijkstraPath(nodeList.get(0));
	}
}
class WeightedNode implements Comparable<WeightedNode>{
	String vertex;
	int index;
	boolean isVisited = false;
	WeightedNode parent ;
	ArrayList<WeightedNode> neighbours = new ArrayList<>();
	HashMap<WeightedNode,Integer> weights = new HashMap<>();
	int distance;
	WeightedNode(int index , String vertex){
		this.index = index ;
		this.vertex = vertex;
		distance = Integer.MAX_VALUE;
	}
	@Override
	public String toString() {
		return vertex;
	}
	@Override
	public int compareTo(WeightedNode o) {
		return this.distance-o.distance;
	}
}
class Dijkstra{
	ArrayList<WeightedNode> nodeList = new ArrayList<>();
	Dijkstra(ArrayList<WeightedNode> nodeList){
		this.nodeList = nodeList;
	}
	public void addWeightedEdge(int i , int j  , int dist) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbours.add(second);
		first.weights.put(second , dist);
	}
	public void pathPrint(WeightedNode node) {
		if(node.parent != null) {
			pathPrint(node.parent);
		}System.out.print(node.vertex+"  ");
	}
	public void dijkstraPath(WeightedNode node) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		node.distance = 0;
		queue.addAll(nodeList);
		while(!queue.isEmpty()) {
			WeightedNode temp = queue.remove();
			temp.isVisited = true ;
			for(WeightedNode neighbour : temp.neighbours) {
				if(neighbour.distance > temp.distance + temp.weights.get(neighbour)) {
					neighbour.distance = temp.distance + temp.weights.get(neighbour);
					neighbour.parent = temp;
					queue.remove(neighbour);
					queue.add(neighbour);
				}
			}
		}
		for(WeightedNode DijkstraNode : nodeList) {
			System.out.print("The path for "+DijkstraNode+" is : ");
			pathPrint(DijkstraNode);
			System.out.println();
		}
	}
}
