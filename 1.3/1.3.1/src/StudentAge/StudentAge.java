package StudentAge;

public class StudentAge {
    public static void main(String[] args) {
        final int ITERATIONS = 1000;
        final int MAXAGE = 33;
        int distribution[][] = {
                {16, 20},
                {34, 21},
                {52, 22},
                {68, 23},
                {82, 24},
                {84, 25},
                {87, 26},
                {89, 27},
                {92, 28},
                {94, 29},
                {96, 30},
                {97, 31},
                {98,32},
                {99,33},
                {100,MAXAGE},
        };
        int generateAges[] = new int [MAXAGE +1]; //Tallennetaan tulokset

        for (int i = 0; i < ITERATIONS; i++) {
            int x = (int) (Math.random() * 100) + 1;
            int j = 0;
            while (x > distribution[j][0])j++; // Käydään läpi mihin ikään numero osuu
            generateAges[distribution[j][1]]++; // lisätään luku generateAges listaan siihen paikkaan mihin satunnaisluku osuu
        }
        System.out.println("Age count");
        for (int age = 0; age <= MAXAGE; age++) {
            if (age >= 20 && age <= MAXAGE) {
                System.out.println(age + ": " + generateAges[age]);
            }
        }
    }


}
