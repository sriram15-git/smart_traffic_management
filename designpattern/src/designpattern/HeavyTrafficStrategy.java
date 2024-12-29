package designpattern;



import java.util.List;

public class HeavyTrafficStrategy implements TrafficManagementStrategy {
    private Graph graph;

    public HeavyTrafficStrategy(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void manageTraffic() {
        System.out.println("Managing heavy traffic. Providing alternative paths.");
        // For heavy traffic, we provide alternative paths to avoid congestion
        List<String> path1 = graph.findPath("VIT", "Odai Pillayar");  // First alternative path
        List<String> path2 = graph.findPath("VIT", "Vellore Kitchen");  // Second alternative path
        System.out.println("Alternative Path 1: " + path1);
        System.out.println("Alternative Path 2: " + path2);
    }
}
