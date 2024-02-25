import Diaries.*;
import Diaries.Diary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    @Test
    public void testDairyHasUserName(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        assertEquals("Joshua",  myDiary.getUserName());
    }

    @Test
    public void testDairyHasPassword(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        assertTrue(myDiary.validatePassword("j123Jayty"));
    }

    @Test
    public void testNewDairyCanBeLocked(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void testNewDairyCanBeLocked_Entries_CannotBeCreated_unlockDiary_EntriesCreated(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
        assertThrows(DiaryIsLockedException.class,() -> {
            myDiary.createEntry("sample Entry", "this is my sample test ");
        });
        myDiary.unlockDiary();
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        assertEquals(2, myDiary.getNumberOfEntries());
    }
    @Test
    public void testNewDairyCanBeLocked_Entries_CannotBeDeleted_unlockDiaries_entriesCanBeCreated(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
        assertThrows(DiaryIsLockedException.class,() -> {
            myDiary.createEntry("sample Entry", "this is my sample test ");
        });
        myDiary.unlockDiary();
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        myDiary.lockDiary();
        assertThrows(DiaryIsLockedException.class,() -> {
            myDiary.deleteEntry(2);
        });
        assertEquals(2, myDiary.getNumberOfEntries());
        myDiary.unlockDiary();
        myDiary.deleteEntry(1);
        myDiary.deleteEntry(2);
        assertEquals(0, myDiary.getNumberOfEntries());
    }

    @Test
    public void testNewDairyIsNotLocked(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        assertFalse(myDiary.isLocked());
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
    }
    @Test
    public void testCreate4NewDairies_DairyIsNotLocked_deleteEntryWith1twoTimes_elementDoesNotExist(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
        assertThrows(DiaryIsLockedException.class,() -> {
            myDiary.createEntry("sample Entry", "this is my sample test ");
        });
        myDiary.unlockDiary();
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        myDiary.createEntry("Stanley", "This is a third sample");
        myDiary.createEntry("Chichi", "This is a forth sample");
        myDiary.deleteEntry(2);
        assertThrows(IllegalArgumentException.class,() -> {myDiary.deleteEntry(2);});
        assertEquals(3, myDiary.getNumberOfEntries());

    }

    @Test
    public void testCreateTwoEntries_NewDairyCanBeLocked_validatePassword(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        assertThrows(InvalidPasswordException.class,() -> {
            myDiary.validatePassword("j123kayty");
            }
        );
        assertTrue( myDiary.validatePassword("j123Jayty"));
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void create_two_dairy_entry_number_of_entries_increases(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        assertEquals(2,myDiary.getNumberOfEntries());
    }

    @Test
    public void createFourDairyEntry_LastOne_threeEntriesRemains(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        myDiary.createEntry("Stanley", "This is a third sample");
        myDiary.createEntry("Chichi", "This is a forth sample");
        assertEquals(4,myDiary.getNumberOfEntries());
        myDiary.deleteEntry(4);
        assertEquals(3,myDiary.getNumberOfEntries());
    }

    @Test
    public void  createFourDairyEntry_RemoveSecondEntry_SecondEntryRemoved_threeEntriesRemains(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        myDiary.createEntry("Stanley", "This is a third sample");
        myDiary.createEntry("Chichi", "This is a forth sample");
        assertEquals(4,myDiary.getNumberOfEntries());
        myDiary.deleteEntry(2);
        assertNull(myDiary.findEntryById(2));
        assertEquals(3,myDiary.getNumberOfEntries());
    }

    @Test
    public void  createFourDairyEntry_RemoveSecondAndFourthEntry_BothEntriesRemoved_twoEntriesRemains(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        myDiary.createEntry("Stanley", "This is a third sample");
        myDiary.createEntry("Chichi", "This is a forth sample");
        assertEquals(4,myDiary.getNumberOfEntries());
        myDiary.deleteEntry(2);
        myDiary.deleteEntry(4);
        assertNull(myDiary.findEntryById(2));
        assertNull(myDiary.findEntryById(4));
        assertNotNull(myDiary.findEntryById(1));
        assertNotNull(myDiary.findEntryById(3));
    }

    @Test
    public void  createFourDairyEntry_RemoveSecondAndFourthEntry_BothEntriesRemoved_updateEntryOne(){
        Diary myDiary = new Diary("Joshua", "j123Jayty");
        myDiary.createEntry("sample Entry", "this is a junit test sample");
        myDiary.createEntry("Odogwu", "This is a second sample");
        myDiary.createEntry("Stanley", "This is a third sample");
        myDiary.createEntry("Chichi", "This is a forth sample");
        assertEquals(4,myDiary.getNumberOfEntries());
        myDiary.deleteEntry(2);
        myDiary.deleteEntry(4);
        assertNull(myDiary.findEntryById(2));
        assertNull(myDiary.findEntryById(4));
        assertNotNull(myDiary.findEntryById(1));
        assertNotNull(myDiary.findEntryById(3));
    }
}
