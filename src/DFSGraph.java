import java.util.*;

public class DFSGraph {
	List<Integer> adjLists[];
	boolean visited[];

	DFSGraph(int size){
		adjLists = new LinkedList[size];
		visited = new boolean[size];

		for(int i = 0; i < size; i++){
			adjLists[i] = new LinkedList<Integer>();
		}
	}

	void addNode(int source, int destination){
		adjLists[source].add(destination);
	}

	void DFS(int vertex){
		visited[vertex] = true;
		System.out.print(vertex+" ");

		Iterator<Integer> ite = adjLists[vertex].listIterator();
		while(ite.hasNext()){
			int adj = ite.next();
			if(!visited[adj]){
				DFS(adj);
			}
		}
	}

	public static void main(String[] args){
		DFSGraph g = new DFSGraph(5);

		g.addNode(0, 1);
		g.addNode(0, 2);
		g.addNode(0, 3);
		g.addNode(0, 4);
		g.addNode(2, 4);

		g.DFS(0);
	}
}
