package fireDrillOne;

public class TaskSeven {
    public static void main(String[] args) {

        int multiples = 1;
        int sum = 0;

        for (int number = 1; number <= 10; number++) {
            if (number % 4 == 0) {
                for (int index = 0; index < 5; index++) {
                    multiples *=number;
                    sum += multiples;
                }
                System.out.println( sum);
                number += number;
                multiples = 1;
                sum=0;
                for (int index = 0; index < 5; index++) {
                    multiples *=number;
                    sum += multiples;
                }
                System.out.println(sum);
                break;
            }
        }
    }

}