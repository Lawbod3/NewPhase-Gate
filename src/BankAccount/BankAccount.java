package BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {

        ArrayList<String> phoneNumbers = new ArrayList<>();
        ArrayList<String> passCode = new ArrayList<>();
        HashMap<String, AccountInfo> accounts = new HashMap<>();

        Scanner input = new Scanner(System.in);
        boolean done = false;
        System.out.println("Welcome to the FirstBank");
        while (!done) {
            System.out.println("""
                    
                    =================================
                    Select Any of the options below.
                    1. Create an Account.
                    2. For existing customer.
                    3. Exit the program.
                    =================================
                    """);
            System.out.print("Enter your option: ");
            int option;
            String intake;
            while (true) {
                     intake = input.nextLine();
                    if(!nullValidate(intake)){
                        System.out.print("Invalid input. Try again: ");
                        continue;
                    }
                    option = Integer.parseInt(intake);
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
                            System.out.println("Please enter only 11 digits: ");
                            phoneNumber = input.nextLine();
                        }
                        if(phoneNumbers.contains(phoneNumber)){
                            System.out.println("That phone number is already in use.");
                            break;}
                        addUniquePhoneNumbers(phoneNumbers, phoneNumber);
                        String confirmPin;
                        while (true) {
                            System.out.print("Enter for digit for your Pin: ");
                            String pin = input.nextLine();
                            while (!validateForNumber0nlyPin(pin)) {
                                System.out.println("Please enter only four digits Pin: .");
                                pin = input.nextLine();
                            }

                            System.out.print("Enter confirm account PIN: ");
                            confirmPin = input.nextLine();
                            while (!validateForNumber0nlyPin(pin)) {
                                System.out.println("Please enter only four digits Pin: ");
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
                        BankDataBase data = new BankDataBase();

                        AccountInfo account = new AccountInfo(lastName, firstName, confirmPin);
                        account.setAccountNumber(phoneNumber);
                        accounts.put(phoneNumber, account);
                        data.add(account);

                        System.out.printf("Account created Successfully. Account number: %s\n>>>>>>>>>>>>.", phoneNumber);

                        break;
                    }

                case 2:
                    boolean login = false;
                    int loginOption;
                    while (!login) {
                        System.out.print("""
                         
                         ========================
                         1.Login your account.
                         2.Go back to Main menu. 
                         3.Exit the program.
                         =======================
                             """);
                        System.out.print("Enter your option: ");

                        while (true) {
                                String loginIntake = input.nextLine();
                                if(!nullValidate(loginIntake)){
                                    System.out.print("Invalid input ");
                                    continue;
                                }
                                loginOption = Integer.parseInt(loginIntake);
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
                                        
                                        =================================================
                                        Select the operation you would like to carry out.
                                        1. Close account.
                                        2. Deposit money.
                                        3. Withdraw money.
                                        4. Check Account balance
                                        5. Transfer from one account to another.
                                        6.Change Pin.
                                        7.Go back to Main menu.
                                        ===================================================
                                        """);
                                System.out.print("Enter your option: ");

                                    String operationIntake = input.nextLine();
                                    if(!nullValidate(operationIntake)){
                                        System.out.print("Invalid input, Try again: ");
                                        operationIntake = input.nextLine();
                                        continue;
                                    }
                                    operation = Integer.parseInt(operationIntake );

                                switch (operation) {
                                    case 1:
                                        boolean close = false;
                                        int closeOption;
                                        while (!close) {
                                            System.out.print(""" 
                                                    ===========================================================
                                                    Are you sure you want to Close your Account with us? 
                                                    1.Yes.
                                                    2.No.
                                                    ============================================================
                                                    """);
                                            System.out.print("Enter your option: ");
                                            String closingOption = input.nextLine();
                                            if(!nullValidate(closingOption)){
                                                System.out.print("Invalid input, Try again: ");
                                                closingOption = input.nextLine();
                                                continue;
                                            }
                                            closeOption = Integer.parseInt(closingOption);

                                            if (closeOption == 1) {
                                                AccountInfo closeAccount = accounts.get(phoneNumberLogins);
                                                System.out.println("!!!! Your account can only be closed when empty !!!!");
                                                System.out.println("Input your account PIN: ");
                                                String closePin = input.nextLine();
                                                while (!validateForNumber0nlyPin(closePin)) {
                                                    System.out.println("Invalid input only four digit number: ");
                                                    closePin = input.nextLine();
                                                }

                                                if(closeAccount.getBalance() > 0.00 ||  (!closeAccount.validatePin(closePin))){
                                                    System.out.println("Account can only be close when empty and when balance is not empty");
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
                                            else if(closeOption == 2) {
                                                close = true;
                                            }
                                            else {
                                                System.out.println("Invalid input, Try again: ");
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
                                            AccountInfo account = accounts.get(phoneNumberLogins);
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
                                            AccountInfo account = accounts.get(phoneNumberLogins);
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
                                        AccountInfo account = accounts.get(phoneNumberLogins);
                                        System.out.printf("Your account balance is: #%.2f%n", account.getBalance());
                                        break;
                                    case 5:
                                        AccountInfo transferAccount = accounts.get(phoneNumberLogins);
                                        String receiverNumber;
                                        boolean transfer = false;
                                        while(!transfer) {
                                            System.out.println("!!! Transfer Limit is #500,000 !!!!!");
                                            System.out.println("Enter beneficiary Account number or phoneNumber: ");
                                            receiverNumber = input.nextLine();
                                            while (!validatePhoneNumber(receiverNumber)) {
                                                System.out.println("Invalid, make sure the number is eleven digits: ");
                                                receiverNumber = input.nextLine();
                                            }
                                            if(phoneNumberLogins.equals(receiverNumber)) {
                                                System.out.println("This is your phone number.");
                                                transfer = true;
                                                break;
                                            }
                                            if (!phoneNumbers.contains(receiverNumber)) {
                                                System.out.println("Beneficiary Account number does not exist.");
                                                exitOperation = true;
                                                transfer = true;
                                                break;
                                            }
                                            System.out.println("Enter the amount you to transfer: ");
                                            double amount = input.nextDouble();
                                            while((amount < 1) || (amount > 500000)) {
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
                                                AccountInfo receiver = accounts.get(receiverNumber);
                                                transferAccount.transferFund(receiver, amount);
                                                System.out.printf("You have successfully transferred %.2f  to %s.", amount, receiver.getAccountUser());
                                                System.out.println("Transfer successfully>>>>>>>>>.");
                                                transfer = true;
                                            }
                                        }
                                        break;
                                    case 6:
                                        AccountInfo accountChangePin = accounts.get(phoneNumberLogins);
                                        boolean exitPin = false;
                                        String changePin;
                                        while(!exitPin) {
                                            System.out.println("Enter your Current account PIN: ");
                                            String currentPin = input.nextLine();
                                            while (!validateForNumber0nlyPin(currentPin)) {
                                                System.out.print("Invalid, make sure it is four digits: ");
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
                                                System.out.print("Invalid, make sure it is four digits: .");
                                                changePin = input.nextLine();
                                            }
                                            if(changePin.equals(currentPin)) {
                                                System.out.println("You cant use your old Pin");
                                                exitPin = true;
                                                break;
                                            }
                                            System.out.println("Confirm your new account PIN: ");
                                            String confirmPin = input.nextLine();
                                            while (!validateForNumber0nlyPin(confirmPin)) {
                                                System.out.print("Invalid, make sure it is four digits: .");
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
                                    default: System.out.println("Wrong Input, Try again.");
                                    break;
                                }
                            }
                        }
                        else if(loginOption == 2) {
                            System.out.println("Go back to Main menu. ");
                            login = true;
                        }
                        else if(loginOption == 3) {
                            done = true;
                            login = true;
                        }
                        else{
                            System.out.println("Wrong Login Option, Try again");
                        }
                    }
                    break;
                case 3:
                    done = true;
                    break;
                 default: System.out.println("Wrong option, try again: ");
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
    public static boolean nullValidate(String option) {
        if(option.length()  == 1 && option.matches("^[0-9]+$") && (!option.isEmpty())) return true;
        return false;
    }
}
