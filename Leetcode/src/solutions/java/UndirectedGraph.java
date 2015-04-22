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
	
	public UndirectedGraph(UndirectedGraphNode root){
		/*
		 * This constructor is not totally finished
		 * 1: the nodes array only holds 10 elements, should use variable length array setting
		 * 2: If the root is not the real root, the Graph will miss nodes!
		 * 3: But it is good for my debug usage for now.
		 */
		int counter = 0;
		graphNodes.put(root.label, root);
		nodes = new UndirectedGraphNode[10];
		nodes[0]=root;
		counter++;
		for (UndirectedGraphNode subNode:root.neighbors){
			counter = dfsAddNode(subNode, counter);
		}
		size = counter;		
	}
	
	private int dfsAddNode(UndirectedGraphNode curNode, int counter){
		if (!graphNodes.containsKey(curNode.label)){
			graphNodes.put(curNode.label, curNode);
			nodes[counter]=curNode;
			counter++;
			for (UndirectedGraphNode subNode:curNode.neighbors){
				counter = dfsAddNode(subNode, counter);
			}
		}
		return counter;
	}

	
	public int size(){
		return size;
	}
	
	public String toString(){
		String output="{";
		for (UndirectedGraphNode curNode:nodes){
			if (curNode!=null){
				output+=curNode.label;
				for (UndirectedGraphNode subNode:curNode.neighbors){
					output += ","+subNode.label;
				}
				output+="#";
			}

		}
		output=output.substring(0, output.length()-1)+"}";
		return output;
	}
	

	public static void main(String[] args) {
		String input = "0,1,5#1,2,5#2,3#3,4,4#4,5,5#5";
//		String input = "0,1,2#1,2#2,2";
		UndirectedGraph test = new UndirectedGraph(input);
		System.out.println(test);
		
		UndirectedGraph test2 = new UndirectedGraph(test.nodes[1]);
		System.out.println(test2);
	}

}
