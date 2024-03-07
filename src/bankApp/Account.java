package bankApp;


public class Account {

    private String firstName;

    private String lastName;

    private int balance;


    private String pin;

    private int accountNumber = 0;


    private int numberOfAccount = 0;


    public Account (String firstName, String lastName, String pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber += 1;
        this.balance = 0;
        this.pin = pin;

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

    public void withdraw(int amount, String pin) {
        if (amount > 0 && amount <= balance && validatePin(pin)) {
            balance -= amount;
        }
        else {
            throw new InvalidAmountException("Invalid withdrawal amount or incorrect PIN");
        }
    }

        public boolean validatePin(String enteredPin) {
            if (enteredPin.length() != 4) {
                throw new IllegalArgumentException("pin must be four digits long");
            }
            return enteredPin.equals(String.valueOf(this.pin));

        }



    private String getPin() {
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

    public int assignAccountNumber() {
       return accountNumber;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

