import Stack.MyStack;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    private MyStack stringStack;

    @BeforeEach
    public void doThisBeforeAll(){
         stringStack = new MyStack(4);
    }

    @Test
    public void testThatStackIsEmpty(){
        assertTrue(stringStack.stackIsEmpty());
    }

    @Test
    public void testThatWhenEmptyStackIsPopped_ThrowsOutOfBoundException(){
        assertTrue(stringStack.stackIsEmpty());
        stringStack.pop();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringStack.pop());


    }
    @Test
    public void testThatWhenAnElementIsAddedInStack_StackIsNotEmpty(){
        //MyStack stackOfString = new MyStack();
        String shoeName = "Adidas";
        stringStack.pop(shoeName);
        assertFalse(stringStack.stackIsEmpty());
    }

    @Test
    public void testThatMoreThanOneElementCanBePushedIntoStack_StackNotEmpty(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        stringStack.pop(shoeName);

    }


    @Test
    public void testThatElementCanBePoppedOutOfStack_StackNotEmpty(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        stringStack.pop(shoeName);
        stringStack.pop();

    }

    @Test

    public void testThatElementPushedIntoStackIsTheLastElementInStack(){



    }
    @Test
    public void testThatElementsPlacedBeforeTheLastElementInStackCannotPopped(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        stringStack.pop(shoeName);
        stringStack.pop();

    }

    @Test
    public void testThatElementsCannotBePlacedPushedIntoPositionsBeforeTheLastElementInStack(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        stringStack.pop(shoeName);
        stringStack.pop();

    }

   @Test
    public void testThatLastNameInStackCanBePeeked(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        stringStack.pop(shoeName);
        stringStack.pop();
    }
}


