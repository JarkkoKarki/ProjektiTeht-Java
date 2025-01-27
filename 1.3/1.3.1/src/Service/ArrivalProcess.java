package Service;

import java.util.Random;

public class ArrivalProcess {
    private double mean;
    private Random random;

    public ArrivalProcess(double mean) {
        this.mean = mean;
        this.random = new Random();
    }

    public double sample() {
        return -mean * Math.log(1 - random.nextDouble());  // Negative exponential distribution
    }
}
