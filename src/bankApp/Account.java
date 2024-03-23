package bankApp;


public class Account {
    private String firstName;
    private String lastName;
    private int balance;
    private String pin;
    private int accountNumber;


    public Account(String firstName, String lastName, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0;
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }


    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(STR."Invalid amount: \{amount}");
        }
        balance += amount;

    }

    public void withdraw(int amount, String pin) {
        if (amount > 0 && amount <= balance && validatePin(pin)) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Invalid amount ");
        }
    }

    public boolean validatePin(String enteredPin) {
        if (enteredPin.length() != 4) {
            throw new IllegalArgumentException("pin must be four digits long");
        }
        return enteredPin.equals(String.valueOf(this.pin));

    }


    public String changePin(String myOldPin, String newPin) {
        if (validatePin(myOldPin)) {
            return this.pin = newPin;
        } else {
            throw new InvalidPinException("Invalid Pin");
        }
    }

    public int checkBalance() {

            return balance;

    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}

