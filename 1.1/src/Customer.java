import java.util.LinkedList;

public class Customer {
    private int id;
    private long startTime;
    private long endTime;
    private static int idCount = 1;

    public Customer() {
        setId(idCount);
        idCount++;
    }


    public int getId(){
        return id;
    }
    private void setId(int id) {
        if (id > 0) { // Varmistetaan että id on suurempi kuin 0
            this.id = id;
        } else {
            System.out.println("id:n tulee olla suurempi kuin 0");
        }
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long start){
        startTime = start;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long end) {
        endTime = end;
    }

    public long calculateTime() {
        return endTime-startTime;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Customer customer2 = new Customer();

        customer.setStartTime(123);
        customer.setEndTime(654);
        customer2.setStartTime(42);
        customer2.setEndTime(9425);
        System.out.println("Asiakkaalla " + customer.getId() + " meni " + customer.calculateTime() + " ms palvelussa");
        System.out.println("Asiakkaalla " + customer2.getId() + " meni " + customer2.calculateTime() + " ms palvelussa");

        // FIFO TEHTÄVÄ
        //Luodaan ja täytetään jono
        LinkedList<Customer> queue = new LinkedList<>();
        queue.addFirst(customer);
        queue.addFirst(customer2);
        //Tyhjätään jono

        while (!queue.isEmpty()) {
            Customer c = queue.removeLast();
            System.out.println("Asiakkaalla " + c.getId() + " meni " + c.calculateTime() + " ms");
        }

        /*
        TAI

        int size = queue.size();
        for (int i=0; i<size; i++) {
            Customer c = queue.removeLast();
            System.out.println("Asiakkaalla " + c.getId() + " meni " + c.calculateTime() + " ms");
        }

         */


    }



}
