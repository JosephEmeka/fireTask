package bankApp;


import java.util.ArrayList;
import bankApp.InvalidAmountException;

import bankApp.Bank.*;

public class Account {

    private String name;
    private int balance;

    private String pin;

    private String number;

    private int numberOfAccount = 0;


    public Account (String name, String accountNumber, int initialBalance){
        if (initialBalance < 0 ){
            throw new IllegalArgumentException();
        }
        this.number = accountNumber;
        this.balance = initialBalance;
        this.pin = "0000";

    }

        public int getBalance(){
            return balance;
        }

        public void setBalance(int balance){
            this.balance = balance;
        }


        public void deposit(int amount){
            if (amount <= 0) {
                throw new InvalidAmountException(STR."Invalid amount: \{amount}");
            }
            balance += amount;

        }

        public void withdraw(int amount, String myPin){
            if (amount <= 0) {
                throw new InvalidAmountException(STR."Invalid amount: \{amount}");
            }
            if (amount > balance) {
                throw new InsufficientFundsException(STR."Invalid amount: \{amount}");
            }

            balance -= amount;
        }

        public boolean validatePin(String enteredPin) {
            if (enteredPin.length() != 4) {
                throw new IllegalArgumentException("pin must be four digits long");
            }
            return enteredPin.equals(String.valueOf(this.pin));

        }



    public String getDefaultPin() {
        return pin;
    }

    public String changePin(String myOldPin,String newPin) {
        if (validatePin(myOldPin)) {
            return this.pin = newPin;
        }
        else{
            throw new InvalidPinException("Invalid Pin");
        }
    }

    public int checkBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return null;
    }
}

