package solutions.java;

import java.util.HashMap;

public class UndirectedGraph {
	public UndirectedGraphNode[] nodes;
	private int size;
	private HashMap<Integer, UndirectedGraphNode> graphNodes = new HashMap<>();
	
	public UndirectedGraph(String s){
		String[] allNodesString = s.split("#");
		nodes = new UndirectedGraphNode[allNodesString.length];
		int counter = 0;
		for (String eachNodeString:allNodesString){
			String[] nodeString = eachNodeString.split(",");
			if (!graphNodes.containsKey(Integer.parseInt(nodeString[0]))) {
				UndirectedGraphNode newNode = new UndirectedGraphNode(Integer.parseInt(nodeString[0]));
				graphNodes.put(newNode.label, newNode);
			}
			UndirectedGraphNode curNode = graphNodes.get(Integer.parseInt(nodeString[0]));
			nodes[counter]= curNode;
			for (int j=1; j<nodeString.length;j++){
				if (!graphNodes.containsKey(Integer.parseInt(nodeString[j]))) {
					UndirectedGraphNode subNode = new UndirectedGraphNode(Integer.parseInt(nodeString[j]));
					graphNodes.put(subNode.label, subNode);
				}
				curNode.neighbors.add(graphNodes.get(Integer.parseInt(nodeString[j])));
			}
			counter++;
		}
		
		size = counter;
	}
	
	public int size(){
		return size;
	}
	//{0,1,2#1,2#2,2}
	
	public String toString(){
		String output="{";
		for (UndirectedGraphNode curNode:nodes){
			output+=curNode.label;
			for (UndirectedGraphNode subNode:curNode.neighbors){
				output += ","+subNode.label;
			}
			output+="#";
		}
		output=output.substring(0, output.length()-1)+"}";
		return output;
	}
	

	public static void main(String[] args) {
//		String input = "0,1,5#1,2,5#2,3#3,4,4#4,5,5#5";
		String input = "0,1,2#1,2#2,2";
		UndirectedGraph test = new UndirectedGraph(input);
		System.out.println(test);
	}

}
