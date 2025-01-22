package Event;
import Event.EventList;

public class Main {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Tehdään tapahtumat tapahtumalistaan
        eventList.addEvent(new Event("A", 10));
        eventList.addEvent(new Event("B", 5));
        eventList.addEvent(new Event("C", 15));
        eventList.addEvent(new Event("D", 14));

        // Poistetaan pienimmän ajan mukaan tapahtumia
        Event nextEvent = eventList.removeNextEvent();
        System.out.println("Processing event: " + nextEvent.getEventDetails());

        System.out.println("\nRemaining events in chronological order:");
        eventList.printEvents();
    }
}
