package fireDrillOne;

public class TaskSix {

    public static void main(String[] args) {

        int multiples = 1;

        for (int number = 1; number <= 10; number++) {
            if (number % 4 == 0) {
                for (int index = 0; index < 5; index++) {
                    System.out.print((multiples *=number) + "\n");

                }
                number += number;
                multiples = 1;
                for (int index = 0; index < 5; index++) {
                    System.out.print((multiples *=number) + "\n");
                }
                break;
            }
        }
    }
}