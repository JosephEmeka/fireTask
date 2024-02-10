import fireDrillTwo.DoubleArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleArrayTest {
    @Test

    public void testThatFunctionDoublesArrayFromFirstArray(){
        int [] array = {4,2,9};
        int [] expected = {0,0,0,0,0,0};
        assertArrayEquals(expected, DoubleArray.doubleArrayLength(array));

    }

    @Test
    public void testThatDoubleArrayFillsTheLengthOfNewArray_WithDoubleElementFromFirstArray(){
        int [] array = {4, 5, 6};
        int [] result = {4, 5, 6, 8, 10, 12};
        assertArrayEquals(result, DoubleArray.functionTakesArray_ReturnsDoubleTheLength(array));



    }
}
