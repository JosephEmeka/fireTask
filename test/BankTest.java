import bankApp.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BankTest {

    @AfterEach
    public void tearDown() {
        Bank GTB = new Bank("GTB");
        GTB.getAccounts().clear();
    }

    @Test
    public void bankCanBeCreated() {
        Bank GTB = new Bank("GTB");
        assertNotNull(GTB);
    }

    @Test
    public void bankHasNoAccount() {
        Bank GTB = new Bank("GTB");
        assertEquals(0, GTB.getAccounts().size());
    }

    @Test
    public void registerAccountsInBank() {
        Bank GTB = new Bank("GTB");
        GTB.registerCustomer("john", "sam", "1001");
        assertEquals(1, GTB.getAccounts().size());
    }

    @Test

    public void registerMultipleAccounts() {
        Bank GTB = new Bank("GTB");
        GTB.registerCustomer("john", "sam", "1001");
        GTB.registerCustomer("Gab", "samuel", "1002");
        GTB.registerCustomer("joe", "sammy", "1003");
        assertEquals(3, GTB.getAccounts().size());
    }

    @Test
    public void testThatBankCannotRegisterCustomerWithInvalidPin() {
        Bank GTB = new Bank("GTB");
        GTB.registerCustomer("john", "sam", "1001");
        assertThrows(InvalidPinException.class, () -> {
                    GTB.registerCustomer("Gab", "samuel", "10023");
                }
        );
        assertThrows(InvalidPinException.class, () -> {
            GTB.registerCustomer("joe", "sammy", "100");
        });
        assertEquals(1, GTB.getAccounts().size());
    }

    @Test
    public void testAccountCanBeRemoved() {
        Bank GTB = new Bank("GTB");
        GTB.registerCustomer("john", "sam", "1001");
        GTB.registerCustomer("Gab", "samuel", "1002");
        GTB.registerCustomer("joe", "sammy", "1003");
        assertEquals(3, GTB.getAccounts().size());
        int accountNumber = GTB.getCustomerAccountNumber("john", "sam");
        GTB.removeAccount(accountNumber, "1001");
        assertEquals(2, GTB.getAccounts().size());
    }

    @Test
    public void testThatSameBankAccountCannotBeRegisteredTwice() {
        Bank Access = new Bank("Access");
        Access.registerCustomer("john", "sam", "1001");
        Access.registerCustomer("Gab", "samuel", "1002");
        Access.registerCustomer("joe", "sammy", "1003");
        assertThrows(DoubleRegistrationException.class,
                () -> {
                    Access.registerCustomer("john", "sam", "1001");
                });
        assertEquals(3, Access.getAccounts().size());

    }

    @Test
    public void testThatAccountBalanceCanBeChecked_initialBalanceIsZero() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("joshua", "mike", "1001");
        assertEquals(1, accessBank.getAccounts().size());
        int accountNumber = accessBank.getCustomerAccountNumber("joshua", "mike");
        assertEquals(0, accessBank.checkBalance(accountNumber, "1001"));
    }

    @Test
    public void testBankCanDepositPositiveAmountInAccounts() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.registerCustomer("Samuel", "Sharon", "1001");
        accessBank.deposit(accessBank.getCustomerAccountNumber("Samuel", "Sharon"),5000);
        assertEquals(5000, accessBank.checkBalance(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), "1001"));
    }


    @Test
    public void testThatBankAccountCannotWithdrawNegativeAmount() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.registerCustomer("Samuel", "Sharon", "1001");
        accessBank.deposit(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), 5000);
        assertThrows(InsufficientFundsException.class, () -> accessBank.withdraw(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), -10000, "1001"));
        assertEquals(5000, accessBank.checkBalance(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), "1001"));
    }
    @Test
    public void testThatBankAccountCannotWithdrawAmountGreaterThanBalance() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.registerCustomer("Samuel", "Sharon", "1001");
        accessBank.deposit(accessBank.getCustomerAccountNumber("Joshua", "mike"), 5000);
        assertThrows(InsufficientFundsException.class, () -> accessBank.withdraw(accessBank.getCustomerAccountNumber("Joshua", "mike"), 10000, "1001"));
        assertEquals(5000, accessBank.checkBalance(accessBank.getCustomerAccountNumber("Joshua", "mike"), "1001"));
    }
    @Test
    public void testThatBankAccountCanTransferToAnotherAccount() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.registerCustomer("Samuel", "Sharon", "1001");
        int sendingAccountNumber = accessBank.getCustomerAccountNumber("Joshua", "mike");
        int receivingAccountNumber = accessBank.getCustomerAccountNumber("Samuel", "Sharon");
        accessBank.deposit(sendingAccountNumber, 25000);
        accessBank.deposit(receivingAccountNumber, 35000);
        accessBank.transfer(sendingAccountNumber,  receivingAccountNumber, 5000, "1001");
        assertEquals(20_000, accessBank.checkBalance(sendingAccountNumber, "1001"));
        assertEquals(40_000, accessBank.checkBalance(receivingAccountNumber, "1001"));
    }
    @Test
    public void testThatBankAccountCannotTransferNegativeAmountToAnotherAccount() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.registerCustomer("Samuel", "Sharon", "1001");
        accessBank.deposit(accessBank.getCustomerAccountNumber("Joshua", "mike"), 25000);
        accessBank.deposit(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), 35000);
        assertThrows(InsufficientFundsException.class, () -> accessBank.transfer(accessBank.getCustomerAccountNumber("Joshua", "mike"), accessBank.getCustomerAccountNumber("Samuel", "Sharon"), -5000, "1001"));
        assertEquals(35000, accessBank.checkBalance(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), "1001"));
    }
    @Test
    public void testThatBankAccountCannotTransferAmountGreaterThanBalanceToAnotherAccount() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.registerCustomer("Samuel", "Sharon", "1001");
        accessBank.deposit(accessBank.getCustomerAccountNumber("Joshua", "mike"), 25000);
        accessBank.deposit(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), 35000);
        assertThrows(InsufficientFundsException.class, () -> accessBank.transfer(accessBank.getCustomerAccountNumber("Joshua", "mike"), accessBank.getCustomerAccountNumber("Samuel", "Sharon"), 50_000, "1001"));
        assertEquals(35000, accessBank.checkBalance(accessBank.getCustomerAccountNumber("Samuel", "Sharon"), "1001"));
    }

    @Test
    public void testThatBankAccountCannotTransferToSameAccount() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.deposit(accessBank.getCustomerAccountNumber("Joshua", "mike"), 25000);
        assertThrows(InvalidAccountException.class, () -> accessBank.transfer(accessBank.getCustomerAccountNumber("Joshua", "mike"), accessBank.getCustomerAccountNumber("Joshua", "mike"), 50_000, "1001"));
        assertEquals(25000, accessBank.checkBalance(accessBank.getCustomerAccountNumber("Joshua", "mike"), "1001"));
    }
    @Test
    public void testThatAccountCanBeFoundWithUniqueAccountNumber() {
        Bank accessBank = new Bank("GTB");
        accessBank.registerCustomer("Joshua", "mike", "1001");
        accessBank.registerCustomer("Samuel", "Sharon", "1001");
       assertThrows(AccountNotFoundException.class,() -> accessBank.findAccount(accessBank.getCustomerAccountNumber("Samuel", "cynthia")));

    }

}