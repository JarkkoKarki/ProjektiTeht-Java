package Clock;

public class Clock {
    private static Clock instance;

    private int currentTime;

    private Clock() {
        this.currentTime = 0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setTime(int time) {
        if (time < 0) {
            System.out.println("Time cannot be negative.");
        }
        this.currentTime = time;
    }

    public int getTime() {
        return this.currentTime;
    }
}
