import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Customer5 {
    private final int id;
    private final long arrivalTime;

    public Customer5(int id) {
        this.id = id;
        this.arrivalTime = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}

class ServicePoint {
    private final Queue<Customer5> queue;

    public ServicePoint() {
        this.queue = new LinkedList<>();
    }

    // Add a customer to the queue
    public void addToQueue(Customer5 customer) {
        queue.add(customer);
    }

    // Remove a customer from the queue
    public Customer5 removeFromQueue() {
        return queue.poll();
    }

    // Serve customers in the queue
    public void serve() {
        Random random = new Random();
        while (!queue.isEmpty()) {
            Customer5 customer = removeFromQueue();
            if (customer != null) {
                long currentTime = System.currentTimeMillis();
                long waitingTime = currentTime - customer.getArrivalTime();

                // Simulate service time
                int serviceTime = random.nextInt(3000) + 1000; // 1-3 seconds
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

                System.out.println("Customer " + customer.getId() + ": Waiting time = " + waitingTime + " ms, Service time = " + serviceTime + " ms");
            }
        }

        System.out.println("All customers have been served.");
    }
}

// Class to create and add customers to the ServicePoint
class CustomerGenerator {
    public void generateCustomers(ServicePoint servicePoint, int numberOfCustomers) {
        for (int i = 1; i <= numberOfCustomers; i++) {
            Customer5 customer = new Customer5(i);
            servicePoint.addToQueue(customer);
            System.out.println("Customer " + customer.getId() + " added to the queue.");
        }
    }
}

public class ServicePoint5 {
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator();

        int numberOfCustomers = 10;

        // Generate customers
        generator.generateCustomers(servicePoint, numberOfCustomers);

        // Serve customers
        servicePoint.serve();
    }
}
