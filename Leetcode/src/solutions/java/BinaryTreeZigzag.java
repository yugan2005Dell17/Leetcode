package solutions.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzag {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		/*
		 * Done on white board, only one grammar bug. List<List<Integer>> result = new ArrayList<ArrayList<Integer>>(); IS WRONG!
		 */
		
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // bug here ArrayList<ArrayList<Integer>> cannot be converted to List<List<Integer>>
        
        if (root==null) return result;
        Stack<TreeNode> curLevel = new Stack<TreeNode>();
        curLevel.push(root);
        int numOfLevel = 1;
        bfsZigzag(curLevel, result, numOfLevel);
        
        return result;
    }
    
    private void bfsZigzag(Stack<TreeNode> curLevel, List<List<Integer>> result, int numOfLevel){
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        ArrayList<Integer> curResult = new ArrayList<Integer>();
        while (!curLevel.empty()){
            TreeNode node = curLevel.pop();
            if (numOfLevel%2==0){
                if (node.right!=null) nextLevel.push(node.right);
                if (node.left!=null) nextLevel.push(node.left);
            }
            else {
                if (node.left!=null) nextLevel.push(node.left);
                if (node.right!=null) nextLevel.push(node.right);
            }
            curResult.add(node.val);
        }
        result.add(curResult);
        if (!nextLevel.empty()) bfsZigzag(nextLevel, result, numOfLevel+1);
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
