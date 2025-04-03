package oldSnacks;

import java.util.*;

public class CheckOut
{
    public static void main(String...args)
    {

        Scanner keyboard = new Scanner(System.in);

        String answer = "";
        ArrayList<String> arrayBuy = new ArrayList<>();
        ArrayList<Double> arrayUnit = new ArrayList<>();
        ArrayList<Double> arrayPrice = new ArrayList<>();
        ArrayList<Double> arrayTotal = new ArrayList<>();
        double total = 0;
        double discount = 0;
        double vat = 0;
        double billTotal = 0;
        double balance = 0;

        System.out.println("What is the customer's name?\t ");
        String name = keyboard.nextLine();


        while(!answer.equals("NO"))
        {

            System.out.println("What did the user buy?\t ");
            String buy = keyboard.nextLine();


            System.out.println("How many pieces?\t ");
            double unit = keyboard.nextDouble();

            System.out.println("How much per unit?\t ");
            double price = keyboard.nextDouble();
            keyboard.nextLine().toUpperCase();

            arrayBuy.add(buy);
            arrayUnit.add(unit);
            arrayPrice.add(price);

            boolean correct = false;

            while(!correct){
                System.out.println("Add more Items? (Yes or No)\t ");
                answer = keyboard.nextLine().toUpperCase();

                switch(answer){

                    case "YES":
                        correct = true;
                        break;

                    case "NO":
                        correct = true;
                        break;

                    default:
                        System.out.println("Please input either YES or NO");
                        break;

                } }

            if(answer.equals("NO")){
                break;

            }


        }

        System.out.println("What is your name?\t ");
        String cashier = keyboard.nextLine();

        System.out.println("How much discount will he get?\t ");
        double dis = keyboard.nextInt();


        for(int i = 0; i < arrayPrice.size(); i++){
            double sum = arrayUnit.get(i) * arrayPrice.get(i);
            total += arrayUnit.get(i) * arrayPrice.get(i);

            arrayTotal.add(sum); }

        discount = (dis / 100.00) * total;
        vat   = (7.5 / 100.00) * total;

        billTotal = (total + discount) - vat;


        System.out.printf("""
\n
SEMICOLON STORES

MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 03293828343
Date : 02-Dec-25 4:29 pm
Cashier Name: %s
Customer Name: %s

""", cashier, name);

        System.out.println("""
\n------------------------------------------------------------------
---------------------------------------------------------------------\n
""");

        System.out.printf("%16S%8S%10S%15S", "item", "qty", "price", "total(ngn)");

        System.out.println("""
\n
---------------------------------------------------------------------\n
""");


        for(int i = 0; i < arrayBuy.size(); i++){
            System.out.printf("%-16S%-8.1f%-10.2f%-15.2f", arrayBuy.get(i), arrayUnit.get(i), arrayPrice.get(i), arrayTotal.get(i));

            System.out.println();

        }

        System.out.println("""
\n
---------------------------------------------------------------------\n
""");


        System.out.printf("""
                Sub Total: %.2f
                Discount : %.2f
               VAT @ 7.5%%: %.2f

""", total, discount, vat);


        System.out.println("""
\n------------------------------------------------------------------
---------------------------------------------------------------------\n
""");

        System.out.println("                Bill Total: " + billTotal);

        System.out.println("""
\n------------------------------------------------------------------
---------------------------------------------------------------------\n
""");

        System.out.printf("THIS IS NOT A RECEIPT KINDLY PAY %.2f", billTotal);
        System.out.println("""
\n------------------------------------------------------------------
---------------------------------------------------------------------\n
""");


        System.out.println("How much did the customer give to you?:\t ");
        double customer = keyboard.nextDouble();
        keyboard.nextLine();

        while(customer < billTotal){
            System.out.printf("Your bill is: $%f%nPlease balance up%n", billTotal);
            customer += keyboard.nextDouble();

        }

        balance  = customer - billTotal;




        System.out.printf("""
\n
SEMICOLON STORES

MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 03293828343
Date : 02-Dec-25 4:29 pm
Cashier Name: %s
Customer Name: %s
""", cashier, name);

        System.out.println("""

------------------------------------------------------------------
---------------------------------------------------------------------
""");

        System.out.printf("%16S%8S%10S%15S", "item", "qty", "price", "total(ngn)");

        System.out.println("""

---------------------------------------------------------------------\n
""");


        for(int i = 0; i < arrayBuy.size(); i++){
            System.out.printf("%-16S%-8.1f%-10.2f%-15.2f%n", arrayBuy.get(i), arrayUnit.get(i), arrayPrice.get(i), arrayTotal.get(i));

            System.out.println();

        }

        System.out.println("""
---------------------------------------------------------------------
""");

        System.out.printf("""
                Sub Total: %.2f

                Discount : %.2f

               VAT @ 7.5%%: %.2f

""", total, discount, vat);


        System.out.println("""
------------------------------------------------------------------
---------------------------------------------------------------------
""");


        System.out.printf("""
                Bill Total: %.2f

               Amount Paid: %.2f

                   Balance: %.2f 

""", billTotal, customer, balance);

        System.out.println("""
------------------------------------------------------------------
---------------------------------------------------------------------
""");

        System.out.printf("        THANK YOU FOR YOUR PATRONAGE");
        System.out.println("""

\n------------------------------------------------------------------
---------------------------------------------------------------------\n
""");




    }
}
