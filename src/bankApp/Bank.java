package bankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;


    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void registerCustomer(String firstName, String secondName, String pin) {
        Account new_account_to_be_registered = new Account(firstName, secondName, pin);
        accounts.add(new_account_to_be_registered);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public int getAccountNumber(String firstName, String lastName) {
        for (Account customerAccount : accounts) {
            if (customerAccount.getFirstName().toLowerCase().equals(firstName) && customerAccount.getLastName().toLowerCase().equals(lastName)) {
                return customerAccount.assignAccountNumber();
            }
        }
        throw new AccountNotFoundException("Account is not found");
    }


    public void removeAccount(int accountNumber, String pin) {
        accounts.removeIf(customerAccount -> customerAccount.assignAccountNumber() == accountNumber && customerAccount.validatePin(pin));
    }

    public void deposit(int amount, int accountNumber) {
        for (Account customerAccount : accounts)
            if (customerAccount.assignAccountNumber() == accountNumber) {
                if (amount <= 0) {
                    throw new InvalidAmountException("you cannot deposit negative amount");
                }
                customerAccount.deposit(amount);
                return;
            }
        throw new ValueErrorException(STR."Account \{accountNumber} not found");
    }

    public void transfer(int firstAccount, int secondAccount, int amount, String pin) {

        public void transfer(int firstAccountNumber, int secondAccountNumber, int amount, String pin) {
            for (Account customerAccount : accounts) {
                if (customerAccount.getAccountNumber() == firstAccountNumber) {
                    if (amount <= 0) {
                        throw new InvalidAmountException("You cannot send a non-positive amount");
                    } else {
                        customerAccount.withdraw(amount, pin);
                    }
                }
                if (customerAccount.getAccountNumber() == secondAccountNumber) {
                    customerAccount.deposit(amount);
                }
            }

            if (findAccount(firstAccountNumber) == null) {
                throw new AccountNotFoundException("First Account not found");
            }

            if (findAccount(secondAccountNumber) == null) {
                throw new AccountNotFoundException("Second Account not found");
            }
        }


        private Account findAccount(int accountNumber) {
            for (Account account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    return account;
                }
            }
            return null;

}