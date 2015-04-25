package solutions.java;

public class MaximumDepthOfBinaryTree {
	
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int maxDepth = dfsDepth(root, 1, 1);
        return maxDepth;
    }
    
    private int dfsDepth(TreeNode curNode, int depth, int maxDepth){
        if (depth>maxDepth) maxDepth = depth;
        if (curNode.left!=null) {
            maxDepth = dfsDepth(curNode.left, depth+1, maxDepth);
        }
        if (curNode.right!=null){
            maxDepth = dfsDepth(curNode.right, depth+1, maxDepth);
        }
        return maxDepth;
    }

	public static void main(String[] args) {
		
		MaximumDepthOfBinaryTree test = new MaximumDepthOfBinaryTree();
		String input = "{3,9,20,#,#,15,7}";
		BinaryTree testTree = new BinaryTree(input);
		System.out.println(test.maxDepth(testTree.root()));
		

	}

}
