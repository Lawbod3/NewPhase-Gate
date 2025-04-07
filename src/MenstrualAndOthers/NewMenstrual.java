package MenstrualAndOthers;

import MenstrualMethodFolder.MenstrualMethod;
import MenstrualMethodFolder.NewMenstrualMethod;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NewMenstrual {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        NewMenstrualMethod period = new NewMenstrualMethod();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String result;

        System.out.println("Welcome to Women Menstrual Cycle");
        System.out.println("We will be asking some personal information");

        System.out.print("\nWhen was the first day of your last period?(dd/MM/yyyy): ");
        while(true) {
            try {
                String firstDay = keyboard.nextLine();
                LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
                result = String.valueOf(lastPeriod.format(formatter));
                period.setLastPeriodDate(result);
            } catch (DateTimeException e) {
                System.out.print("Please enter a valid date, use this format(dd/MM/yyyy): ");
                continue;
            }
            break;
        }
        System.out.print("How many days does your Menstrual Cycle last: ");
        while(true) {
            String days = keyboard.nextLine();
           while(!nullValidate(days)){
               System.out.print("Invalid input, please try again make sure it two digit numbers: ");
               days = keyboard.nextLine();
           }
           int day = Integer.parseInt(days);
           if(day < 21 || day > 35){
               System.out.print("menstrual cycle last within this period 21 - 31days, please go see a doctor");
               break;
           }
           period.setPeriodDays(day);
            break;
        }
        while(true) {
            System.out.print("How many days does your flow days last: ");
            String flowDays = keyboard.nextLine();
            while(!flowValidate(flowDays)){
                System.out.print("Invalid input, please try again: ");
                flowDays = keyboard.nextLine();
            }
            int flowday = Integer.parseInt(flowDays);
            if(flowday < 1 || flowday > 7){
                System.out.print("bleeding more than 7days or not bleeding at all, please go see a doctor");
                break;
            }
            period.setFlowDays(flowday);
            break;
        }

        System.out.print("""
     Kindly Select any of the options to let me know the reason for using the App?
     1. Track Menstrual Cycle.
     2. Fertility And Family Planing.
     """);
        String menuChoice;
        while (true) {
            try{
                System.out.print("Enter your choice: ");
                menuChoice = keyboard.nextLine();
                if(menuChoice.isEmpty()){
                    continue;
                }
                int choice = Integer.parseInt(menuChoice);
                while (choice < 1 || choice > 2) {
                    System.out.print("Please enter NUMBER from 1 to 2: ");
                    keyboard.nextLine();
                    choice = keyboard.nextInt();
                }
                keyboard.nextLine();


            } catch (InputMismatchException e) {

                System.out.print("Please enter a valid option!");
                keyboard.nextLine();
                continue;
            }

        }

        }
    public static boolean nullValidate(String option) {
        if(option.length()  == 2 && option.matches("^[0-9]+$") && (!option.isEmpty())) return true;
        return false;
    }

    public static boolean flowValidate(String option) {
        if(1 == option.length() && option.matches("^[0-9]+$") && (!option.isEmpty())) return true;
        return false;
    }

}
