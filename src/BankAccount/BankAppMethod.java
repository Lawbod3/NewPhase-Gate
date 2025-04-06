package BankAccount;

import java.math.BigDecimal;
import java.util.HashMap;

public class BankAppMethod {
    private double balance = 0.00;
    private String pin;
    private String lastName;
    private String firstName;
    private String accountNumber;
    private static int accountNumberCounter = 999;

    private static HashMap<String, BankAppMethod> accounts = new HashMap<>();




    public BankAppMethod(String lastName, String firstName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = number;
        this.accountNumber = setAccountNumber();

    }
    public BankAppMethod() {
        this.accountNumber = setAccountNumber();
    }

    public void setPin(String number) {
        this.pin = number;
    }

    public boolean validatePin(String password) {
       if(password.equals(pin)) return true;
      return false;
    }

    public void setAccountUser(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
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

    public void executeWitdrawal(double amount) {
        if(amount > this.balance) throw new IllegalArgumentException("Not enough Balance for this operation");
        this.balance -= amount;
    }

    public void changePin(String number) {
        this.pin = number;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    private static String setAccountNumber(){
        int number = accountNumberCounter++;
       return String.format( "000000%d", number);
    }
}
