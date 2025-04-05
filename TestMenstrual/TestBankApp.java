import BankAccount.BankAppMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBankApp {
    BankAppMethod bankApp = new BankAppMethod();

    @Test
    public void testGetBalance() {
        assertEquals(bankApp.getBalance());



    }
}
