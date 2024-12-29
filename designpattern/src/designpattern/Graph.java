package designpattern;



import java.util.*;

public class Graph {
    private final Map<String, Map<String, Integer>> nodes = new HashMap<>();

    public void addNode(String node) {
        nodes.putIfAbsent(node, new HashMap<>());
    }

    public void addEdge(String source, String destination, int distance) {
        nodes.get(source).put(destination, distance);
        nodes.get(destination).put(source, distance); // Assuming bidirectional roads
    }

    // Method to find the shortest path using Dijkstra's algorithm
    public List<String> findShortestPath(String start, String end) {
        return dijkstra(start, end);
    }

    // Method to find a medium-efficiency path (not necessarily the shortest)
    public List<String> findPath(String start, String end) {
        // This can use any logic or heuristic to return a medium-efficiency path.
        return dijkstra(start, end);  // Currently uses Dijkstra, can be customized.
    }

    private List<String> dijkstra(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String node : nodes.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            if (currentNode.equals(end)) break;

            for (Map.Entry<String, Integer> neighbor : nodes.get(currentNode).entrySet()) {
                String neighborNode = neighbor.getKey();
                int newDist = distances.get(currentNode) + neighbor.getValue();

                if (newDist < distances.get(neighborNode)) {
                    distances.put(neighborNode, newDist);
                    previousNodes.put(neighborNode, currentNode);
                    queue.add(neighborNode);
                }
            }
        }

        // Reconstruct the path
        List<String> path = new LinkedList<>();
        String currentNode = end;
        while (currentNode != null) {
            path.add(0, currentNode);
            currentNode = previousNodes.get(currentNode);
        }
        return path;
    }
}
