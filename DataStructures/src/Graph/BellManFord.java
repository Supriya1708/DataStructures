package Graph;
import java.util.*;
public class BellManFord {
	public static void main(String[] args) {
		ArrayList<WeightedNode1> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode1(0,"A"));
		nodeList.add(new WeightedNode1(1,"B"));
		nodeList.add(new WeightedNode1(2,"C"));
		nodeList.add(new WeightedNode1(3,"D"));
		nodeList.add(new WeightedNode1(4,"E"));
		nodeList.add(new WeightedNode1(5,"F"));
		nodeList.add(new WeightedNode1(6,"G"));
		BMFAlgorithm graph = new BMFAlgorithm(nodeList);
		graph.addWeightedEdge(0, 1, 2);
		graph.addWeightedEdge(0, 2, 5);
		graph.addWeightedEdge(1, 2, 6);
		graph.addWeightedEdge(1, 3, 1);
		graph.addWeightedEdge(1, 4, 3);
		graph.addWeightedEdge(2, 5, 8);
		graph.addWeightedEdge(3, 4, 4);
		graph.addWeightedEdge(4, 6, 9);
		graph.addWeightedEdge(5, 6, 7);
		graph.bellManFordAlgo(nodeList.get(0));
	}
}
class WeightedNode1 implements Comparable<WeightedNode1>{
	int index;
	String vertex;
	int distance;
	boolean isVisited = false ;
	ArrayList<WeightedNode1> neighbours = new ArrayList<>();
	HashMap<WeightedNode1,Integer> weights = new HashMap<>();
	WeightedNode1 parent;
	WeightedNode1(int index , String vertex){
		this.index = index;
		this.vertex = vertex;
		distance = Integer.MAX_VALUE;
	}
	@Override
	public int compareTo(WeightedNode1 o) {
		return this.distance - o.distance;
	}
}
class BMFAlgorithm{
	ArrayList<WeightedNode1> nodeList = new ArrayList<>();
	BMFAlgorithm(ArrayList<WeightedNode1> nodeList){
		this.nodeList = nodeList ;
	}
	public void addWeightedEdge(int i , int j , int distance) {
		WeightedNode1 first = nodeList.get(i);
		WeightedNode1 second = nodeList.get(j);
		first.neighbours.add(second);
		first.weights.put(second , distance);
	}
	public void printPath(WeightedNode1 node) {
		if(node.parent != null) {
			printPath(node.parent);
		}System.out.print(node.vertex+"  ");
	}
	//BellManFord Algorithm
	public void bellManFordAlgo(WeightedNode1 sourceNode) {
		sourceNode.distance = 0;
		for(int i = 0 ; i < nodeList.size() ; i++) {
			for(WeightedNode1 currentNode : nodeList) {
				for(WeightedNode1 neighbour : currentNode.neighbours) {
					if(neighbour.distance > currentNode.distance+currentNode.weights.get(neighbour)) {
						neighbour.distance = currentNode.distance+currentNode.weights.get(neighbour);
						neighbour.parent = currentNode ;
					}
				}
			}
		}System.out.println("Checking for negative cycles: ");
		for(WeightedNode1 node : nodeList) {
			for(WeightedNode1 neighbour : node.neighbours) {
				if(neighbour.distance > node.distance+node.weights.get(neighbour)) {
					System.out.println("Negative Cycle Found at ");
					System.out.println(node.vertex+"  and old distance is "+node.distance);
					return;
				}
			}
		}System.out.println("No negative Cycle Found");
		System.out.println("Printing shortest paths ....");
		for(WeightedNode1 node: nodeList) {
			System.out.print("Printing path to "+node.vertex+" with distance "+node.distance+" : ");
			printPath(node);
			System.out.println();
		}
	}
	
}
