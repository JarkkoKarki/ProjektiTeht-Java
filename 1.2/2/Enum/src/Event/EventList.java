package Event;

import java.util.*;

public class EventList {
    private PriorityQueue<Event> events;

    public EventList() {
        events = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        events.add(event);  // Lisää tapahtuma jonon
    }

    public Event removeNextEvent() {
        return events.poll();  // Poistaa ja palauttaa seuraavan tapahtuman
    }

    public void printEvents() {
        // Kopioi priorityquen
        PriorityQueue<Event> copy = new PriorityQueue<>(events);
        while (!copy.isEmpty()) {
            System.out.println(copy.poll());  // Tulostetaan kaikki tapahtumat aikajärjestyksessä
        }
    }
}
