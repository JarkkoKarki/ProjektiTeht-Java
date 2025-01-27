package Clock;

public class ClockUser {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();

        System.out.println("Initial time: " + clock.getTime());

        clock.setTime(10);
        System.out.println("Updated time: " + clock.getTime());

        Clock anotherClock = Clock.getInstance();

        anotherClock.setTime(20);

        System.out.println("Orginal Time: " + clock.getTime());
        System.out.println("New Time: " + anotherClock.getTime());
    }
}
