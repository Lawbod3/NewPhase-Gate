package BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
         System.out.println("Welcome to the FirstBank");

         System.out.println("""
    Welcome Select Any of the options below.
    1. Create an Account.
    2. For existing customer.
    """);
     System.out.print("Enter your option: ");
        int option;
     while(true) {
         try {
             option = input.nextInt();
             while(option < 1 || option > 2) {
                 System.out.println("Please enter a number between 1 and 2.");
                 option = input.nextInt();
             }

         } catch (InputMismatchException e) {
             System.out.println("Please enter an integer.");
             input.nextLine();
             continue;
         }
         break;

     }

     switch(option) {
         case 1:

             break;
         case 2:
             break;
     }


    }

    public boolean validateForNumber0nlyPin(String input) {
        if(input.length()  == 4 && !input.matches("^[0-9]+")) return true;
        return false;
    }

}
