import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Customer6 {
    private final int id;
    private final long arrivalTime;

    public Customer6(int id) {
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

class ServicePoint2 {
    private final Queue<Customer6> queue;
    private long totalServiceTime; // Track total service time
    private int customersServed;   // Track number of customers served

    public ServicePoint2() {
        this.queue = new LinkedList<>();
        this.totalServiceTime = 0;
        this.customersServed = 0;
    }

    // Add a customer to the queue
    public void addToQueue(Customer6 customer) {
        queue.add(customer);
    }

    // Remove a customer from the queue
    public Customer6 removeFromQueue() {
        return queue.poll();
    }

    // Serve customers in the queue
    public void serve() {
        Random random = new Random();
        while (!queue.isEmpty()) {
            Customer6 customer = removeFromQueue();
            if (customer != null) {
                long currentTime = System.currentTimeMillis();
                long waitingTime = currentTime - customer.getArrivalTime();

                // service time
                int serviceTime = random.nextInt(3000) + 1000; // 1-3 seconds
                totalServiceTime += serviceTime;
                customersServed++;

                try {
                    Thread.sleep(serviceTime); // Simulate service time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

                System.out.println("Customer " + customer.getId() + ": Waiting time = "
                        + waitingTime + " ms, Service time = " + serviceTime + " ms");
            }
        }
        System.out.println("All customers have been served.");
        if (customersServed > 0) {
            System.out.println("Average service time is " + (totalServiceTime / customersServed) + " ms");
        } else {
            System.out.println("No customers were served.");
        }
    }
}

class CustomerGenerator6 {
    public void generateCustomers(ServicePoint2 servicePoint, int numberOfCustomers) {
        for (int i = 1; i <= numberOfCustomers; i++) {
            Customer6 customer = new Customer6(i);
            servicePoint.addToQueue(customer);
            System.out.println("Customer " + customer.getId() + " added to the queue.");
        }
    }
}

public class ServicePoint6 {
    public static void main(String[] args) {
        ServicePoint2 servicePoint = new ServicePoint2();
        CustomerGenerator6 generator = new CustomerGenerator6();

        int numberOfCustomers = 5;
        generator.generateCustomers(servicePoint, numberOfCustomers);
        servicePoint.serve();
        }
    }
