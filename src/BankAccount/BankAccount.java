package BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        ArrayList<String> passCode = new ArrayList<>();

        HashMap<String, BankAppMethod> accounts = new HashMap<>();




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
             while(true) {

                     System.out.print("Enter your firstName: ");
                     String firstName = input.nextLine();
                     while(!validateStrings(firstName)){System.out.println("Please enter only alphanumeric characters (A-Z, a-z).");
                     firstName = input.nextLine();
                     }


                     System.out.print("Enter your lastName: ");
                     String lastName = input.nextLine();
                 while(!validateStrings(lastName)) {
                     System.out.println("Please enter only alphanumeric characters (A-Z, a-z).");
                     lastName = input.nextLine();
                 }

                     System.out.print("Enter your phoneNumber: ");
                     String phoneNumber = input.nextLine();
                     while(!validatePhoneNumber(phoneNumber)) {
                         System.out.println("Please enter only numeric characters and make Sure it length is 11 (A-Z, a-z).");
                         phoneNumber = input.nextLine();
                     }
                     addUniquePhoneNumbers(phoneNumbers, phoneNumber);

                     BankAppMethod account = new BankAppMethod();


                 break;
             }



         case 2:
             break;
     }


    }

    public boolean validateForNumber0nlyPin(String input) {
        if(input.length()  == 4 && !input.matches("^[0-9]+")) return true;
        return false;
    }

    public static void addUniquePhoneNumbers(ArrayList<String> phoneNumbers, String input) {
        if(!phoneNumbers.contains(input)) phoneNumbers.add(input);
        else System.out.println("That phone number is already in use.");

    }

    public static boolean validateStrings(String input){
        if(input.matches("^[A-Za-z]+$")) return true;
        return false;
    }
    public static boolean validatePhoneNumber(String input){
        if(input.length()  == 11 && !input.matches("^[0-9]+")) return true;
        return false;
    }

}
