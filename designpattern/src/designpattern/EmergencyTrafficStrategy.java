package designpattern;



import java.util.List;


public class EmergencyTrafficStrategy implements TrafficManagementStrategy {
    private Graph graph;

    public EmergencyTrafficStrategy(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void manageTraffic() {
        System.out.println("Managing emergency traffic. Providing shortest path.");
        // Provide the shortest and most direct path for emergencies
        List<String> path = graph.findShortestPath("VIT", "Naruvi");
        System.out.println("Path: " + path);
    }
}
