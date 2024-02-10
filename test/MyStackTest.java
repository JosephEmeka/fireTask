import Stack.MyStack;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class MyStackTest {
    private MyStack stackOfString;

    @BeforeEach
    public void doThisBeforeAll(){
        
        stackOfString = new MyStack();
    }

    @Test
    public void testThatStackIsEmpty(){
        assertTrue(MyStack.stackIsEmpty(stackOfString));
    }

    @Test
    public void testThatWhenEmptyStackIsPopped_StackReturnsEmptyStack(){
        assertTrue(MyStack.stackIsEmpty(stackOfString));
        MyStack.pop();



    }
    @Test
    public void testThatWhenAnElementIsAddedInStack_StackIsNotEmpty(){
        String shoeName = "Adidas";
        MyStack.add(shoeName);
        assertFalse(MyStack.stackIsEmpty(stackOfString));
    }

    @Test
    public void testThatMoreThanOneElementCanBePushedIntoStack_StackNotEmpty(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        assertTrue(MyStack.add(shoeName));

    }


    @Test
    public void testThatElementCanBePoppedOutOfStack_StackNotEmpty(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        assertTrue(MyStack.add(shoeName));
        MyStack.pop();

    }

    @Test

    public void testThatElementPushedIntoStackIsTheLastElementInStack(){



    }
    @Test
    public void testThatElementsPlacedBeforeTheLastElementInStackCannotPopped(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        assertTrue(MyStack.add(shoeName));
        MyStack.pop();

    }

    @Test
    public void testThatElementsCannotBePlacedPushedIntoPositionsBeforeTheLastElementInStack(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        assertTrue(MyStack.add(shoeName));
        MyStack.pop();

    }

    public void testThatLastElementInStackCanBeDisplayed(){
        String shoeName = "Adidas";
        String secondShoeName = "Nike";
        assertTrue(MyStack.add(shoeName));
        MyStack.pop();

    }
}


