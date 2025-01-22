// EventList.java
package Event;

import java.util.*;

public class EventList {
    private PriorityQueue<Event> events;


    public EventList() {
        events = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                //Lajitellaan tapahtuma ajan mukaan
                return Integer.compare(e1.getEventTime(), e2.getEventTime());
            }
        });
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event removeNextEvent() {
        return events.poll();
    }

    public void printEvents() {
        PriorityQueue<Event> copy = new PriorityQueue<>(events);
        while (!copy.isEmpty()) {
            System.out.println(copy.poll().getEventDetails());
        }
    }
}
