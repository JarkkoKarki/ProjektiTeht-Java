
package Event;

public class Event {
    private String name; // Tapahtuma
    private int eventTime; // Tapahtuman aika

    public Event(String name, int eventTime) {
        this.name = name;
        this.eventTime = eventTime;
    }

    public String getName() {
        return name;
    }

    public int getEventTime() {
        return eventTime;
    }

    public String getEventDetails() {
        return "Event{name='" + name + "', eventTime=" + eventTime + "}";
    }
}
