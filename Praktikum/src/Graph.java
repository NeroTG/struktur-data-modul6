import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public void addNode(int node) {
        map.put(node, new LinkedList<Integer>());
    }

    public void addEdge(int source, int destination) {
        if (!map.containsKey(source))
            addNode(source);

        if (!map.containsKey(destination))
            addNode(destination);

        map.get(source).add(destination);
    }

    public void DFS(int node) {
        Set<Integer> visited = new HashSet<>();
        DFSUtil(node, visited);
    }

    private void DFSUtil(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int n : map.get(node)) {
            if (!visited.contains(n)) {
                DFSUtil(n, visited);
            }
        }
    }

    public void BFS(int node) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");

            for (int neighbor : map.get(n)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
        graph.addEdge(2, 5);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(9, 5);
        graph.addEdge(9, 8);
        graph.addEdge(8, 9);
        graph.addEdge(8, 11);
        graph.addEdge(11, 10);
        graph.addEdge(11, 7);
        graph.addEdge(7, 11);

        System.out.println("DFS vertex 1:");
        graph.DFS(1);

        System.out.println("\nBFS  vertex 1:");
        graph.BFS(1);
    }
}


