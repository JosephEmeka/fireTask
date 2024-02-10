import Stack.MyStack;
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
    public void testThatWhenAnElementIsAddedInStack_StackIsNotEmpty() {
        stringStack.push("Adidas");
        assertFalse(stringStack.stackIsEmpty());
    }

    @Test
    public void testThatMoreThanOneElementCanBePushedIntoStack_StackNotEmpty() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        assertFalse(stringStack.stackIsEmpty());
    }


    @Test
    public void testThatSameElementCanBePushedIntoStack_StackNotEmpty() {
           stringStack.push("Adidas");
           stringStack.push("Nike");
           stringStack.push("Adidas");
           stringStack.push("Crocs");
           assertEquals(4,stringStack.size());
           stringStack.pop();
           assertEquals(3,stringStack.size());
    }

    @Test

    public void testThatElementPushedIntoStackIsTheLastElementInStack() {
        stringStack.push("Adidas");
        stringStack.push("Nike");
        assertEquals("Nike",  stringStack.pop());


    }

    @Test
    public void testThatElementsPlacedBeforeTheLastElementInStackCannotPopped() {
//        String shoeName = "Adidas";
//        String secondShoeName = "Nike";
//        stringStack.pop();


    }

    @Test
    public void testThatElementsCannotBePlacedPushedIntoPositionsBeforeTheLastElementInStack() {
//        String shoeName = "Adidas";
//        String secondShoeName = "Nike";
//        stringStack.pop();


    }

    @Test
    public void testThatLastNameInStackCanBePeeked() {
//        String shoeName = "Adidas";
//        String secondShoeName = "Nike";
//        stringStack.pop();
//    }

    }

}


