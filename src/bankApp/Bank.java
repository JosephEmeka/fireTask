package bankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;
    private static int registeredAccountNumbering = 1;
    private static int accountNumber = 1000;



    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void registerCustomer(String firstName, String lastName, String pin) {
        Account freshAccount = new Account(firstName, lastName, pin);
        for (Account accountItem : accounts) {
            if (accountItem.getFirstName().equalsIgnoreCase(firstName) && accountItem.getLastName().equalsIgnoreCase(lastName)) {
                throw new DoubleRegistrationException(STR."Account \{accountItem.getAccountNumber()} already exists");
            }
        }

        validatePin(pin);
        freshAccount.setAccountNumber(accountNumber);
        accounts.add(freshAccount);
        accountNumber += registeredAccountNumbering;
        freshAccount.setAccountNumber(accountNumber);
    }


    public void validatePin(String pin){
        if (pin.length() != 4){
            throw new InvalidPinException("Pin must be four digits");
        }
    }

    public void removeAccount(int accountNumber, String pin) {
        validatePin(pin);
        for(Account customerAccount: accounts)
            if(customerAccount.getAccountNumber()== accountNumber && customerAccount.validatePin(pin))
                accounts.remove( findAccount(accountNumber));
        }


    public int getCustomerAccountNumber(String firstName, String lastName) {
        for(Account customerAccount: accounts)
            if(customerAccount.getFirstName().equalsIgnoreCase(firstName) && customerAccount.getLastName().equalsIgnoreCase(lastName))
                return customerAccount.getAccountNumber();
        return 0;
    }

    public String getBankName(){
        return name;
    }


    public int checkBalance(int accountNumber, String pin) {
        validatePin(pin);
        for (Account customerAccount : accounts)
            if (customerAccount.getAccountNumber() == accountNumber)
                return customerAccount.checkBalance();
        throw new AccountNotFoundException("Account was not found");
    }

    public void deposit(int accountNumber, int amount) {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        validatePin(pin);
        findAccount(accountNumber).withdraw(amount, pin);
    }

    public Account findAccount(int accountNumber) {
        Account foundAccount = null;
        for (Account customerAccount : accounts) {
            if (customerAccount.getAccountNumber() == accountNumber) {
                foundAccount = customerAccount;
                break;
            }
        }

        if (foundAccount == null) {
            throw new AccountNotFoundException("Cannot find account number");
        }
        return foundAccount;
    }

    public void transfer(int sendingAccountNumber, int receivingAccountNumber, int amount, String pin) {
        validatePin(pin);
        if(findAccount(sendingAccountNumber) == findAccount(receivingAccountNumber))
            throw new InvalidAccountException("Invalid Account");
        findAccount(sendingAccountNumber).withdraw(amount, pin);
        findAccount(receivingAccountNumber).deposit(amount);
    }
}