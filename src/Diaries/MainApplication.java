package Diaries;

import javax.swing.*;

import static java.lang.System.exit;

public class MainApplication {
    public static void main(String...args){

        runApp();

    }

    public static void runApp(){
        String prompts = """
                Welcome to my app
                
                What would you like to do on this App?
                
                Choose from the following options
                
                1) Create Diary
                2) Lock Diary
                3) Unlock Diary
                4) Exit App
                """;
        JOptionPane.showInputDialog(prompts);

        switch (prompts){
            case "1":
                createDiary();
                break;

            case "2":
                lockDiary();
                break;

            case "3":
                unlockDiary();
                break;

            default:
                exitApp();

        }
    }

    private static void exitApp() {

    }

    private static void unlockDiary() {
        
    }

    private static void lockDiary() {

    }

    private static void createDiary() {
        String createDiaryOptions = """
                1) Add Entry
                2) Delete Entry
                3) Update Entry
                4) Find Entry by Id
                """;
        
        switch (createDiaryOptions) {
            case "1":
                addEntry();
                break;

            case "2":
                deleteEntry();
                break;

            case "3":
                updateEntry();
                break;

            default:
                exitApp();

        }
    }

    private static void deleteEntry() {
    }

    private static void updateEntry() {
        
    }

    private static void addEntry() {
        
    }
}
