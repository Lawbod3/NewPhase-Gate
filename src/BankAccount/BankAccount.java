package BankAccount;

public class BankAccount {
    public static void main(String[] args) {




    }

    public boolean validateForNumber0nlyPin(String input) {
        if(input.length()  == 4 && !input.matches("^[0-9]+")) return true;
        return false;
    }

}
