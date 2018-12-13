package hr.fer.oop.lab1.prob6;

public class BinaryTree {
	TreeNode root;

	public BinaryTree(){
		root = null;
	}

	public void insert(String data) {
		if (this.root == null)
			this.root = new TreeNode(data);
		else {
			TreeNode node = this.root;
			TreeNode parent = null;
			while (node!= null) {
				parent = node;
				if (node.data.compareTo(data) > 0)
					node = node.left;
				else 
					node = node.right;
			}
			if (parent.data.compareTo(data) > 0)
				parent.left = new TreeNode(data);
			else 
				parent.right = new TreeNode(data);
		}
		return;
	}

	private boolean subTreeContainsData(TreeNode node, String data) {
		if (node.data == data)
			return true;
		if (node.left != null && subTreeContainsData(node.left, data))
			return true;
		if (node.right != null && subTreeContainsData(node.right, data))
			return true;
		return false;
	}

	public boolean containsData(String data) {
		return subTreeContainsData(root, data);
	}	

	private int sizeOfSubTree(TreeNode node) {
		if (node == null)
			return 0;
		else return sizeOfSubTree(node.left) + 1 + sizeOfSubTree(node.right);
	}

	public int sizeOfTree() {
		return sizeOfSubTree(root);
	}

	private void writeSubTree(TreeNode node) {
		if (node != null) {
			writeSubTree(node.left);
			System.out.print(node.data + " ");
			writeSubTree(node.right);
		}
	}

	public void writeTree() {
		writeSubTree(this.root);
		System.out.println();
	}

	private void reverseSubTreeOrder(TreeNode node) {
		TreeNode temp = node.right;
		node.right = node.left;
		node.left = temp;

		if (node.left != null) {
			reverseSubTreeOrder(node.left);
		}

		if (node.right != null) {
			reverseSubTreeOrder(node.right);
		}		
	}	

	public void reverseTreeOrder() {
		reverseSubTreeOrder(root);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert("Jasna");
		tree.insert("Ana");
		tree.insert("Ivana");
		tree.insert("Anamarija");
		tree.insert("Vesna");
		tree.insert("Kristina");

		System.out.println("Writing tree inorder:");
		tree.writeTree();

		tree.reverseTreeOrder();
		System.out.println("Writing reversed tree inorder:");
		tree.writeTree();

		int size = tree.sizeOfTree();
		System.out.println("Number of nodes in tree is "+size+".");

		boolean found = tree.containsData("Ivana");
		System.out.println("Searched element is found: "+found);

		found = tree.containsData("Jelena");
		System.out.println("Searched element is found: "+found);		
	}
}
