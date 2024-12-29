package designpattern;

import java.util.*;

class DijkstraAlgorithm {
    public Map<String, Integer> shortestPath(Graph graph, String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        Set<String> visited = new HashSet<>();

        distances.put(startNode, 0);
        priorityQueue.add(new Edge(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            String currentNode = currentEdge.getDestination();

            if (!visited.add(currentNode)) continue; // skip if already visited

            for (Edge edge : graph.getEdges(currentNode)) {
                String neighbor = edge.getDestination();
                int newDist = distances.get(currentNode) + edge.getWeight();

                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    priorityQueue.add(new Edge(neighbor, newDist));
                }
            }
        }
        return distances;
    }
}
