//1,2,3,4,5,6,7
/*
   4
 2   6
1 3 5 7
*/


class ValidateBST{
	static class Node{
		int value;
		Node left;
		Node right;

		public Node(int item){
			value = item;
			left = right = null;
		}
	}

	public static boolean isBST(Node n){
		return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST(Node n, int min, int max){
		if(n == null) return true;
		if(n.value < min || n.value > max) return false;
		return isBST(n.left, min, n.value) && isBST(n.right, n.value + 1, max);
	}

	public static void main(String[] args){
		Node n = new Node(4);
		n.left = new Node(2);
		n.left.left = new Node(1);
		n.left.right = new Node(3);
		n.right = new Node(6);
		n.right.left = new Node(5);
		n.right.right = new Node(7);

		boolean valid = isBST(n);
		System.out.println(valid);
	}
}
