package designpattern;


public class TrafficControlSystem {
    private TrafficManagementStrategy strategy;

    public void setStrategy(TrafficManagementStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.manageTraffic();
    }
}
