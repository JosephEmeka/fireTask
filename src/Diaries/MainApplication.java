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
                4) Exit App
                """;

        String userInput = showInputDialog(null, prompts);

        switch (userInput) {
            case "1" -> {
                String wouldYouLikeToCreateYourUniqueDiaryInput = showInputDialog(null, "Would you like to create your unique diary? Yes or No");
                    while(!wouldYouLikeToCreateYourUniqueDiaryInput.matches("[a-zA-Z]")) {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                        wouldYouLikeToCreateYourUniqueDiaryInput = showInputDialog(null, "Would you like to create your unique diary? Yes or No");
                    }
                    if (wouldYouLikeToCreateYourUniqueDiaryInput.equalsIgnoreCase("yes"))
                            createDiary();
                    else if (wouldYouLikeToCreateYourUniqueDiaryInput.equalsIgnoreCase("no")) {
                        runApp();
                    }
                break;

            }

            case "2" -> {
                String userName = showInputDialog(null, "Enter User Name");
                while(!userName.matches("[a-zA-Z]{1,50}")) {
                    JOptionPane.showMessageDialog(null, "Invalid input. User name should contain only alphabets and be up to 50 characters long.");
                    userName = showInputDialog(null, "Enter User Name");
                }
                lockDiary(userName);
                break;
            }

            case "3" -> {
                String userName = showInputDialog(null, "Enter User Name");
                while(!userName.matches("[a-zA-Z]{1,50}")) {
                    JOptionPane.showMessageDialog(null, "Invalid input. User name should contain only alphabets and be up to 50 characters long.");
                    userName = showInputDialog(null, "Enter User Name");
                }
                unlockDiary(userName);
                break;
            }

            case "4" -> {
                exitApp();
                break;
            }

            default -> {
                exitApp();
            }
        }
    }

    private static void exitApp() {
        JOptionPane.showMessageDialog(null, "Exiting the application. Goodbye!");
        System.exit(0);
    }



    private static void createDiary() {
        String userName = showInputDialog(null, "Enter User Name");
        while(!userName.matches("[a-zA-Z]{1,50}")) {
            JOptionPane.showMessageDialog(null, "Invalid input. User name should contain only alphabets and be up to 50 characters long.");
            userName = showInputDialog(null, "Enter User Name");
        }
        String enterStrongPassword = showInputDialog(null, "Enter Strong Password");
        while(!enterStrongPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=\\\\S+$).{8,}$\"")) {
            JOptionPane.showMessageDialog(null, "Invalid password");
            enterStrongPassword = showInputDialog(null, "Enter Strong Password");
        }
        JOptionPane.showMessageDialog(null, "creating diary...");
        Diary sampleDiary = new Diary(userName, enterStrongPassword);
        diaryArrayList.add(sampleDiary);
        JOptionPane.showMessageDialog(null, "Diary created successfully...");
        String createDiaryOptions = """
                what would you like to do next?
                1) Add Entry
                2) Delete Entry
                3) Update Entry
                4) Find Entry by Id
                5) Go back to main menu
                6) exit app
                """;

        String userInput = showInputDialog(null, createDiaryOptions);

        switch (userInput) {
            case "1" -> {
                addEntry();
                break;
            }

            case "2" -> {
                deleteEntry();
                break;
            }

            case "3" -> {
                updateEntry();
                break;
            }

            case "4" -> {
                String entryId = showInputDialog(null, "Enter entry ID");
                while(!entryId.matches("[1-9]{1,50}")) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Entry ID should contain only numbers and be up to 50 characters long.");
                    entryId = showInputDialog(null, "Enter User Name");
                }
                findEntryById();
                break;
            }

            case "5" -> {
                runApp();
                break;
            }

            case "6" -> {
                exitApp();
                break;
            }

            default -> {
                exitApp();
            }
        }


    }

    private static void deleteEntry() {
        JOptionPane.showMessageDialog(null, "Deleting entry...");


    }

    private static void updateEntry() {
       String myID = JOptionPane.showInputDialog(null, " Enter entry ID...");
        JOptionPane.showMessageDialog(null, "Updating entry...");
        for(Diary mydiary:diaryArrayList)
            if (mydiary.getUserName().equals(myID))
                mydiary.unlockDiary();
        JOptionPane.showMessageDialog(null, "Diary is unlocked...");

    }

    private static void addEntry() {
        JOptionPane.showMessageDialog(null, "Adding entry...");

    }

    private static void findEntryById() {
       String myId = JOptionPane.showInputDialog(null, " Enter entry ID...");
        JOptionPane.showMessageDialog(null, "Finding entry by ID...");
        for(Diary mydiary:diaryArrayList)
            if (mydiary.getUserName().equals(myId))
                mydiary.findEntryById(Integer.parseInt(myId));
            else {
                JOptionPane.showMessageDialog(null, "Entry ID does not exist in diary...");
                runApp();
            }

    }

    private static void unlockDiary(String userName) {

        JOptionPane.showMessageDialog(null, "Unlocking diary...");
        for(Diary mydiary:diaryArrayList)
            if (mydiary.getUserName().equals(userName))
                mydiary.unlockDiary();
        JOptionPane.showMessageDialog(null, "Diary is unlocked...");


    }

    private static void lockDiary(String userName) {
        JOptionPane.showMessageDialog(null, "Locking diary...");
        for(Diary mydiary:diaryArrayList)
            if (mydiary.getUserName().equals(userName))
                mydiary.lockDiary();
        JOptionPane.showMessageDialog(null, "Diary is Locked...");


    }

}
