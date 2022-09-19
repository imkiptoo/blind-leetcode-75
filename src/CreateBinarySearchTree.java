public class CreateBinarySearchTree {
	static class Node{
		int value;
		Node left;
		Node right;

		Node(int v){
			value = v;
			left = right = null;
		}
	}

	static Node root;

	static Node buildBST(int[] A, int start, int end){
		if(start > end) return null;

		int mid = (start + end) / 2;
		Node node = new Node(A[mid]);

		node.left = buildBST(A, start, mid - 1);

		node.right = buildBST(A, mid + 1, end);

		return node;
	}

	static void preOrder(Node node){
		if(node == null){
			return;
		}

		System.out.println(node.value);

		preOrder(node.left);
		preOrder(node.right);
	}

	static void inOrder(Node node){
		if(node == null){
			return;
		}

		preOrder(node.left);
		System.out.println(node.value);
		preOrder(node.right);
	}

	static void postOrder(Node node){
		if(node == null){
			return;
		}

		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.value);
	}

	public static void main(String[] args){
		int[] A = {10, 11, 17, 19, 30, 31, 37, 38};

		root = buildBST(A, 0, A.length - 1);

		System.out.println("PreOrder: ");
		preOrder(root);
		System.out.println("InOrder: ");
		inOrder(root);
		System.out.println("PostOrder: ");
		postOrder(root);
	}
}
