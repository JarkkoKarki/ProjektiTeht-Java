package Event;

public class Event implements Comparable<Event> {
    private String name;
    private int eventTime;
    private EventType eventType;  // Tapahtuma tyyppi

    public Event(String name, int eventTime, EventType eventType) {
        this.name = name;
        this.eventTime = eventTime;
        this.eventType = eventType;  // Liitetään tapahtuman tyyppi
    }

    public String getName() {
        return name;
    }

    public int getEventTime() {
        return eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.eventTime, other.eventTime);  // Järjestetään aikajärjestyksessä
    }

    @Override
    public String toString() {
        return "Event{name='" + name + "', eventTime=" + eventTime + ", eventType=" + eventType + "}"; // Tulostus
    }
}
