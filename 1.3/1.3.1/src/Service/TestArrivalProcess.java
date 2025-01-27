package Service;

public class TestArrivalProcess {
    public static void main(String[] args) {
        // Luodaan objektit
        Clock clock = Clock.getInstance();
        ArrivalProcess arrivalProcess = new ArrivalProcess(5.0);  // mean = 5.0
        EventList eventList = new EventList();
        ServicePoint servicePoint = new ServicePoint();

        // 10 tapahtumaa
        for (int i = 0; i < 10; i++) {
            double arrivalTime = arrivalProcess.sample();
            Customer customer = new Customer(arrivalTime);
            Event arrivalEvent = new Event(arrivalTime, EventType.ARRIVAL, customer);
            eventList.addEvent(arrivalEvent);
        }

        // Käynnistetään tapahtumat eventlistissä
        while (!eventList.isEmpty()) {  // käytetään isEmpty() varmistamaan, että se on tyhjä
            Event event = eventList.removeNextEvent();  // siirrytään seuraavaan tapahtumaan
            clock.advanceTime(event.getEventTime() - clock.getTime());  // Siirretään kelloa eteenpäin

            if (event.getEventType() == EventType.ARRIVAL) {
                Customer customer = event.getCustomer();
                servicePoint.addCustomer(customer);  // lisätään asiakas jonoon
                customer.setServiceStartTime(clock.getTime());  // Merkitään kun palvelu alkaa
            }
        }

        // Kaikkien tapahtumien jälkeen siirretään kelloa eteenpäin
        clock.advanceTime(5.0);

        // Lasketaan aika palvelussa
        while (!servicePoint.isEmpty()) {
            Customer customer = servicePoint.serveCustomer();
            customer.calculateTimeInSystem(clock.getTime());  // Lasketaan aika
            System.out.println("Customer arrived at: " + customer.getArrivalTime() +
                    ", Time in system: " + customer.getTimeInSystem());
        }
    }
}
