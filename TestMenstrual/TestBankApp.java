import BankAccount.BankAppMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBankApp {
    BankAppMethod bankApp = new BankAppMethod();

    @Test
    public void testGetBalance() {
         bankApp.setPin("1234");
        assertTrue(bankApp.validatePin("1234"));
    }

}

