import BankAccount.BankAppMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBankApp {
    BankAppMethod bankApp = new BankAppMethod();

    @Test
    public void testSetPin() {
          bankApp.setPin("1234");
    }
    @Test
    public void testValidatePin() {
        bankApp.setPin("1234");
        String password = "1234";
        assertTrue(bankApp.validatePin(password));
    }
    @Test
    public void testAddAccount() {
        bankApp.setAccountUser("Lawal","Olabode");
    }
    @Test
    public void testGetAccountUser() {
        bankApp.setAccountUser("Lawal","Olabode");
        assertEquals("Lawal Olabode", bankApp.getAccountUser());
    }
    @Test
    public void testGetBalance() {
        double expected = 0.00;
        assertEquals(expected, bankApp.getBalance(), 0.00);
    }
    @Test
    public void testAddDeposit() {
        bankApp.addDeposit(500.00);
        bankApp.addDeposit(1000.00);
        assertEquals(1500.00, bankApp.getBalance(), 0.00);


    }





}

