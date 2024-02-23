import bankApp.Account;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankTest {
    @Test
    public void testThatAccountCanBeAddedToListOfAccount(){
        Account myAccount = new Account("joshua", "1452367895", 0);
        Account secondAccount = new Account("joshua", "1452367895", 0);
        Account thirdAccount = new Account("joshua", "1452367895", 0);
        List<Account> accountList = new ArrayList<>();
        accountList.registerCustomer("joshua", "1452367895", );
        accountList.registerCustomer(secondAccount);
        accountList.registerCustomer(thirdAccount);
        assertEquals(3, accountList.size());
    }


    @Test
    public void testThatAccountCanBeRemovedFromListOfAccount(){
        Account myAccount = new Account("joshua", "1452367895", 0);
        Account secondAccount = new Account("joshua", "1452367895", 0);
        Account thirdAccount = new Account("joshua", "1452367895", 0);
        List<Account> accountList = new ArrayList<>();
        accountList.registerCustomer(myAccount);
        accountList.registerCustomer(secondAccount);
        accountList.registerCustomer(thirdAccount);
        accountList.removeAccount(myAccount);
        assertEquals(2, accountList.size());
    }

    @Test
    public void depositPositiveAmountInSpecificAccountNumber_BalanceIncreases(){


    }


    @Test
    public void depositNegativeAmountInSpecificAccountNumber_BalanceRemainsTheSame_InvalidAmountException(){


    }

    @Test
    public void transferNegativeAmountInSpecificAccountNumber_BalanceRemainsTheSame_InvalidAmountException(){


    }
    @Test
    public void transferPositiveAmountInSpecificAccountNumber_BalanceIncreases(){


    }
    @Test
    public void checkThatTransferredAmountIsDepositedInRecipientAccount_RecipientBalanceIncreases(){


    }
    @Test
    public void removeAccountFromAccountList_AccountIsRemoved(){


    }
    @Test

    public void registerCustomer_CustomerIsRegistered_ListOfCustomersIncreases(){


    }

    @Test

    public void findAccountFromListOfAccount_AccountCanBeFound(){



    }

}
