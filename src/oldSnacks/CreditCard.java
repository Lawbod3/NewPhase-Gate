package oldSnacks;

import java.util.Scanner;

public class CreditCard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CreditCardMethod cc = new CreditCardMethod();
        boolean validate = false;
        System.out.println("App to validate CreditCard");
        System.out.print("Hello, Kindly enter card number to verify: ");
        String number = input.nextLine();
        while (!cc.validateStringOfNumbers(number) || !cc.validateLength(number)){
            System.out.print("Please make sure card number is correct, try again: ");
            number = input.nextLine();
        }

        int[] array = cc.convertToArray(number);
        int sumOne = cc.sumofArrayFromLastIndex(array);
        int sumTwo = cc.sumofArrayLuhmPrincipleIndex(array);
        int total = sumOne + sumTwo;

        if (total % 10 == 0) {
            validate = true;
        }

        String result = validate ? "valid" : "inValid";

        if (result == "valid") {

            System.out.printf("""
                    *****Credit Card Type: %s
                    *****Credit Card number: %s
                    *****Credit Card Digit Length: %d
                    *****Credit Card Validity Status: %s
                    """, cc.getCardType(number), number, number.length(), result);
            System.out.println("Thank you for using the Credit Card Validator App!");
        }
        else{
            System.out.printf("""
                    *****Credit Card Type: Invalid Card
                    *****Credit Card number: %s
                    *****Credit Card Digit Length: %d
                    *****Credit Card Validity Status: %s
                    """,  number, number.length(), result);
            System.out.println("Please try again with a valid card number.");
            System.out.println("Thank you for using the Credit Card Validator App!");
        }






    }
}
