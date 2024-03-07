import bankApp.Account;
import bankApp.InsufficientFundsException;
import bankApp.InvalidAmountException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testThatAccountCanBeCreated_InitialBalanceIsPositive(){
        Account firstAccount = new Account("joshua", "Stanley", "1234");
        int expected = firstAccount.checkBalance();
        assertEquals(expected,0);
        }


        @Test
        public void depositNegativeBalance_balanceRemainsUnchanged_throwsInvalidAmountExceptionTest(){
            Account firstAccount = new Account("joshua", "Stanley", "1234");
            assertEquals(0, firstAccount.checkBalance());
            firstAccount.deposit(1_000);
            assertThrows(InvalidAmountException.class,() -> {
                firstAccount.deposit(-50000);
            });
            assertEquals(1_000, firstAccount.checkBalance());

        }

        @Test
        public void depositPositiveAmount_BalanceIncreasedTest(){
            Account firstAccount = new Account("joshua", "Stanley", "1234");
            assertEquals(0, firstAccount.getBalance());
            firstAccount.deposit(2_000);
            firstAccount.deposit(4_000);
            assertEquals(6_000, firstAccount.getBalance());
        }


    @Test
        public void withdrawNegativeAmountFromBalance_InvalidAmountException(){
        Account firstAccount = new Account("joshua", "Stanley", "1234");
            firstAccount.deposit(3000);
        assertThrows(InvalidAmountException.class,() -> {
            firstAccount.withdraw(-2000, "1234");
        });
        }

        @Test
        public void withdrawZeroAmount_InvalidAmountExceptionTest(){
            Account firstAccount = new Account("joshua", "Stanley", "1234");
            firstAccount.deposit(3000);
            assertThrows(InvalidAmountException.class,() -> {
                firstAccount.withdraw(0, "1234");
            });
        }

        @Test
        public void withdrawPositiveAmountFromBalance(){
            Account firstAccount = new Account("Esther", "Stanley", "1234");
            assertEquals(0, firstAccount.getBalance());
            firstAccount.deposit(30000);
            assertEquals(30000, firstAccount.getBalance());
            firstAccount.withdraw(1000,"1234");
            assertEquals(29000, firstAccount.getBalance());
        }

        @Test
        public void withdrawAmountGreaterThanBalance(){
            Account firstAccount = new Account("joshua", "Stanley", "1234");
            firstAccount.deposit(3000);
            assertThrows(InvalidAmountException.class,() -> {
                firstAccount.withdraw(5000, "1234");
            });
        }

        @Test
        public void testThatDefaultPinCanBeChanged(){
            Account firstAccount = new Account("joshua", "Stanley", "1234");
            assertTrue(firstAccount.validatePin("1234"));
            firstAccount.changePin("1234", "1235");
            assertTrue(firstAccount.validatePin("1235"));
        }


        @Test
        public void testThatBalanceCanBeChecked_ValidatePinFirst(){
            Account firstAccount = new Account("joshua", "Stanley", "1234");
            assertTrue(firstAccount.validatePin("1234"));
            String newPin = firstAccount.changePin("1234", "1235");
            assertTrue(firstAccount.validatePin("1235"));
            firstAccount.deposit(60_000);
            firstAccount.withdraw(25_000,"1235");
            assertEquals(35_000, firstAccount.checkBalance());
        }


    }

