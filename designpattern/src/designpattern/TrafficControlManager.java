package designpattern;


public class TrafficControlManager {
    private static TrafficControlManager instance;

    private TrafficControlManager() { }

    public static TrafficControlManager getInstance() {
        if (instance == null) {
            instance = new TrafficControlManager();
        }
        return instance;
    }

    public void manageTraffic() {
    	System.out.println("Start:VIT");
    	System.out.println("Destination: New Bus_stand");
        System.out.println("Managing traffic flow...");
    }
}
