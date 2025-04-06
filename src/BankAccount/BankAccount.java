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
                        if(phoneNumbers.contains(phoneNumber)){
                            System.out.println("That phone number is already in use.");
                            break;}
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

                        System.out.println("Account created Successfully>>>>>>>>>>>>.");

                        break;
                    }

                case 2:
                    boolean login = false;
                    int loginOption;
                    while (!login) {
                        System.out.print("""
                         
                         1.Login your account.
                         2.Go back to Main menu. 
                         3.Exit the program.
                        
                             """);
                        System.out.print("Enter your option: ");

                        while (true) {
                            try {
                                loginOption = input.nextInt();
                                while (loginOption < 1 || loginOption > 3) {
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
                            System.out.println("Successfully logged in.>>>>>>>>>>>>>>");
                            accounts.get(phoneNumberLogins);

                            boolean exitOperation = false;
                            int operation;
                            while (!exitOperation) {
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
                                try {
                                    operation = input.nextInt();
                                    while (operation < 1 || operation > 7) {
                                        System.out.println("Please enter a number between 1 and 7.");
                                        operation = input.nextInt();
                                    }
                                }catch(InputMismatchException e) {
                                    System.out.println("Please enter only numeric character (1-7).");
                                    input.nextLine();
                                    continue;
                                }
                                switch (operation) {
                                    case 1:
                                        boolean close = false;
                                        while (!close) {
                                            System.out.print(""" 
                                                    Are you sure you want to Close your Account with us? (Y/N): 
                                                    1.Yes.
                                                    2.No.
                                                    """);
                                            System.out.print("Enter your option: ");
                                            int closeOption = input.nextInt();
                                            while (closeOption < 1 || closeOption > 2) {
                                                System.out.println("Please enter only numeric character (1-2).");
                                                closeOption = input.nextInt();
                                            }

                                            if (closeOption == 1) {
                                                BankAppMethod closeAccount = accounts.get(phoneNumberLogins);
                                                input.nextLine();
                                                System.out.println("!!!! Your account can only be closed when empty !!!!");
                                                System.out.println("Input your account PIN: ");
                                                String closePin = input.nextLine();
                                                while (!validateForNumber0nlyPin(closePin)) {
                                                    System.out.println("Please enter only numeric characters and make Sure it length is 4 (0-9).");
                                                    closePin = input.nextLine();
                                                }

                                                if(closeAccount.getBalance() > 0.00 ||  (!closeAccount.validatePin(closePin))){
                                                    System.out.println("Your account balance is greater than 0.00, Account can only be close when empty");
                                                    close = true;
                                                }
                                               else{
                                                   accounts.remove(phoneNumberLogins);
                                                   phoneNumbers.remove(phoneNumberLogins);
                                                   passCode.remove(closePin);
                                                   System.out.println("Your account has been closed.");
                                                   exitOperation = true;
                                                   close = true;

                                               }

                                            }
                                            else {
                                                close = true;
                                            }

                                        }

                                        break;
                                    case 2:

                                        System.out.println("Deposit limit through ATM is #2,147,483,646 maximum limit and #50 minimum limit : ");
                                        boolean limit = false;
                                        int depositAmount;
                                        while(!limit) {
                                            System.out.print("Enter the amount of your deposit: ");
                                            try {
                                                depositAmount = input.nextInt();
                                                while(depositAmount < 50 || depositAmount > 2147483646) {
                                                    System.out.println("your deposit amount does not go with the limit .");
                                                    limit = true;
                                                    break;
                                                }
                                            }
                                            catch(InputMismatchException e) {
                                                System.out.println("Please enter only numeric character (1-7).");
                                                input.nextLine();
                                                continue;
                                            }
                                            BankAppMethod account = accounts.get(phoneNumberLogins);
                                            account.addDeposit(depositAmount);

                                            System.out.printf("Your deposit of #%d is Successfully added to your Account>>>>>>>%n", depositAmount);

                                            break;
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Withdrawal limit through ATM is #500,000 maximum limit and #50 minimum limit : ");
                                        boolean exitWithdrawal = false;
                                        int withdrawAmount;
                                        while(!exitWithdrawal) {
                                            System.out.print("Enter the amount of your withdrawal: ");
                                            try {
                                                withdrawAmount = input.nextInt();
                                                while (withdrawAmount < 50 || withdrawAmount > 500000) {
                                                    System.out.println("your withdrawal amount does not go with the limit .");
                                                    exitWithdrawal = true;
                                                    break;
                                                }

                                            }catch(InputMismatchException e) {
                                                System.out.println("Your withdrawal amount does not go with the limit .");
                                                input.nextLine();
                                                continue;
                                            }
                                            BankAppMethod account = accounts.get(phoneNumberLogins);
                                            if(withdrawAmount > account.getBalance()) {
                                                System.out.println("Insufficient balance.");
                                                exitWithdrawal = true;
                                            }
                                            else {
                                                account.executeWitdrawal(withdrawAmount);
                                                System.out.printf("Your withdraw of #%d is Successfully deducted from your Account>>>>>>>%n", withdrawAmount);

                                            }

                                            break;
                                        }

                                        break;
                                    case 4:
                                        BankAppMethod account = accounts.get(phoneNumberLogins);
                                        System.out.printf("Your account balance is: #%.2f%n", account.getBalance());

                                        break;
                                    case 5:
                                        input.nextLine();
                                        BankAppMethod transferAccount = accounts.get(phoneNumberLogins);
                                        String receiverNumber;
                                        boolean transfer = false;
                                        while(!transfer) {
                                            System.out.print("!!! Transfer Limit is #500000 !!!!!");
                                            System.out.println("Enter beneficiary Account number or phoneNumber: ");
                                            receiverNumber = input.nextLine();
                                            while (!validatePhoneNumber(receiverNumber)) {
                                                System.out.println("Please enter only numeric characters and make Sure it length is 11 (0-9): ");
                                                receiverNumber = input.nextLine();
                                            }
                                            if (!phoneNumbers.contains(receiverNumber)) {
                                                System.out.println("Beneficiary Account number does not exist.");
                                                transfer = true;
                                            }
                                            System.out.println("Enter the amount you to transfer: ");
                                            double amount = input.nextDouble();
                                            while((amount < 0) || (amount > 500000)) {
                                                System.out.println("Kindly re-enter, Your transfer amount does not go with the limit: ");
                                                 amount = input.nextDouble();
                                            }
                                            int transferIndex = phoneNumbers.indexOf(phoneNumberLogins);
                                            String transferValue = passCode.get(transferIndex);


                                            System.out.println("Enter your pin to confirm your transfer : ");
                                            input.nextLine();
                                            String transferPin = input.nextLine();
                                            if(!transferValue.equals(transferPin)) {
                                                System.out.println("Wrong Pin. Try again ONE more time");
                                            }
                                            System.out.println("Enter your pin to confirm your transfer : ");
                                             transferPin = input.nextLine();
                                            if(!transferValue.equals(transferPin)) {
                                                System.out.println("Wrong Pin. Exiting");
                                                exitOperation = true;
                                                transfer = true;

                                            }



                                            if(amount > transferAccount.getBalance()) {
                                                System.out.println("Insufficient balance.");
                                                transfer = true;
                                            }
                                            else {
                                                BankAppMethod receiver = accounts.get(receiverNumber);
                                                transferAccount.transferFund(receiver, amount);
                                                System.out.printf("You have successfully transferred %.2f  to %s.", amount, receiver.getAccountUser());
                                                System.out.println("Transfer successfully>>>>>>>>>.");
                                                transfer = true;
                                            }


                                        }
                                        break;
                                    case 6:
                                        input.nextLine();
                                        BankAppMethod accountChangePin = accounts.get(phoneNumberLogins);
                                        boolean exitPin = false;
                                        String changePin;
                                        while(!exitPin) {
                                            System.out.println("Enter your Current account PIN: ");
                                            String currentPin = input.nextLine();
                                            while (!validateForNumber0nlyPin(currentPin)) {
                                                System.out.println("Please enter only numeric characters and make Sure it length is 4 (0-9).");
                                                currentPin = input.nextLine();

                                            }
                                            int indexCurrentPin = phoneNumbers.indexOf(phoneNumberLogins);
                                            String valueOfCurrentPin = passCode.get(indexCurrentPin);

                                            if(!valueOfCurrentPin.equals(currentPin)) {
                                                System.out.println("Wrong PIN");
                                                break;

                                            }
                                            System.out.println("Enter your new account PIN: ");
                                            changePin = input.nextLine();
                                            while(!validateForNumber0nlyPin(changePin)) {
                                                System.out.println("Please enter only numeric characters and make Sure it length is 4 (0-9).");
                                                changePin = input.nextLine();
                                            }
                                            System.out.println("Confirm your new account PIN: ");
                                            String confirmPin = input.nextLine();
                                            while (!validateForNumber0nlyPin(confirmPin)) {
                                                System.out.println("Please enter only numeric characters and make Sure it length is 4 (0-9).");
                                                confirmPin = input.nextLine();
                                            }
                                            if(!confirmPin.equals(changePin)) {
                                                System.out.println("PIN Does not match....going back to Main menu");
                                                exitPin = true;
                                            }
                                            else {
                                                passCode.set(indexCurrentPin, confirmPin);
                                                accountChangePin.changePin(confirmPin);
                                                System.out.println("PIN Changed Successfully");
                                                exitPin = true;
                                            }

                                        }
                                        break;
                                    case 7:
                                        exitOperation = true;
                                        break;
                                }

                            }
                        }
                        else if(loginOption == 2) {
                            System.out.println("Go back to Main menu. ");
                            login = true;
                        }
                        else {
                            done = true;
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
