package BankAccount;

public class AccountInfo {
    private double balance = 0.00;
    private String pin;
    private String lastName;
    private String firstName;
    private String accountNumber;


    public AccountInfo(String lastName, String firstName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = number;

    }
    public AccountInfo() {
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

    public void setAccountNumber(String phoneNumber) {
       this.accountNumber = phoneNumber;
    }

    public void transferFund(AccountInfo bank2, double amount) {
        executeWitdrawal(amount);
        bank2.addDeposit(amount);

    }
}
