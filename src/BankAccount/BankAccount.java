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
        boolean done = false;
        System.out.println("Welcome to the FirstBank");
        while (!done) {
            System.out.println("""
                    \nSelect Any of the options below.
                    1. Create an Account.
                    2. For existing customer.
                    3. Exit the program.
                    """);
            System.out.print("Enter your option: ");
            int option;
            while (true) {
                try {
                    option = input.nextInt();
                    while (option < 1 || option > 3) {
                        System.out.println("Please enter a number between 1 and 2.");
                        option = input.nextInt();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer.");
                    input.nextLine();
                    continue;
                }
                input.nextLine();
                break;

            }

            switch (option) {
                case 1:
                    while (true) {

                        System.out.print("Enter your firstName: ");
                        String firstName = input.nextLine();
                        while (!validateStrings(firstName)) {
                            System.out.println("Please enter only alphanumeric characters (A-Z, a-z).");
                            firstName = input.nextLine();
                        }


                        System.out.print("Enter your lastName: ");
                        String lastName = input.nextLine();
                        while (!validateStrings(lastName)) {
                            System.out.println("Please enter only alphanumeric characters (A-Z, a-z).");
                            lastName = input.nextLine();
                        }

                        System.out.print("Enter your phoneNumber: ");
                        String phoneNumber = input.nextLine();
                        while (!validatePhoneNumber(phoneNumber)) {
                            System.out.println("Please enter only numeric characters and make Sure it length is 11 (0-9): ");
                            phoneNumber = input.nextLine();
                        }
                        addUniquePhoneNumbers(phoneNumbers, phoneNumber);
                        String confirmPin;
                        while (true) {
                            System.out.print("Enter set Account PIN, Make sure it contains only digit and it should four digits. e.g(0123): ");
                            String pin = input.nextLine();
                            while (!validateForNumber0nlyPin(pin)) {
                                System.out.println("Please enter only numeric characters and make Sure it length is 4 (0-9).");
                                pin = input.nextLine();
                            }

                            System.out.print("Enter confirm account PIN: ");
                            confirmPin = input.nextLine();
                            while (!validateForNumber0nlyPin(pin)) {
                                System.out.println("Please enter only numeric characters and make Sure it length is 4 (0-9).");
                                confirmPin = input.nextLine();
                            }
                            if (pin.equals(confirmPin)){
                                passCode.add(confirmPin);
                            break;
                            }
                            else {
                                System.out.println("Pin does not match. Please try again.");
                                continue;
                            }

                        }


                        BankAppMethod account = new BankAppMethod(lastName, firstName, confirmPin);
                        accounts.put(phoneNumber, account);

                        System.out.println("Account created Successfully");


                        break;
                    }


                case 2:
                    boolean login = false;
                    while (!login) {
                        System.out.print("""
                         
                         1.Login your account.
                         2.Go back to Main menu. 
                        
                             """);
                        System.out.print("Enter your option: ");
                        int loginOption;
                        while (true) {
                            try {
                                loginOption = input.nextInt();
                                while (loginOption < 1 || loginOption > 2) {
                                    System.out.println("Please enter a number between 1 and 2.");
                                    loginOption = input.nextInt();
                                }
                            }catch (InputMismatchException e) {
                                System.out.println("Please enter an integer.");
                                input.nextLine();
                                continue;
                            }
                            input.nextLine();
                            break;
                        }
                        if(loginOption == 1) {
                            System.out.print("Enter your phoneNumber to login: ");
                            String phoneNumberLogins = input.nextLine();
                            while (!validatePhoneNumber(phoneNumberLogins)) {
                                System.out.println("Please enter only numeric characters (0-9), make Sure it length is 11 : ");
                                phoneNumberLogins = input.nextLine();
                            }
                            if (!phoneNumbers.contains(phoneNumberLogins)){
                                System.out.println("Phone number does not exist. Please try again.");
                                continue;
                            }
                            String loginPin;

                                System.out.print("Enter your account PIN: ");
                                 loginPin = input.nextLine();
                                while (!validateForNumber0nlyPin(loginPin)) {
                                    System.out.println("Please enter only numeric characters and make Sure it length is 4 (0-9).");
                                    loginPin = input.nextLine();
                                }


                            int index = phoneNumbers.indexOf(phoneNumberLogins);
                            String value = passCode.get(index);
                            if(!value.equals(loginPin)){
                                System.out.println("PhoneNumber does  not match pin. Please try again.");
                                break;

                            }
                            System.out.print("Successfully logged in.");
                            accounts.get(phoneNumberLogins);

                            System.out.print("""
                                    Select the operation you would like to carry out.
                                    1. Close account.
                                    2. Deposit money.
                                    3. Withdraw money.
                                    4. Check Account balance
                                    5. Transfer from one account to another.
                                    6.Change Pin.
                                    7.Go back to Main menu.
                                    """);
                                  System.out.print("Enter your option: ");
                                  int operation = input.nextInt();



                        }
                        else if(loginOption == 2) {
                            System.out.println("Go back to Main menu. ");
                            login = true;
                        }

                    }

                    break;
                case 3:
                    done = true;
                    break;
            }


        }
    }



    public static boolean validateForNumber0nlyPin(String input) {
        if(input.length()  == 4 && input.matches("^[0-9]+$")) return true;
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
        if(input.length()  == 11 && input.matches("^[0-9]+$")) return true;
        return false;
    }

}
