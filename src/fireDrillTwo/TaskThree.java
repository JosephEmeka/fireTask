package fireDrillTwo;

import java.util.Scanner;

public class TaskThree {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            float scores = 0;
            float totalScores = 0;
            float averageScores = 0;
            for (int number = 1; number <= 10; number++) {
                System.out.println("Enter your Score");
                scores = input.nextInt();
                totalScores += scores;
                averageScores = totalScores / 10;
            }

            System.out.println(totalScores);
            System.out.println(averageScores);
        }
    }
