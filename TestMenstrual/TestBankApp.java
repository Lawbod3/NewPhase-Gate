import BankAccount.AccountInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBankApp {
    AccountInfo AccountInfo = new AccountInfo();

    @Test
    public void testSetPin() {
          AccountInfo.setPin("1234");
    }
    @Test
    public void testValidatePin() {
        AccountInfo.setPin("1234");
        String password = "1234";
        assertTrue(AccountInfo.validatePin(password));
    }
    @Test
    public void testAddAccount() {
        AccountInfo.setAccountUser("Lawal","Olabode");
    }
    @Test
    public void testGetAccountUser() {
        AccountInfo.setAccountUser("Lawal","Olabode");
        assertEquals("Lawal Olabode", AccountInfo.getAccountUser());
    }
    @Test
    public void testGetBalance() {
        double expected = 0.00;
        assertEquals(expected, AccountInfo.getBalance(), 0.00);
    }
    @Test
    public void testAddDeposit() {
        AccountInfo.addDeposit(500.00);
        AccountInfo.addDeposit(1000.00);
        assertEquals(1500.00, AccountInfo.getBalance(), 0.00);
    }
    @Test
    public void testExecuteWithdraw() {
        AccountInfo.addDeposit(500.00);
        AccountInfo.executeWitdrawal(200.00);
        assertEquals(300.00, AccountInfo.getBalance(), 0.00);
    }
    @Test
    public void testDontExecuteWithdrawAboveBalance() {
        AccountInfo.addDeposit(500.00);
        assertThrows(IllegalArgumentException.class, () -> AccountInfo.executeWitdrawal(700.00));
    }
    @Test
    public void testExecuteWithdrawAboveBalance() {
        AccountInfo.addDeposit(500.00);
        assertThrows(IllegalArgumentException.class, () -> AccountInfo.executeWitdrawal(700.00));
        assertEquals(500.00, AccountInfo.getBalance(), 0.00);
    }
    @Test
    public void testToChangePin() {
        AccountInfo.setPin("1234");
        String password = "1234";
        assertTrue(AccountInfo.validatePin(password));
        AccountInfo.changePin("2222");
        assertFalse(AccountInfo.validatePin(password));
        assertTrue(AccountInfo.validatePin("2222"));
    }

    @Test
    public void testGetAccountNumberCounterIsStatic() {
        AccountInfo bank = new AccountInfo();
        bank.setAccountNumber("0000001013");
        assertEquals("0000001013",bank.getAccountNumber());
    }
    @Test
    public void testAddConstructor() {
        AccountInfo bank1 = new AccountInfo("Lawal", "Bode", "5666");
        bank1.setAccountNumber("0000001011");
        assertEquals("0000001011", bank1.getAccountNumber());
    }
    @Test
    public void testTransfer() {
        AccountInfo bank1 = new AccountInfo("Lawal", "Bode", "5666");
        AccountInfo bank2 = new AccountInfo("Lawal", "Bode", "5666");
        bank1.addDeposit(500.00);
        double amount = 200;
        bank1.transferFund(bank2, amount);
        assertEquals(amount, bank2.getBalance(), 0.00);
    }





}

