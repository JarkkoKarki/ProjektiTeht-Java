package Service;

import java.util.*;

public class EventList {
    private PriorityQueue<Event> events;

    public EventList() {
        // Järvestetään tapahtumat
        events = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return Double.compare(e1.getEventTime(), e2.getEventTime());
            }
        });
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    // Poistetaan tuleva tapahtuma
    public Event removeNextEvent() {
        return events.poll();
    }

    // Tarkistetaan onko lista tyhtä
    public boolean isEmpty() {
        return events.isEmpty();
    }
}
