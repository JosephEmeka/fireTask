import bankApp.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {


        @Test

        public void testThatAccountCanBeCreated_InitialBalanceIsPositive(){


        }

        @Test
        public void testThatValidPinCanBeCreatedForAccount(){

        }


        @Test
        public void testThatPinIsValid(){


        }
        @Test
        public void depositNegativeBalance_balanceRemainsUnchangedTest(){

            Account praiseAccount = new Account();
            assertEquals(0, praiseAccount.getBalance());

            praiseAccount.deposit(-50000);
            assertEquals(0, praiseAccount.getBalance());


        }

        @Test
        public void depositPositiveAmount_BalanceIncreasedTest(){

            Account praiseAccount = new Account();
            assertEquals(0, praiseAccount.getBalance());

            praiseAccount.deposit(2_000);
            praiseAccount.deposit(4_000);
            assertEquals(6_000, praiseAccount.getBalance());

        }


    @Test
        public void withdrawNegativeAmountFromBalance_InvalidAmountException(){
            Account praiseAccount = new Account();
            praiseAccount.setBalance(3000);
            praiseAccount.withdraw(-2000, "1212887656");
            assertEquals(3000, praiseAccount.getBalance());

        }

        @Test
        public void withdrawFractionalAmount_InvalidAmountExceptionTest(){



        }

        @Test
        public void withdrawPositiveAmountFromBalance(){
        Account praiseAccount = new Account();
            praiseAccount.setBalance(3000);
            praiseAccount.withdraw(2000,"2183946752");
            assertEquals(1000, praiseAccount.getBalance());
        }

        @Test
        public void withdrawAmountGreaterThanBalance(){
            Account praiseAccount = new Account();
            praiseAccount.withdraw(5000, "1239083765");
            praiseAccount.setBalance(3000);
            assertEquals(3000, praiseAccount.getBalance());
        }

        @Test
        public void validatePinBeforeTransaction(){


        }

        @Test
        public void testThatBalanceCanBeChecked_ValidatePinFirst(){


        }


    }

