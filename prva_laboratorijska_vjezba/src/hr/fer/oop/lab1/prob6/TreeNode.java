package hr.fer.oop.lab1.prob6;

public class TreeNode {
	TreeNode left;
	TreeNode right;
	String data;

	public TreeNode(String data) {
		this.data = data;
	}    
	public TreeNode(TreeNode left, TreeNode right, String data) {
		this.data = data;
		this.left = left;
		this.right = right;
		
	}  
}
