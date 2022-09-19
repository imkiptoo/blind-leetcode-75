import java.util.*;

public class GraphTraversal {
    public static void main(String[] args) {
        ArrayList<Character> output = new ArrayList<>();
        LinkedHashMap<Character, ArrayList<Character>> graph = new LinkedHashMap<>();

        graph.put('a', new ArrayList<>(Arrays.asList('c', 'b')));
        graph.put('b', new ArrayList<>(Arrays.asList('d')));
        graph.put('c', new ArrayList<>(Arrays.asList('e')));
        graph.put('d', new ArrayList<>(Arrays.asList('f')));
        graph.put('e', new ArrayList<>());
        graph.put('f', new ArrayList<>());

        traverseDFSIterative(graph, 'a', output);
        System.out.println("DFS Iterative: "+output.toString());

        output.clear();

        traverseBFSIterative(graph, 'a', output);
        System.out.println("BFS Iterative: "+output.toString());

        output.clear();

        Stack<Character> verticesStack = new Stack<>();
        verticesStack.push('a');

        traverseDFSRecursive(graph, verticesStack, output);
        System.out.println("DFS Recursive: "+output.toString());

        output.clear();

        Queue<Character> verticesQueue = new LinkedList<>();
        verticesQueue.offer('a');

        traverseBFSRecursive(graph, verticesQueue, output);
        System.out.println("BFS Recursive: "+output.toString());
    }

    static void traverseDFSIterative(LinkedHashMap<Character, ArrayList<Character>> graph, char first, ArrayList<Character> output){
        Stack<Character> vertices = new Stack<>();
        vertices.push(first);

        while(!vertices.isEmpty()){
            char current = vertices.pop();
            output.add(current);

            for(char c : graph.get(current)){
                vertices.push(c);
            }
        }
    }

    static void traverseDFSRecursive(LinkedHashMap<Character, ArrayList<Character>> graph, Stack<Character> vertices, ArrayList<Character> output){
        if(vertices.isEmpty()) return;

        char current = vertices.pop();
        output.add(current);

        for(char c : graph.get(current)){
            vertices.push(c);
        }

        traverseDFSRecursive(graph, vertices, output);
    }

    static void traverseBFSIterative(LinkedHashMap<Character, ArrayList<Character>> graph, char first, ArrayList<Character> output){
        Queue<Character> vertices = new LinkedList<>();
        vertices.offer(first);

        while(!vertices.isEmpty()){
            char current = vertices.poll();

            output.add(current);
            for(char c : graph.get(current)){
                vertices.offer(c);
            }
        }
    }


    static void traverseBFSRecursive(LinkedHashMap<Character, ArrayList<Character>> graph, Queue<Character> vertices, ArrayList<Character> output){
        if(vertices.isEmpty()) return;

        char current = vertices.poll();
        output.add(current);

        for(char c : graph.get(current)){
            vertices.offer(c);
        }

        traverseBFSRecursive(graph, vertices, output);
    }
}
