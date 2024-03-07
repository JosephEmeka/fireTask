package bankApp;

import javax.swing.*;

public class BankApp {
    private Bank bank;

    public static void main(String...args){
        runApp();

    }

    private static void runApp() {
        String mainMenu = """
                Welcome to  Semicolon Bank

                What would you like to do on this App?

                Choose from the following options

                1) Create Account
                2) Deposit
                3) Withdraw
                4) Transfer
                5) Check Balance
                6) Remove Account
                7) Find Account
                8) Exit
                """;

        String userChoice = JOptionPane.showInputDialog(null, mainMenu);

        switch (userChoice){
            case "1" -> {

                    createAccount();
            }

            case "2" -> {

                    deposit();

            }

            case "3" -> {
                withdraw();
            }

            case "4" -> {
                transfer();



            }

            case "5" -> {

                checkBalance();

            }

            case "6" -> {

                removeAccount();

            }

            case "7" -> {

                findAccount();


            }

            case "8" -> {

                exitApp();

            }

        }
    }

    private static void createAccount() {

    }

    private static void deposit() {

    }

    private static void withdraw() {

    }

    private static void transfer() {

    }

    private static void checkBalance() {

    }

    private static void removeAccount() {
    }

    private static void findAccount() {

    }

    private static void exitApp() {

    }



}
