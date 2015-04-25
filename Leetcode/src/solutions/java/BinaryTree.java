package solutions.java;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private TreeNode root;
	private int size=0;
	private int depth=0;
	
	public BinaryTree(String s){
		s=s.substring(1, s.length()-1); // strip {}
		String[] nodeStrs = s.split(",");
		depth = 0;
		for (int i=1; i<(nodeStrs.length+1); i<<=1, depth++);
		root = new TreeNode(Integer.parseInt(nodeStrs[0]));
		size++;
		int counter=1;
		TreeNode[] preLevel = new TreeNode[1<<0];
		preLevel[0]=root;

		for (int curDepth=1; curDepth<depth;curDepth++){
			TreeNode[] curLevel = new TreeNode[1<<curDepth];
			for (int i=0; i<curLevel.length; i++){
				if (!nodeStrs[counter].equals("#")){
					curLevel[i]= new TreeNode(Integer.parseInt(nodeStrs[counter]));
					if (i%2==0) preLevel[i/2].left=curLevel[i];
					else preLevel[i/2].right=curLevel[i];
					size++;
				}
				counter++;
			}
			preLevel = curLevel;				
		}		
	}
	
	public int depth(){
		return depth;
	}
	
	public int size(){
		return size;
	}
	
	public TreeNode root(){
		return root;
	}
	
	public String toString(){
		String output="{";
		Queue<TreeNode> treeNodes = new LinkedList<>(); // cannot use ArrayDeque, because I need add null
		treeNodes.add(root);
		int counter=1;
		
		while (treeNodes.size()!=0) {
			TreeNode curNode = treeNodes.remove();
			if(curNode!=null) {
				treeNodes.add(curNode.left);
				treeNodes.add(curNode.right);
				output+=curNode.val+",";
			}
			else output+="#,";
			counter++;
			if (counter==1<<depth) break;
		}
		output = output.substring(0, output.length()-1)+"}";
		return output;		
	}
	

	public static void main(String[] args) {
		String input = "{3,9,20,#,#,15,7}";
		BinaryTree test = new BinaryTree(input);
		System.out.println(input);
		System.out.println(test);
		System.out.println("size is "+test.size());
		System.out.println("depth is "+test.depth());	
	}

}
