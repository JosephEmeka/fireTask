package fireDrillOne;

public class TaskFive {

    public static void main(String[] args) {

        int multiples = 0;
        for (int number = 1; number <= 10; number++) {
            if (number % 4 == 0)
                for (int index = 0; index < 5; index++) {
                    System.out.print(number);
                }
            System.out.print(" ");
        }

    }

}