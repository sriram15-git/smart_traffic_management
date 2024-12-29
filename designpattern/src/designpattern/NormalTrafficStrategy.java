package designpattern;



import java.util.List;
public class NormalTrafficStrategy implements TrafficManagementStrategy {
    private Graph graph;

    public NormalTrafficStrategy(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void manageTraffic() {
        System.out.println("Managing normal traffic. Providing medium-efficiency path.");
        // Providing a regular medium-efficiency path (not the shortest, not alternative)
        List<String> path = graph.findPath("VIT", "Bus_stand");
        System.out.println("Path: " + path);
    }
}
