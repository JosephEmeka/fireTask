import Stack.MyStack;
import Stack.StackOverflowException;
import org.junit.jupiter.api.*;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    private MyStack stringStack;

    @BeforeEach
    public void doThisBeforeAll() {
        stringStack = new MyStack(5);
    }

    @Test
    public void testThatStackIsEmpty() {
        assertTrue(stringStack.stackIsEmpty());
    }

    @Test
    public void testThatWhenEmptyStackIsPopped_ThrowsEmptyStackException() {
        assertTrue(stringStack.stackIsEmpty());
        assertThrows(EmptyStackException.class, () -> stringStack.pop());
    }

    @Test
    public void testThatWhenAnElementIsPushedInStack_StackIsNotEmpty() {
        stringStack.push("Adidas");
        assertFalse(stringStack.stackIsEmpty());
        assertEquals(1,stringStack.size());
    }

    @Test
    public void testThatMoreThanOneElementCanBePushedIntoStack_StackNotEmpty() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        assertFalse(stringStack.stackIsEmpty());
        assertEquals(2,stringStack.size());
    }


    @Test
    public void testThatSameElementCanBePushedIntoStack_StackNotEmpty() {
           stringStack.push("Adidas");
           stringStack.push("Nike");
           stringStack.push("Adidas");
           assertEquals(3,stringStack.size());
           stringStack.pop();
           stringStack.push("Crocs");
           assertEquals(3,stringStack.size());
    }

    @Test

    public void testThatIfIPushedFourElementAndPopOne_TheNumberOfItemInStackIsThree() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        stringStack.push("Adidas");
        stringStack.push("Crocs");
        assertEquals(4,stringStack.size());
        stringStack.pop();
        assertEquals(3,stringStack.size());
    }

    @Test
    public void testThatFiveElementIsPushed_OneElementPopped_LastElementInStackCanBePeeked() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        stringStack.push("Game");
        stringStack.push("Cohen");
        stringStack.push("jeans");
        assertEquals("jeans",stringStack.peek());
        assertEquals(5,stringStack.size());
        stringStack.pop();
        assertEquals("Cohen",stringStack.peek());
    }


    @Test
    public void testThatLastElementInStackCanBePeeked() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        stringStack.push("Game");
        stringStack.push("Cohen");
        stringStack.pop();
        assertEquals(3,stringStack.size());
        assertEquals("Game",stringStack.peek());
    }

    @Test
    public void testThatEmptyArrayPeekedThrowsIllegalArgumentException() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        stringStack.pop();
        assertEquals("Adidas",stringStack.peek());
        assertEquals(1,stringStack.size());
        stringStack.pop();
        assertThrows(EmptyStackException.class, () -> stringStack.peek());
    }

    @Test
    public void testThatWhenElementIsPushIntoAFullCapacityStack_StackThrowsIllegalArgumentException() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        stringStack.push("Game");
        stringStack.push("Cohen");
        stringStack.push("Bike");
        assertEquals(5,stringStack.size());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringStack.push("Java"));
    }
}


