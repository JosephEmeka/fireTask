import bankApp.Account;
import bankApp.Bank;
import bankApp.InvalidAmountException;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.AccountNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BankTest {
        @Test
        public void bankHasNoAccount(){
            Bank GTB = new Bank("GTB");
            assertEquals(0, GTB.getAccounts().size());

        }
        @Test
        public void testThatCustomerCanBeRegistered() {
            Bank GTB = new Bank("GTB");
            GTB.registerCustomer("Joshua", "Okeme", "1001");
            GTB.registerCustomer("John", "Favour", "1234");
            assertEquals(2, GTB.getAccounts().size());
        }


        @Test
        public void testThatAccountCanBeRemovedFromListOfAccount() throws AccountNotFoundException {
            Bank Access = new Bank("Access");
            Access.registerCustomer("Joshua", "Okeme", "1001");
            Access.registerCustomer("John", "Favour", "1234");
            Access.registerCustomer("Patric", "Ruth", "1235");
            assertEquals(3, Access.getAccounts().size());
            int accountNumber = Access.getAccountNumber("Joshua", "Okeme");
            Access.removeAccount(accountNumber, "1001");
            assertEquals(2, Access.getAccounts().size());

        }




        @Test
        public void depositPositiveAmountInSpecificAccountNumber_BalanceIncreases(){
            Bank Access = new Bank("Access");
            Account firstAccount = new Account("joshua", "Stanley", "1001");
            Access.registerCustomer("joshua", "Okeme", "1001");
            Access.deposit(4_000, firstAccount.assignAccountNumber());

        }


        @Test
        public void depositNegativeAmountInSpecificAccountNumber_BalanceRemainsTheSame_InvalidAmountException() {
            Bank Access = new Bank("Access");
            Account firstAccount = new Account("joshua", "Stanley", "1001");
            Access.registerCustomer("joshua", "Okeme", "1001");
            assertThrows(InvalidAmountException.class,() -> {
                Access.deposit(-4_000, firstAccount.assignAccountNumber());
            });

        }

        @Test
        public void transferNegativeAmountInSpecificAccountNumber_BalanceRemainsTheSame_InvalidAmountException() {
            Bank Access = new Bank("Access");
            Account firstAccount = new Account("joshua", "Stanley", "1001");
            Account secondAccount = new Account("Sam", "junior", "1031");
            Access.transfer(firstAccount.assignAccountNumber(), secondAccount.assignAccountNumber(),-5_000, "1001");

        }

        @Test
        public void transferPositiveAmountInSpecificAccountNumber_BalanceIncreases() {
            Bank Access = new Bank("Access");
            Account firstAccount = new Account("joshua", "Stanley", "1001");
            Account secondAccount = new Account("Sam", "junior", "1031");
            firstAccount.deposit(20_000);
            Access.transfer(firstAccount.assignAccountNumber(), secondAccount.assignAccountNumber(),5_000, "1001");
            assertEquals(0, secondAccount.getBalance());
        }
        @Test
        public void checkThatTransferredAmountIsDepositedInRecipientAccount_RecipientBalanceIncreases() {


        }
        @Test
        public void removeAccountFromAccountList_AccountIsRemoved() {


        }
        @Test

        public void registerCustomer_CustomerIsRegistered_ListOfCustomersIncreases() {


        }

        @Test

        public void findAccountFromListOfAccount_AccountCanBeFound() {


        }

    }

