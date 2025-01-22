import java.util.PriorityQueue;

/*
(W) Continue with the three-phase simulation example (section Telephone call centre example: hand simulation)
until one client of client type Y exits the system.
Return your solution as an attachment to the solution of this exercise.


 */

// Tapahtumat
class Event implements Comparable<Event> {
    private double eventTime;
    private EventType eventType;
    private String clientType;

    public Event(double eventTime, EventType eventType, String clientType) {
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.clientType = clientType;
    }

    public double getEventTime() {
        return eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getClientType() {
        return clientType;
    }

    @Override
    public int compareTo(Event otherEvent) {
        return Double.compare(this.eventTime, otherEvent.getEventTime());
        //Järjestys
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventTime=" + eventTime +
                ", eventType=" + eventType +
                ", clientType=" + clientType +
                '}';
    }
}

// Priorityque tapahtumille
class EventList {
    private PriorityQueue<Event> events;

    public EventList() {
        this.events = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event removeNextEvent() {
        return events.poll();
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public void printEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}

// Simulaatio
public class CallCenterSimulation {
    private static int workCompleteX = 0;
    private static int workCompleteY = 0;

    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Pää tapahtumat (asiakkaat)
        eventList.addEvent(new Event(5, EventType.ARRIVAL, "X"));
        eventList.addEvent(new Event(10, EventType.ARRIVAL, "Y"));

        // Aloitetaan simulaatio
        runSimulation(eventList);
    }

    public static void runSimulation(EventList eventList) {
        // Alustetaan jonot ja operaattorit
        String routerQueue = "";
        String operator1Queue = "";
        String operator2Queue = "";

        // Alustetaan kello
        double clock = 0;

        while (!eventList.isEmpty()) {
            // Jatkuu kunnes kummatkin pääsee pois
            while (workCompleteX <= 1 && workCompleteY <= 1) {
                // Siirrytään seuraavaan tapahtumaan
                Event nextEvent = eventList.removeNextEvent();
                clock = nextEvent.getEventTime();

                // Tulostetaan tiedot
                System.out.println("Time: " + clock);
                System.out.println("Processing event: " + nextEvent);
                System.out.println("Router Queue: " + routerQueue);
                System.out.println("Operator 1 Queue: " + operator1Queue);
                System.out.println("Operator 2 Queue: " + operator2Queue);
                System.out.println("Work Complete (X): " + workCompleteX);
                System.out.println("Work Complete (Y): " + workCompleteY);
                System.out.println("---------------");

                // Siirrytään tapahtumiin (ARRIVAL tai EXIT)
                if (nextEvent.getEventType() == EventType.ARRIVAL) {
                    // Lisätään jonoon
                    routerQueue += nextEvent.getClientType() + " ";

                    // Lisätään seuraava saapuminen X:n tai Y:n mukaan
                    if (nextEvent.getClientType().equals("X")) {
                        eventList.addEvent(new Event(clock + 5, EventType.ARRIVAL, "X"));
                    } else if (nextEvent.getClientType().equals("Y")) {
                        eventList.addEvent(new Event(clock + 10, EventType.ARRIVAL, "Y"));
                    }

                } else if (nextEvent.getEventType() == EventType.EXIT) {
                    // Jos on valmis merkitään ylös
                    if (nextEvent.getClientType().equals("X")) {
                        workCompleteX++;
                    } else if (nextEvent.getClientType().equals("Y")) {
                        workCompleteY++;
                    }
                }

                // Simuloidaan puhelut
                if (!routerQueue.isEmpty()) {
                    // Siirretään jonosta operaattoreille
                    String currentCall = routerQueue.split(" ")[0];
                    // Valitaan vapaa operaattori
                    if (operator1Queue.isEmpty()) {
                        operator1Queue += currentCall + " ";
                    } else if (operator2Queue.isEmpty()) {
                        operator2Queue += currentCall + " ";
                    }
                    routerQueue = routerQueue.replace(currentCall + " ", "");
                }

                // Operaattorit
                if (!operator1Queue.isEmpty()) {
                    String operator1Call = operator1Queue.split(" ")[0]; // poistetaan jonosta
                    operator1Queue = operator1Queue.replace(operator1Call + " ", "");
                    eventList.addEvent(new Event(clock + 4, EventType.EXIT, operator1Call)); // Valmis 4 minuutin jälkeen
                }

                if (!operator2Queue.isEmpty()) {
                    String operator2Call = operator2Queue.split(" ")[0];
                    operator2Queue = operator2Queue.replace(operator2Call + " ", "");
                    eventList.addEvent(new Event(clock + 4, EventType.EXIT, operator2Call)); // Valmis 4 minuutin jälkeen
                }
            }
        }
        // Tulostetaan tiedot
        System.out.println("Simulation complete!");
        System.out.println("Final Work Complete (X): " + workCompleteX);
        System.out.println("Final Work Complete (Y): " + workCompleteY);
    }
}
