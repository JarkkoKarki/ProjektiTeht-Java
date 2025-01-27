package ArrivalProcess;

import java.util.Random;


public class Negexp {
    private double mean;
    private Random random;

    public Negexp(double mean) {
        this.mean = mean;
        this.random = new Random();
    }

    public double sample() {
        // negative exponential distribution
        return -mean * Math.log(1 - random.nextDouble());
    }
}
