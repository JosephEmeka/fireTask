package Diaries;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;



public class MainApplication {
    private static final List<Diary> diaryArrayList = new ArrayList<>();
    private static final Diaries newDiaries = new Diaries(diaryArrayList);

    public static void main(String...args){

        runApp();

    }

    public static void runApp() {

        String prompts = """
                Welcome to my Semicolon Diary App
                
                What would you like to do on this App?
                
                Choose from the following options
                
                1) Create Diary
                2) Lock Diary
                3) Unlock Diary
                4) Add Entry
                5) Delete Entry
                6) Update Entry
                7) Find Entry by Id
                8) Exit App
                """;

        String userInput = showInputDialog(null, prompts);

        switch (userInput) {
            case "1" -> {
                String wouldYouLikeToCreateYourUniqueDiaryInput = showInputDialog(null, "Would you like to create your unique diary? Yes or No");
                while(!wouldYouLikeToCreateYourUniqueDiaryInput.matches("^[a-zA-Z]+$")) {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                        wouldYouLikeToCreateYourUniqueDiaryInput = showInputDialog(null, "Would you like to create your unique diary? Yes or No");
                    }
                    if (wouldYouLikeToCreateYourUniqueDiaryInput.equalsIgnoreCase("yes"))
                            createDiary();
                    else if (wouldYouLikeToCreateYourUniqueDiaryInput.equalsIgnoreCase("no")) {
                        runApp();
                    }
                goBackControlFunction();
                break;

            }

            case "2" -> {
                lockDiary();
                goBackControlFunction();
                break;
            }

            case "3" -> {
                unlockDiary();
                goBackControlFunction();
                break;
            }

            case "4" ->  {
                addEntry();
                goBackControlFunction();
                break;
            }

            case "5" -> {
                deleteEntry();
                goBackControlFunction();
                break;
            }

            case "6" -> {
                updateEntry();
                goBackControlFunction();
                break;
            }

            case "7" -> {
                findEntryById();
                goBackControlFunction();
                break;
            }


            case "8" -> {
                exitApp();
                break;
            }

            default -> {
                exitApp();
            }
        }
    }


    private static void createDiary() {
        String userName = showInputDialog(null, "Enter User Name");
        while(!userName.matches("^[a-zA-Z]{1,50}$")){
            JOptionPane.showMessageDialog(null, "Invalid input. User name should contain only alphabets and be up to 50 characters long.");
            userName = showInputDialog(null, "Enter User Name");
        }
        String enterStrongPassword = showInputDialog(null, "Enter Strong Password");
        while (!enterStrongPassword.matches("^(?=.[a-z])(?=.[A-Z]){8,15}$")) {
            JOptionPane.showMessageDialog(null, "Invalid password");
            enterStrongPassword = showInputDialog(null, "Enter Strong Password");
        }
        JOptionPane.showMessageDialog(null, "creating diary...");
        Diary sampleDiary = new Diary(userName, enterStrongPassword);
        diaryArrayList.add(sampleDiary);
        JOptionPane.showMessageDialog(null, "Diary created successfully...");
    }

    private static void deleteEntry() {
        int entryId = Integer.parseInt(showInputDialog(null, "Enter Entry ID to delete:"));
        for (Diary myDiary : diaryArrayList) {
            if (myDiary.getEntryId() == entryId) {
                diaryArrayList.remove(myDiary);
                JOptionPane.showMessageDialog(null, "Entry deleted successfully...");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Entry Not found...");
    }

    private static void updateEntry() {
        int entryId = Integer.parseInt(showInputDialog(null, "Enter Entry ID to update:"));
        for (Diary myDiary : diaryArrayList) {
            if (myDiary.getEntryId() == entryId) {
                String newTitle = showInputDialog(null, "Enter Entry ID to update:");
                String newBody = showInputDialog(null, "Enter Entry ID to update:");
                myDiary.updateEntry(entryId, newTitle, newBody);
                JOptionPane.showMessageDialog(null, "Entry updated successfully...");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Entry Not found...");
    }

    private static void addEntry() {
            String userName = JOptionPane.showInputDialog(null, "Enter Diary Username to add entry:");
            for (Diary myDiary : diaryArrayList) {
                if (myDiary.getUserName().equals(userName)) {
                    String newTitle = showInputDialog(null, "Enter New Title:");
                    String newBody = showInputDialog(null, "Enter New Body:");
                    myDiary.createEntry(newTitle, newBody);
                    JOptionPane.showMessageDialog(null, "Entry added successfully...");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, STR."Diary not found for user: \{userName}");
    }

    private static void findEntryById() {
        int entryId = Integer.parseInt(showInputDialog(null, "Enter Entry ID :  "));
        JOptionPane.showMessageDialog(null, "Finding entry by ID...");
        for (Diary mydiary : diaryArrayList)
            if (mydiary.getEntryId() == entryId) {
                mydiary.findEntryById(entryId);
            }

        JOptionPane.showMessageDialog(null, "Entry ID does not exist in diary...");
        runApp();
    }

    private static void unlockDiary() {
        String userName = JOptionPane.showInputDialog(null, "Enter Username to unlock diary:");
        for (Diary myDiary : diaryArrayList) {
            if (myDiary.getUserName().equals(userName)) {
                myDiary.unlockDiary(userName);
                JOptionPane.showMessageDialog(null, "Diary is unlocked...");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, STR."Diary not found for user: \{userName}");
    }

    private static void lockDiary() {
        String userName = JOptionPane.showInputDialog(null, "Enter Username to lock diary:");
        for (Diary myDiary : diaryArrayList) {
            if (myDiary.getUserName().equals(userName)) {
                myDiary.lockDiary();
                JOptionPane.showMessageDialog(null, "Diary is Locked...");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, STR."Diary not found for user: \{userName}");
    }

    private static void exitApp() {
        JOptionPane.showMessageDialog(null, "Exiting the application. Goodbye!");
        System.exit(0);
    }

    private static void goBackControlFunction(){
        String wouldYouLikeToCwouldYouLikeToContinue = showInputDialog(null, "Would you like to back to the menu? Yes(Menu) or No(Exit)");
        while(!wouldYouLikeToCwouldYouLikeToContinue.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null, "Invalid input");
            wouldYouLikeToCwouldYouLikeToContinue = showInputDialog(null, "Would you like to create your unique diary? Yes or No");
        }
        if (wouldYouLikeToCwouldYouLikeToContinue.equalsIgnoreCase("yes"))
            runApp();
        else if (wouldYouLikeToCwouldYouLikeToContinue.equalsIgnoreCase("no")) {
            exitApp();
        }

    }
}













