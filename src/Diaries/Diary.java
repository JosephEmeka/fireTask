package Diaries;

import bankApp.InvalidPinException;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String userName;
    private String password;
    private List<Entry> myDiaryList;

    private int idCount = 0;
    private boolean isLocked;

    public Diary(String userName, String password) {
        idCount++;
        this.userName = userName;
        this.password = password;
        myDiaryList = new ArrayList<>();

    }


    public void createEntry(String title, String body) {
        if(isLocked()){
            throw new DiaryIsLockedException("Dairy is Locked! Unlock to proceed");
        }
        else {
            Entry freshEntry = new Entry(idCount++, title, body);
            myDiaryList.add(freshEntry);
        }
    }

    public int getNumberOfEntries() {
        return myDiaryList.size();
    }

    public void deleteEntry(int id) {
        if(isLocked()){
            throw new DiaryIsLockedException("Dairy is Locked! Unlock to proceed");
        }
        if (findEntryById(id) == null){
            throw new IllegalArgumentException("Element already deleted or does not exist in the list");
        }
        else {
            myDiaryList.removeIf(entry -> entry.getId() == id);

        }
    }

    public Entry findEntryById(int id) {
        for (Entry myEntry : myDiaryList) {
            if (myEntry.getId() == id) return myEntry;
            }
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void lockDiary() {
        this.isLocked = true;
    }
    public void unlockDiary() {
        this.isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean validatePassword(String enteredPassword) {
//        enteredPassword.[^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$"]
        if (enteredPassword.length() < 6 || enteredPassword.length() > 15) {
            throw new IllegalArgumentException("password must be between 6-15 Characters long");
        }
        if (enteredPassword.equals(this.password)) {
            return true;
        }
        else{
            throw new InvalidPasswordException("Invalid Password");
        }

    }
}
