
package designpattern;

//Simulating external sensor system (or user input)
public class ExternalTrafficSensor {
 private String sensorData;

 public ExternalTrafficSensor(String sensorData) {
     this.sensorData = sensorData;
 }

 public String getSensorData() {
     return sensorData;
 }
}
