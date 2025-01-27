package Service;

public class Event {
    private double eventTime;    // Aika tapahtumille
    private EventType eventType; // Tapahtuman tyyppi
    private Customer customer;   // asiakas

    // construktori
    public Event(double eventTime, EventType eventType, Customer customer) {
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.customer = customer;
    }

    public double getEventTime() {
        return eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Customer getCustomer() {
        return customer;
    }
}
