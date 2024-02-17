package fireDrillTwo;

import java.util.*;


public class DoubleArray {
    public static void main(String[] args) {

        int [] array = {4, 5, 6};
        System.out.println(Arrays.toString(functionTakesArray_ReturnsDoubleTheLength(array)));

    }
    public static int[] functionTakesArray_ReturnsDoubleTheLength(int[] numbers) {
        int [] newArray = new int[doubleArrayLength(numbers).length];
        int newCount = numbers.length;
         for (int count = 0; count < numbers.length; count++){
             newArray[count] = numbers[count];
             newArray[newCount] = numbers[count] * 2;
            newCount++;
         }
        return newArray;
    }

    public static int []  doubleArrayLength(int[] array) {
        return new int[array.length * 2];
    }


    public static int[] functionTakesArray_ReturnsArrayWithOnesAndZerosToReplaceEvenAndOddNumbers(int[] array) {
        int [] new_array = new int[array.length];
        int count = 0;
            for (int element : array) {
                if (element % 2 != 0) {
                    new_array[count] = 1;
                }
                count++;
            }

        return new_array;
    }


    public static boolean[] functionTakesArray_ReturnsArrayWithTrueAndFalseToReplaceEvenAndOddNumbers(int[] array) {
        boolean [] new_array = new boolean[array.length];
        int count = 0;
        for (int element : array) {
            if (element % 2 != 0) new_array[count] = true;
            count++;
        }

        return new_array;
    }

   int [] new_array = new int[10];
}
