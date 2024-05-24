import fireDrillTwo.DoubleArray;
import org.junit.jupiter.api.Test;

import static fireDrillTwo.DoubleArray.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DoubleArrayTest {
    @Test

    public void testThatFunctionDoublesArrayFromFirstArray(){
        int [] array = {4,2,9};
        int [] expected = {0,0,0,0,0,0};
        assertArrayEquals(expected, doubleArrayLength(array));

    }

    @Test
    public void testThatDoubleArrayFillsTheLengthOfNewArray_WithDoubleElementFromFirstArray() {
        int[] array = {4, 5, 6};
        int[] result = {4, 5, 6, 8, 10, 12};
        assertArrayEquals(result, functionTakesArray_ReturnsDoubleTheLength(array));
    }
    @Test
    public void testThatArrayReturnsAnArrayOfOneANdZerosForOddAndEvenNumbersRespectively(){
        int [] array = {4, 5, 8, 8, 8, 2, 9};
        int [] result = {0, 1, 0, 0, 0, 0, 1};
        assertArrayEquals(result, functionTakesArray_ReturnsArrayWithOnesAndZerosToReplaceEvenAndOddNumbers(array));
        }



    @Test
    public void testThatArrayReturnsAnArrayOfTrueAndFalseForOddAndEvenNumbersRespectively(){
        int [] array = {4, 5, 8, 8, 8, 2, 9};
        boolean[] result = {false, true, false, false, false, false, true};
        assertArrayEquals(result, functionTakesArray_ReturnsArrayWithTrueAndFalseToReplaceEvenAndOddNumbers(array));
    }


    @Test
    public void testvalidatePhoneNumber1(){

    }

    @Test
    public void testvalidatePhoneNumber2(){

    }





}
