package fireDrillTwo;

import java.util.Scanner;

public class TaskTen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        float scores = 0;
        float totalScores = 0;
        int count = 0;
        float average = 0;

        for (int number = 1; number <= 10; ++number) {
            System.out.println("Enter your Score");
            scores = input.nextInt();
            if (scores >= 0 && scores <= 100)
                count++;
            totalScores += scores;
                average = totalScores /count;

        }
        System.out.println(average);
    }
}
