package Event;

public class Main {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Luo tapahtumia ja lisää ne listalle
        eventList.addEvent(new Event("Event A", 10, EventType.ARRIVAL));
        eventList.addEvent(new Event("Event B", 5, EventType.EXIT));
        eventList.addEvent(new Event("Event C", 15, EventType.ARRIVAL));
        eventList.addEvent(new Event("Event D", 3, EventType.EXIT));

        // Poistetaan ensimmäinen (seuraava käsiteltävä) tapahtuma
        Event nextEvent = eventList.removeNextEvent();
        System.out.println("Processing event: " + nextEvent);

        // Tulostetaan jäljelle jäävät tapahtumat aikajärjestyksessä
        System.out.println("\nRemaining events in chronological order:");
        eventList.printEvents();
    }
}
