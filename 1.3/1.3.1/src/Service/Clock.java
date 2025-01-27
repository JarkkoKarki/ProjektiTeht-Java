package Service;

public class Clock {
    private static Clock instance;

    private double currentTime;

    private Clock() {
        this.currentTime = 0.0;
    }

    // Singleton
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    // Asetetaan oikea aika
    public void setTime(double time) {
        if (time < 0) {
            System.out.println("Time cannot be negative.");
        }
        this.currentTime = time;
    }

    // Tämän hetkinen aika
    public double getTime() {
        return this.currentTime;
    }

    // Lisätään kelloon
    public void advanceTime(double timeUnits) {
        if (timeUnits < 0) {
            System.out.println("Cannot advance time by a negative value.");
        }
        this.currentTime += timeUnits;
    }
}
