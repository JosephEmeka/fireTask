import bankApp.Account;
import bankApp.InsufficientFundsException;
import bankApp.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {


        @Test
        public void testThatAccountCanBeCreated_InitialBalanceIsPositive(){
            Account firstAccount = new Account("joshua", "1452367895", 0 );
            int expected = firstAccount.checkBalance();
            assertEquals(expected,0);
        }

        @Test
        public void testThatAccountCanBeCreated_NegativeBalanceThrowsIllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () -> {
                Account firstAccount = new Account("joshua", "1452367895", -1 );
            }
            );
    }



        @Test
        public void depositNegativeBalance_balanceRemainsUnchanged_throwsInvalidAmountExceptionTest(){

            Account firstAccount = new Account("joshua", "1452367895", 1000 );
            assertEquals(1000, firstAccount.checkBalance());
            assertThrows(InvalidAmountException.class,() -> {
                firstAccount.deposit(-50000);
            });


        }

        @Test
        public void depositPositiveAmount_BalanceIncreasedTest(){
            Account FirstAccount = new Account("joshua", "1452367895", 0);
            assertEquals(0, FirstAccount.getBalance());
            FirstAccount.deposit(2_000);
            FirstAccount.deposit(4_000);
            assertEquals(6_000, FirstAccount.getBalance());
        }


    @Test
        public void withdrawNegativeAmountFromBalance_InvalidAmountException(){
            Account firstAccount = new Account("joshua", "1452367895", 0);
            firstAccount.deposit(3000);
        assertThrows(InvalidAmountException.class,() -> {
            firstAccount.withdraw(-2000, "1212887656");
        });
        }

        @Test
        public void withdrawZeroAmount_InvalidAmountExceptionTest(){
            Account firstAccount = new Account("joshua", "1452367895", 0);
            firstAccount.deposit(3000);
            assertThrows(InvalidAmountException.class,() -> {
                firstAccount.withdraw(0, "1212887656");
            });


        }

        @Test
        public void withdrawPositiveAmountFromBalance(){
        Account firstAccount = new Account("joshua", "1452367895", 0);
            firstAccount.deposit(3000);
            firstAccount.withdraw(2000,"2183946752");
            assertEquals(1000, firstAccount.getBalance());
        }

        @Test
        public void withdrawAmountGreaterThanBalance(){
            Account firstAccount = new Account("joshua", "1452367895", 0);
            firstAccount.deposit(3000);
            assertThrows(InsufficientFundsException.class,() -> {
                firstAccount.withdraw(5000, "1239083765");
            });
        }

        @Test
        public void testThatDefaultPinCanBeChanged(){
            Account firstAccount = new Account("joshua", "1452367895", 0);
            assertEquals("0000",firstAccount.getDefaultPin());
            String newPin = firstAccount.changePin("0000", "1234");
            assertEquals("1234",firstAccount.getDefaultPin());
        }

    @Test
    public void testThatPinHasValidLength(){
        Account firstAccount = new Account("joshua", "1452367895", 0);
        assertEquals("0000",firstAccount.getDefaultPin());
        String newPin = firstAccount.changePin("0000", "1234");
        assertEquals("1234",firstAccount.getDefaultPin());
        assertEquals(4,newPin.length());

    }
        @Test
        public void testThatBalanceCanBeChecked_ValidatePinFirst(){
            Account firstAccount = new Account("joshua", "1452367895", 0);
            assertEquals("0000",firstAccount.getDefaultPin());
            String newPin = firstAccount.changePin("0000", "1234");
            assertEquals("1234",firstAccount.getDefaultPin());
            assertEquals(4,newPin.length());
            firstAccount.deposit(60_000);
            firstAccount.withdraw(25_000,"2183946752");
            assertEquals(35_000, firstAccount.checkBalance());
        }


    }

