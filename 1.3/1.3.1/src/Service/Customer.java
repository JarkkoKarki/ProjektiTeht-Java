package Service;

public class Customer {
    private double arrivalTime;
    private double serviceStartTime;
    private double timeInSystem;
    private double departureTime;

    public Customer(double arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.serviceStartTime = -1;  // Aloitus aika
        this.timeInSystem = -1;  // Aika järjestelmässä
    }

    public void setServiceStartTime(double serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public void calculateTimeInSystem(double departureTime) {
        this.timeInSystem = departureTime - arrivalTime;
    }

    public double getTimeInSystem() {
        return timeInSystem;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }
}
