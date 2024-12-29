package designpattern;



import java.util.Scanner;

public class SmartTrafficManagementSystem {
    public static void main(String[] args) {
        // Singleton instance of TrafficControlManager
        TrafficControlManager manager = TrafficControlManager.getInstance();
        manager.manageTraffic();

        // Build the traffic graph
        Graph graph = new Graph();
        // Adding nodes (intersections)
        graph.addNode("VIT");
        graph.addNode("Inox");
        graph.addNode("Odai Pillayar");
        graph.addNode("Vellore Kitchen");
        graph.addNode("Silkmill");
        graph.addNode("Naruvi");
        graph.addNode("Robin's");
        graph.addNode("Trends");
        graph.addNode("Auxiliam College Road");
        graph.addNode("Bus_stand");
        
        // Adding edges (roads) with distances
        graph.addEdge("VIT", "Inox", 5);
        graph.addEdge("Inox", "Odai Pillayar", 10);
        graph.addEdge("Inox", "Trends", 7);
        graph.addEdge("Odai Pillayar", "Silkmill", 3);
        graph.addEdge("Trends", "Robin's", 2);
        graph.addEdge("VIT", "Naruvi", 17);
        graph.addEdge("Naruvi", "Silkmill", 2);
        graph.addEdge("Robin's", "Bus_stand", 3);
        graph.addEdge("Inox", "Vellore Kitchen", 9);
        graph.addEdge("Inox", "Auxiliam College Road", 2);
        graph.addEdge("Silkmill", "Auxiliam College Road", 2);

        // Factory and strategy setup
        TrafficControlSystem controlSystem = new TrafficControlSystem();
        TrafficManagementFactory factory = new TrafficManagementFactory(graph);

        // Scanner for dynamic input from the user
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the current traffic condition (normal, heavy, emergency) or 'exit' to quit:");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the Smart Traffic Management System...");
                break;
            }

            // Use Adapter to adapt user input as if it's from an external system
            ExternalTrafficSensor externalSensor = new ExternalTrafficSensor(userInput);
            TrafficSensorAdapter sensorAdapter = new TrafficSensorAdapter(externalSensor);

            // Get the formatted traffic data from the adapter
            String trafficCondition = sensorAdapter.getFormattedTrafficData();

            // Set and execute the appropriate strategy based on user input
            TrafficManagementStrategy strategy = factory.getStrategy(trafficCondition);
            controlSystem.setStrategy(strategy);

            // Execute traffic management based on the strategy
            controlSystem.executeStrategy();

            System.out.println();  // Print a new line for clarity
        }

        scanner.close();
    }
}
