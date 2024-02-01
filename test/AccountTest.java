import chapterThree.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {


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
        public void withdrawNegativeAmountFromBalance(){
            Account praiseAccount = new Account();
            praiseAccount.setBalance(3000);
            praiseAccount.withdraw(-2000);
            assertEquals(3000, praiseAccount.getBalance());

        }

        @Test
        public void withdrawPositiveAmountFromBalance(){
        Account praiseAccount = new Account();
            praiseAccount.setBalance(3000);
            praiseAccount.withdraw(2000);
            assertEquals(1000, praiseAccount.getBalance());
        }

        @Test
        public void withdrawAmountGreaterThanBalance(){
            Account praiseAccount = new Account();
            praiseAccount.withdraw(5000);
            praiseAccount.setBalance(3000);
            assertEquals(3000, praiseAccount.getBalance());
        }


    }

