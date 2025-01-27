package ArrivalProcess;



public class TestArrivalProcess {
    public static void main(String[] args) {
        // Negexp (Negative Exponential Distribution) mean= 5.0
        Negexp negExpDist = new Negexp(5.0);

        // 10 tapahtumaa
        for (int i = 0; i < 10; i++) {
            double nextArrival = negExpDist.sample(); // seuraava tapahtuma
            System.out.println("Next arrival in: " + nextArrival + " time units");
        }
    }
}
