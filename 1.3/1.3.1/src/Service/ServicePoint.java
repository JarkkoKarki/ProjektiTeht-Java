package Service;

import java.util.LinkedList;
import java.util.Queue;

public class ServicePoint {
    private Queue<Customer> queue;

    public ServicePoint() {
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);  // Add customer to the queue
    }

    public Customer serveCustomer() {
        return queue.poll();  // Serve one customer
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
