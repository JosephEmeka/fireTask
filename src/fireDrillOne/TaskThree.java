package fireDrillOne;

public class TaskThree {

    public static void main(String[] args) {
        int number = 1;
        int remainder = 0;
        for (int index = 0; index < 9; ++index) {
            number++;
            remainder = number / 2;
            if (number % 2 == 1) {
                System.out.println(number);
            }
        }
    }
}
