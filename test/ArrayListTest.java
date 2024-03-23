import myArrayList.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    MyArrayList listOfStrings;
    @BeforeEach
    public void doThisBeforeAllTheTest(){
         listOfStrings = new MyArrayList(5);
    }


    @Test
    public void testThatNewArrayListIsEmpty() {
        assertTrue(listOfStrings.isEmpty());
    }

    @Test
    public void addNewElementToArrayList_ListIsEmpty() {
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("new-Strings");
        assertFalse(listOfStrings.isEmpty());
    }

    @Test
    public void testThatNewElementAddedToArrayList_ListNotEmpTy_ElementAddedToEndOfList(){
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("new-Strings");
        assertFalse(listOfStrings.isEmpty());
        assertEquals("new-Strings", listOfStrings.get(0));
        listOfStrings.add("second-Strings");
        assertEquals("second-Strings", listOfStrings.get(1));
    }

    @Test
    public void testThatNewElementCannotBeAddedToArrayListAtMaximumCapacity(){
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("ZeroIndex-Strings");
        listOfStrings.add("IndexOne-Strings");
        listOfStrings.add("IndexTwo-Strings");
        listOfStrings.add("IndexThree-Strings");
        listOfStrings.add("IndexFour-Strings");
        assertFalse(listOfStrings.isEmpty());
        assertEquals("ZeroIndex-Strings", listOfStrings.get(0));
        assertEquals("IndexOne-Strings", listOfStrings.get(1));
        assertEquals("IndexTwo-Strings", listOfStrings.get(2));
        assertEquals("IndexThree-Strings", listOfStrings.get(3));
        assertEquals("IndexFour-Strings", listOfStrings.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> listOfStrings.add("IndexFive-Strings"));
    }

    @Test
    public void testThatNewElementCanBeInsertedToListAtAnyIndex_ListNotEmpTy_NumberOfElementDoesNotChange(){
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("First-Strings");
        assertFalse(listOfStrings.isEmpty());
        assertEquals("First-Strings", listOfStrings.get(0));
        listOfStrings.add("Second-Strings");
        listOfStrings.add("Third-Strings");
        listOfStrings.add("Forth-Strings");
        assertEquals("Second-Strings", listOfStrings.get(1));
        listOfStrings.add(3, "second-Strings");
        assertEquals("second-Strings", listOfStrings.get(3));

    }


    @Test
    public void testThatNewElementCannotBeInsertedToListAtMaximumCapacity(){
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("First-Strings");
        assertFalse(listOfStrings.isEmpty());
        assertEquals("First-Strings", listOfStrings.get(0));
        listOfStrings.add("Second-Strings");
        listOfStrings.add("Third-Strings");
        listOfStrings.add("Forth-Strings");
        assertEquals("Second-Strings", listOfStrings.get(1));
        listOfStrings.add(3, "second-Strings");
        assertEquals("second-Strings", listOfStrings.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> listOfStrings.add(5, "second-Strings"));

    }

    @Test
    public void testThatAllElementInListCanBeCleared_ListISEmpty() {
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("ZeroIndex-Strings");
        listOfStrings.add("IndexOne-Strings");
        listOfStrings.add("IndexTwo-Strings");
        listOfStrings.add("IndexThree-Strings");
        listOfStrings.add("IndexFour-Strings");
        listOfStrings.clear();
        assertEquals(0, listOfStrings.size());
        assertTrue(listOfStrings.isEmpty());
    }


    @Test
    public void testThatAnElementInListCanBeRemoved_AtSpecifiedIndex() {
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("ZeroIndex-Strings");
        listOfStrings.add("IndexOne-Strings");
        listOfStrings.add("IndexTwo-Strings");
        listOfStrings.add("IndexThree-Strings");
        listOfStrings.add("IndexFour-Strings");
        listOfStrings.remove(3);
        assertEquals("IndexFour-Strings", listOfStrings.get(3));
        assertFalse(listOfStrings.isEmpty());
    }

    @Test
    public void testThatAnElementInListCanBeSetAndReplaced_AtSpecifiedIndex() {
        assertTrue(listOfStrings.isEmpty());
        listOfStrings.add("ZeroIndex-Strings");
        listOfStrings.add("IndexOne-Strings");
        listOfStrings.add("IndexTwo-Strings");
        listOfStrings.add("IndexThree-Strings");
        listOfStrings.add("IndexFour-Strings");
        listOfStrings.set(3, "replaced_index");
        assertEquals("IndexThree-Strings", listOfStrings.set(3, "replaced_index"));
        assertFalse(listOfStrings.isEmpty());
    }




}
