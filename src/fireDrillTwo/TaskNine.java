package fireDrillTwo;

import java.util.Scanner;

public class TaskNine {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        float scores = 0;
        float totalScores = 0;
        for (int number = 1; number <= 10; ++number) {
            System.out.println("Enter your Score");
            scores = input.nextInt();
            if (scores >= 0 && scores <= 100)
                totalScores += scores;

        }
        System.out.println(totalScores);
    }
}
