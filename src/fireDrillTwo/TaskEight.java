package fireDrillTwo;

import java.util.Scanner;

public class TaskEight {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        float scores = 0;
        float totalScores = 0;
        for (int number = 0; number <= 10; ++number) {
            if (scores >= 0 && scores <= 100) {
                System.out.println("Enter your Score");
                scores = input.nextInt();
            } else  {
                System.out.println("invalid Entry!! Kindly Enter your Score again");
                scores = input.nextInt();
            }

            totalScores += scores;

        }
        System.out.println(totalScores);
    }
}