import BankAccount.AccountInfo;
import BankAccount.BankDataBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBankDataBase {
    @Test
    public void testBankDataBaseIsEmpty() {
        BankDataBase data = new BankDataBase();
        assertTrue(data.isEmpty());
    }
    @Test
    public void testBankDataBaseIsNotEmpty() {
        BankDataBase data = new BankDataBase();
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNumber("07046182869");
        data.add(accountInfo);
        assertFalse(data.isEmpty());
    }
    @Test
    public void testBankDataBaseCanGetNumberOfAccounts() {
        BankDataBase data = new BankDataBase();
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNumber("07046182869");
        assertEquals(0, data.numberOfAccounts());

    }
    @Test
    public void testBankDataBaseDontTakeSameAccountNumberTwice() {
        BankDataBase data = new BankDataBase();
        AccountInfo accountInfo = new AccountInfo();
        AccountInfo accountInfo2 = new AccountInfo();
        accountInfo.setAccountNumber("07046182869");
        accountInfo2.setAccountNumber("07046182869");
        data.add(accountInfo2);
        assertThrows(IllegalArgumentException.class, () -> {data.add(accountInfo);});
    }
    @Test
    public void testBankDataBaseCanRemoveAccount() {
        BankDataBase data = new BankDataBase();
        AccountInfo accountInfo = new AccountInfo();
        AccountInfo accountInfo2 = new AccountInfo();
        accountInfo.setAccountNumber("07046182869");
        accountInfo2.setAccountNumber("07046182860");
        data.add(accountInfo);
        data.add(accountInfo2);
        data.remove(accountInfo2);
        assertEquals(1, data.numberOfAccounts());
    }
    @Test
    public void testBankDataBaseGetAccount() {
        BankDataBase data = new BankDataBase();
        AccountInfo accountInfo = new AccountInfo("Lawal", "olabode", "1234");
        AccountInfo accountInfo2 = new AccountInfo("MAJEK", "Yussuf", "000");
        accountInfo.setAccountNumber("07046182869");
        accountInfo2.setAccountNumber("07046182860");
        accountInfo.addDeposit(5000.00);
        assertEquals(5000.00, accountInfo.getBalance(), 0);
        data.add(accountInfo);
        AccountInfo personal = data.getAccount(accountInfo.getAccountNumber());
        assertEquals(personal.getBalance(), accountInfo.getBalance(), 0);






    }




}
