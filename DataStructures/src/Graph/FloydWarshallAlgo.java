package Graph;
import java.util.*;
public class FloydWarshallAlgo {
	public static void main(String[] args) {
		ArrayList<WeightedNode2> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode2(0,"A"));
		nodeList.add(new WeightedNode2(1,"B"));
		nodeList.add(new WeightedNode2(2,"C"));
		nodeList.add(new WeightedNode2(3,"D"));
		FloydWarshallAlgorithm graph = new FloydWarshallAlgorithm(nodeList);
		graph.addWeightedEdge(0, 1, 8);
		graph.addWeightedEdge(0, 3, 1);
		graph.addWeightedEdge(1, 2, 1);
		graph.addWeightedEdge(2, 0, 4);
		graph.addWeightedEdge(3, 1, 2);
		graph.addWeightedEdge(3, 2, 9);
		graph.floydWarshallAlgo();
	}
}
class WeightedNode2{
	int index;
	String vertex;
	int distance;
	ArrayList<WeightedNode2> neighbours = new ArrayList<>();
	HashMap<WeightedNode2,Integer> weights = new HashMap<>();
	WeightedNode2(int index , String vertex){
		this.index = index;
		this.vertex = vertex;
		distance = Integer.MAX_VALUE;
	}
}
class FloydWarshallAlgorithm{
	ArrayList<WeightedNode2> nodeList = new ArrayList<>();
	FloydWarshallAlgorithm(ArrayList<WeightedNode2> nodeList){
		this.nodeList = nodeList;
	}
	public void addWeightedEdge(int i , int j , int distance) {
		WeightedNode2 first = nodeList.get(i);
		WeightedNode2 second = nodeList.get(j);
		first.neighbours.add(second);
		first.weights.put(second, distance);
	}
	public void floydWarshallAlgo() {
		int size = nodeList.size();
		int[][] D = new int[size][size];
		//Filling Distance Matrix
		for(int i = 0 ; i< size ; i++) {
			WeightedNode2 first = nodeList.get(i);
			for(int j = 0 ; j< size ; j++) {
				WeightedNode2 second = nodeList.get(j);
				if(i == j) {
					D[i][j] = 0 ;
				}else if(first.weights.containsKey(second)) {
					D[i][j] = first.weights.get(second);
				}else {
					D[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}
		//Main Algorithm
		for(int i = 0 ; i< nodeList.size();i++) {
			for(int j = 0 ; j < nodeList.size(); j++) {
				for(int k = 0 ; k < nodeList.size(); k++) {
					if(D[j][k] > D[j][i] + D[i][k]) {
						D[j][k] = D[j][i] + D[i][k];
					}
				}
			}
		}
		//Printing Distance Matrix
		for(int i = 0 ; i < nodeList.size(); i++) {
			System.out.print("Printing distances of all vertices from "+nodeList.get(i).vertex+" : ");
			for(int  j = 0 ; j < nodeList.size() ; j++) {
				System.out.print(D[i][j]+"  ");
			}System.out.println();
		}
	}
}