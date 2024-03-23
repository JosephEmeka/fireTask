package bankApp;

import javax.swing.*;

public class BankApp {
    private static Bank bank = new Bank("GTB");

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
            default -> {

                JOptionPane.showMessageDialog(null, "Invalid enter! enter number between 1 and 9");
                runApp();
            }

        }
    }

    private static void createAccount() {
        String firstName = JOptionPane.showInputDialog("Enter first Name ");
        String secondName = JOptionPane.showInputDialog("Enter second Name ");
        String pin = JOptionPane.showInputDialog("Enter Pin");
        try {

            bank.registerCustomer(firstName, secondName, pin);
        }
        catch (DoubleRegistrationException| InvalidPinException e){
            JOptionPane.showMessageDialog(null, "customer cannot be registered twice");
            runApp();
        }

        JOptionPane.showMessageDialog(null, STR."customer \{firstName} \{secondName} with account number \{bank.getCustomerAccountNumber(firstName, secondName)} registered successfully");
    }

    private static void deposit() {

        try {
            int accountNumberForDeposit = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number "));
            int amountToBeDeposited = Integer.parseInt(JOptionPane.showInputDialog("Enter amount to be deposited "));
            bank.deposit(accountNumberForDeposit, amountToBeDeposited);
        }
        catch(AccountNotFoundException| InvalidAmountException _){
            JOptionPane.showMessageDialog(null, "Account Number Not Found");
            runApp();
        }

    }

    private static void withdraw() {

        try {
            int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number "));
            int amountToBeDeposited = Integer.parseInt(JOptionPane.showInputDialog("Enter amount to be deposited "));
            String pin = JOptionPane.showInputDialog("Enter pin ");
            bank.deposit(accountNumber, amountToBeDeposited);
        }
        catch(AccountNotFoundException|InvalidAmountException|InvalidPinException e){
            JOptionPane.showMessageDialog(null, "Account Number Not Found");
            runApp();
        }
    }

    private static void transfer() {

        try {
            int sendingAccountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter sender Account Number "));
            int receivingAccountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter receiver Account Number"));
            int amountToBeTransferred = Integer.parseInt(JOptionPane.showInputDialog("Enter amount to be deposited "));
            String pin = JOptionPane.showInputDialog("Enter pin ");
            bank.transfer(sendingAccountNumber,receivingAccountNumber,amountToBeTransferred,pin);
        }
        catch(InvalidAccountException|InvalidAmountException|InvalidPinException e){
            JOptionPane.showMessageDialog(null, "Account Number Not Found");
            runApp();
        }
    }

    private static void checkBalance() {

        try {
            int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number "));
            String pin = JOptionPane.showInputDialog("Enter pin ");
            bank.checkBalance(accountNumber,pin);
        }
        catch(InvalidAccountException |InvalidPinException e){
            JOptionPane.showMessageDialog(null, "Account Not Found");
            runApp();
        }
    }

    private static void removeAccount() {

        try {
            int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number "));
            String pin = JOptionPane.showInputDialog("Enter pin ");
            bank.removeAccount(accountNumber,pin);
        }
        catch(IllegalArgumentException |InvalidPinException e){
            JOptionPane.showMessageDialog(null, "Account Not Found");
            runApp();
        }
    }

    private static void findAccount() {

        try {
            int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number "));
            bank.findAccount(accountNumber);
        }
        catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Account Not Found");
            runApp();
        }

    }

    private static void exitApp() {
        JOptionPane.showMessageDialog(null, "Exiting the application. Goodbye!");
        System.exit(0);
    }


}
