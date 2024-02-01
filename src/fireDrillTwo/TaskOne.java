package fireDrillTwo;

import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int scores = 0;
        int totalScores = 0;
        for(int number =1; number <= 10; number++) {
            System.out.println("Enter your Score");
            scores = input.nextInt();
            totalScores+= scores;
        }

        System.out.println(totalScores);
    }
}
