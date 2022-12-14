import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscapePods {
    public static int solution(int[] entrances, int[] exits, int[][] path) {
        int n = path.length;
        DinicAlgorithm networkFlow = new DinicAlgorithm(n + 2);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (path[i][j] > 0) networkFlow.addEdge(i, j, path[i][j]);

        for (int i = 0; i < entrances.length; i++)
            networkFlow.addEdge(n, entrances[i], Integer.MAX_VALUE);

        for (int i = 0; i < exits.length; i++)
            networkFlow.addEdge(exits[i], n + 1, Integer.MAX_VALUE);

        return networkFlow.findMaxFlow(n, n + 1);
    }

    static class DinicAlgorithm {
        static class Edge {
            int t, rev, cap, flow;

            public Edge(int t, int rev, int cap) {
                this.t = t;
                this.rev = rev;
                this.cap = cap;
            }
        }

        int nodes;
        List<Edge>[] graph;

        public DinicAlgorithm(int nodes) {
            this.nodes = nodes;
            graph = new List[nodes];
            for (int i = 0; i < nodes; i++)
                graph[i] = new ArrayList<Edge>();
        }

        public void addEdge(int u, int v, int weight) {
            graph[u].add(new Edge(v, graph[v].size(), weight));
            graph[v].add(new Edge(u, graph[u].size() - 1, 0));
        }

        boolean dinicBfs(int s, int t, int[] dist) {
            Arrays.fill(dist, -1);
            dist[s] = 0;
            int[] queue = new int[nodes];
            int size = 0;
            queue[size++] = s;

            for (int i = 0; i < size; i++) {
                int u = queue[i];

                for (Edge e : graph[u]) {
                    if (dist[e.t] < 0 && e.flow < e.cap) {
                        dist[e.t] = dist[u] + 1;
                        queue[size++] = e.t;
                    }
                }
            }

            return dist[t] >= 0;
        }


        int dinicDfs(int[] ptr, int[] dist, int v, int u, int flow) {
            if (u == v) return flow;

            int increment;
            Edge e;
            for (; ptr[u] < graph[u].size(); ptr[u]++) {
                e = graph[u].get(ptr[u]);

                if (dist[e.t] == dist[u] + 1 && e.flow < e.cap) {
                    increment = dinicDfs(ptr, dist, v, e.t, Math.min(flow, e.cap - e.flow));

                    if (increment <= 0) continue;
                    e.flow += increment;
                    graph[e.t].get(e.rev).flow -= increment;
                    return increment;
                }
            }
            return 0;
        }

        public int findMaxFlow(int s, int t) {
            int maxflow = 0;
            int[] dist = new int[nodes];

            int[] ptr;
            int increment;
            while (dinicBfs(s, t, dist)) {
                ptr = new int[nodes];
                do {
                    increment = dinicDfs(ptr, dist, t, s, Integer.MAX_VALUE);
                    maxflow += increment;
                }
                while (increment > 0);
            }
            return maxflow;
        }
    }
}