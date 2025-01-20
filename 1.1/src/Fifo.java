import java.util.LinkedList;
import java.util.Scanner;

public class Fifo {
    private int id;
    private long startTime;
    private long endTime;
    private static int idCount = 1;

    public Fifo() {
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
        Scanner scanner = new Scanner(System.in);
        LinkedList<Fifo> queue = new LinkedList<>();
        int command = -1;

        while (command != 0) {
            System.out.println("Press 0 to exit. \nPress 1 to add customer to line. \nPress 2 to remove the first customer from line.");
            command = Integer.parseInt(scanner.nextLine());

            if (command == 1) {
                Fifo customer = new Fifo();
                customer.setStartTime(System.currentTimeMillis());
                queue.addFirst(customer);
                System.out.println("Added Customer to a line. id: " + customer.getId() );
            } else if (command == 2 ) {
                if (!queue.isEmpty()) {
                    Fifo customer = queue.removeLast();
                    customer.setEndTime(System.currentTimeMillis());
                    System.out.println("Removed Customer. id: " + customer.getId() + " from the line. Time: " + customer.calculateTime() + " ms");
                } else {
                    System.out.println("No customers to remove");
                }
            }

        }
    }



}