import java.util.*;

public class MeanPerTreeLevel {
	public static class Node{
		int value;
		Node left, right;

		Node(int v){
			value = v;
			left = right = null;
		}
	}

	public static void main(String[] args){
		Node root = new Node(2);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.right.right = new Node(9);

		ArrayList<Integer> means = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		while(!queue.isEmpty()){
			final int queueSize = queue.size();
			int total = 0;

			for(int i = 0; i < queueSize; i++){
				Node current = queue.poll();
				if(current.left != null){
					queue.add(current.left);
				}
				if(current.right != null){
					queue.add(current.right);
				}
				total += current.value;
			}

			means.add(total / queueSize);
		}

		System.out.println(means);
	}
}
