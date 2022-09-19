import java.util.*;

public class BFSGraph{
	int V;
	LinkedList<Integer> adjLists[];

	BFSGraph(int size){
		V = size;
		adjLists = new LinkedList[size];
		for(int i = 0; i < size; i++){
			adjLists[i] = new LinkedList();
		}
	}

	void addItem(int source, int destination){
		adjLists[source].add(destination);
	}

	void BFS(int vertex){
		boolean[] visited = new boolean[V];

		LinkedList<Integer> queue = new LinkedList();

		visited[vertex] = true;

		queue.add(vertex);

		while(queue.size() != 0){
			vertex = queue.poll();
			System.out.print(vertex+" ");

			Iterator<Integer> ite = adjLists[vertex].listIterator();

			while(ite.hasNext()){
				int adj = ite.next();
				if(!visited[adj]){
					visited[adj] = true;
					queue.add(adj);
				}
			}
		}
	}

	public static void main(String[] args){
		BFSGraph g = new BFSGraph(5);

		g.addItem(0, 1);
		g.addItem(0, 2);
		g.addItem(0, 3);
		g.addItem(0, 4);
		g.addItem(2, 4);

		g.BFS(0);
	}
}
