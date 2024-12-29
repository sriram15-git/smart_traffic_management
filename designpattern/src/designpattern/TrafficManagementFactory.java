
package designpattern;




public class TrafficManagementFactory {
    private Graph graph;

    public TrafficManagementFactory(Graph graph) {
        this.graph = graph;
    }

    public TrafficManagementStrategy getStrategy(String trafficCondition) {
        switch (trafficCondition.toLowerCase()) {
            case "heavy":
            	System.out.println("heavy");
                return new HeavyTrafficStrategy(graph);
            case "emergency":
                return new EmergencyTrafficStrategy(graph);
            default:
            	System.out.println("normal");
                return new NormalTrafficStrategy(graph);  // Default is normal traffic
        }
    }
}

