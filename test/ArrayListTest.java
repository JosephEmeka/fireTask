import MyArrayList.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    MyArrayList Strings;
    @BeforeEach
    public void doThisBeforeAllTheTest(){
         Strings = new MyArrayList();
    }


    @Test
    public void testThatNewArrayListIsEmpty() {
        assertTrue(MyArrayList.isEmpty(Strings));

    }
    @Test
    public void addNewElementToArrayList_ListIsEmpty() {
        assertTrue(MyArrayList.isEmpty(Strings));
        Strings.add("new-Strings");
        assertTrue(MyArrayList.isEmpty(Strings));

    }
}
