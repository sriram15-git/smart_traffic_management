
package designpattern;

public class TrafficSensorAdapter {
    private ExternalTrafficSensor externalTrafficSensor;

    public TrafficSensorAdapter(ExternalTrafficSensor externalTrafficSensor) {
        this.externalTrafficSensor = externalTrafficSensor;
    }

    // Convert external/user-provided sensor data to a format understood by our system
    public String getFormattedTrafficData() {
        String externalData = externalTrafficSensor.getSensorData();
        switch (externalData.toLowerCase()) {
            case "010":
            case "heavy-traffic":
                return "heavy";
            case "011":
            case "emergency-traffic":
                return "emergency";
            case "001":
            case "normal-traffic":
                return "normal";
            default:
                return "normal";  // Default case
        }
    }
}
