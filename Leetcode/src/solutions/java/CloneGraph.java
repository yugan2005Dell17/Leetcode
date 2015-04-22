package solutions.java;

import java.util.HashMap;

public class CloneGraph {
	
    /*
    *Note: although this problem claims to be undirected, according to the OJ and the example
    *it actually is like a directed graph because only one side of connection is presented in the graph
    */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        UndirectedGraphNode cloneHead = new UndirectedGraphNode(node.label);
        //ArrayList<Boolean> visited = new ArrayList<Boolean>(); // A big bug, int can be negative!
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();        
        dfsClone(node, cloneHead, visited);
        
        return cloneHead;
    }
    
    private void dfsClone(UndirectedGraphNode oriNode, UndirectedGraphNode cloneNode, HashMap<Integer, UndirectedGraphNode> visited){
        if (!visited.containsKey(cloneNode.label)){
    		visited.put(cloneNode.label,cloneNode);
    		for(UndirectedGraphNode next:oriNode.neighbors){
    			UndirectedGraphNode cloneNext;
    			if (!visited.containsKey(next.label)){
    				cloneNext = new UndirectedGraphNode(next.label);
    			}
    			else {
    				cloneNext=visited.get(next.label);
    			}
    			cloneNode.neighbors.add(cloneNext);
                dfsClone(next, cloneNext, visited);
    		}

        }
    }

	public static void main(String[] args) {
//		String serilizedGraph = "0,1,5#1,2,5#2,3#3,4,4#4,5,5#5";
//		String serilizedGraph = "0,1,5#1,2,5#2,3#3,4#4,4,5#5,5";
		String serilizedGraph = "0,0,0";


		UndirectedGraph testGraph = new UndirectedGraph(serilizedGraph);

		CloneGraph test = new CloneGraph();
		UndirectedGraphNode cloneRoot = test.cloneGraph(testGraph.nodes[0]);
		UndirectedGraph cloneGraph = new UndirectedGraph(cloneRoot);
		System.out.println("{"+serilizedGraph+"}");
		System.out.println(cloneGraph);


	}

}
