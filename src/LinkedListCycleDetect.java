public class LinkedListCycleDetect {
	static class Node{
		int value;
		Node next;
		Node(int item){
			value = item;
			next = null;
		}
	}

	public static void main(String[] args){
		Node parent = new Node(1);
		Node child = new Node(2);

		parent.next = child;
		//child.next = parent;

		System.out.println(detectCycle(parent));
	}

	static boolean detectCycle(Node root){
		Node fast = root, slow = root;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast){
				return true;
			}
		}

		return false;
	}
}
