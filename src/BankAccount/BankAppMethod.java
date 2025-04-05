package BankAccount;

import java.math.BigDecimal;

public class BankAppMethod {
    private double balance = 0.00;
    private String pin;
    private String lastName;
    private String firstName;

    public void setPin(String number) {
        this.pin = number;
    }

    public boolean validatePin(String password) {
       if(password.equals(pin)) return true;
      return false;
    }

    public void setAccountUser(String lawal, String olabode) {
        this.lastName = lawal;
        this.firstName = olabode;
    }


    public String getAccountUser() {
        return this.lastName + " " + this.firstName ;
    }

    public double getBalance() {
        return this.balance;
    }


    public void addDeposit(double amount) {
        this.balance += amount;
    }
}
