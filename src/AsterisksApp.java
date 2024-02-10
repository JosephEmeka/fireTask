import java.util.ArrayList;
import java.util.Scanner;

public class AsterisksApp {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Integer of your choice between 1 - 15");
        int integerInput = input.nextInt();
        int count = 0;
        ArrayList <Integer> myArray = new ArrayList<>();

            while(integerInput < 15 && integerInput > 0) {
                System.out.println("Enter Integer of your choice between 1 -15");
                integerInput = input.nextInt();
                myArray.add(integerInput);
                count++;
                integerInput = 22;

            }

                {
                    for (int number = 0; number <= myArray.size(); number++) {
                        System.out.println("*");
                    }
                }
            }


    }

