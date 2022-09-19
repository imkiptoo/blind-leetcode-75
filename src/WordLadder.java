import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, GraphNode> nodesGraph = new HashMap<>();
        nodesGraph.put(beginWord, new GraphNode(beginWord));

        List<String> totalWordList = new ArrayList<>();
        totalWordList.add(beginWord);

        for(String word : wordList) {
            if(word.equals(beginWord)) continue;
            nodesGraph.put(word, new GraphNode(word));
            totalWordList.add(word);
        }

        buildGraphEdges(totalWordList, nodesGraph);

        return bfsShortestPath(nodesGraph.get(beginWord), nodesGraph.get(endWord), nodesGraph.size());
    }

    private int bfsShortestPath(GraphNode start, GraphNode end, int count) {
        if(start == end) return 0;

        Queue<GraphNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(start);

        HashSet<GraphNode> visited = new HashSet<>();
        visited.add(start);

        int distance = 1;
        while(!bfsQueue.isEmpty()) {
            int layerSize = bfsQueue.size();

            for(int i = 0; i < layerSize; i++) {
                GraphNode node = bfsQueue.poll();

                if(node == end) return distance;
                for(GraphNode neighbor : node.neighbors) {
                    if(visited.contains(neighbor)) continue;
                    bfsQueue.offer(neighbor);
                    visited.add(neighbor);
                }
            }

            distance++;
        }

        return 0;
    }

    private void buildGraphEdges(List<String> wordList, HashMap<String, GraphNode> nodes) {
        for(int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            char[] charArr = word.toCharArray();
            GraphNode node = nodes.get(word);

            for(int k = 0; k < word.length(); k++) {
                char originalChar = charArr[k];
                for(char c = 'a'; c < 'z'; c++) {
                    charArr[k] = c;
                    String newString = new String(charArr);
                    GraphNode neighbor = nodes.get(newString);
                    if(neighbor != null) node.addNeighbor(neighbor);
                }
                charArr[k] = originalChar;
            }
        }
    }

    private class GraphNode {
        private String value;
        public List<GraphNode> neighbors = new ArrayList<>();
        public HashSet<GraphNode> neighborNodeSet = new HashSet<>();

        public GraphNode(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public void addNeighbor(GraphNode neighbor) {
            addNeighbor(neighbor, true);
        }

        private void addNeighbor(GraphNode neighbor, boolean undirected) {
            if(undirected) neighbor.addNeighbor(this, false);

            if(neighborNodeSet.contains(neighbor)) return;
            neighbors.add(neighbor);
            neighborNodeSet.add(neighbor);
        }
    }
}
