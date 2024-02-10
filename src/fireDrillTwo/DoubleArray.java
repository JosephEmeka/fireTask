package fireDrillTwo;

import java.util.*;


public class DoubleArray {
    public static void main(String[] args) {

        int [] array = {4, 5, 6};
        System.out.println(functionTakesArray_ReturnsDoubleTheLength(array));

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
}
