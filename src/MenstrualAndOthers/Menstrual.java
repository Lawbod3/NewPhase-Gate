package MenstrualAndOthers;

import MenstrualMethodFolder.MenstrualMethod;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;


public class Menstrual {
    public static void main(String...args){

        Scanner keyboard = new Scanner(System.in);
        MenstrualMethod period = new MenstrualMethod();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String result = "";
        int cycleRange = 0;

    System.out.println("Welcome to Women Menstrual Cycle");
        System.out.println("We will be asking some personal information");


        System.out.print("When was the first day of your last period?(dd/MM/yyyy): ");
        while(true) {
            try {
                String firstDay = keyboard.nextLine();
                LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
                 result = String.valueOf(lastPeriod.format(formatter));
            } catch (DateTimeException e) {
                System.out.print("Please enter a valid date, use this format(dd/MM/yyyy): ");
                continue;
            }

            System.out.println("""
                           Select how many days does your period last?
                           1. 3days.
                           2. 5days.
                           3. 7days.
                           4. Not sure.
                           """);
            while(true) {
                try {
                    System.out.print("Enter your choice: ");
                    int periodDays = keyboard.nextInt();
                    while(periodDays < 1 || periodDays > 4) {
                        System.out.print("Please enter NUMBER from 1 to 4: ");
                        periodDays = keyboard.nextInt();
                    }
                    keyboard.nextLine();
                } catch (InputMismatchException e) {
                    System.out.print("Please enter a valid option!");
                    keyboard.nextLine();
                    continue;
                }
                break;
            }
            System.out.println("""
            How heavy is the flow of your last period?
            1. Light.
            2. Medium.
            3. Heavy.
            """);
            while(true) {
                try {
                    System.out.print("Enter your choice: ");
                    int flowWeight = keyboard.nextInt();
                    while (flowWeight < 1 || flowWeight > 3) {
                        System.out.print("Please enter NUMBER from 1 to 3: ");
                        flowWeight = keyboard.nextInt();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.print("Please enter a valid option!");
                    keyboard.nextLine();
                    continue;
                }
                break;
            }
            System.out.println("""
            How long is your typical period.
            1. 1-28days.
            2. 1-31days.
            3. 1-35days.
            """);
            while(true) {
                try {
                    System.out.print("Enter your choice: ");
                     cycleRange = keyboard.nextInt();
                    while (cycleRange < 1 || cycleRange > 3) {
                        System.out.print("Please enter NUMBER from 1 to 3: ");
                        cycleRange = keyboard.nextInt();
                    }

                }
                catch (InputMismatchException e) {
                    System.out.print("Please enter a valid option!");
                    keyboard.nextLine();
                    continue;
                }
                break;
            }

            break;
        }


        System.out.print("""
     Kindly Select any of the options to let me know the reason for using the App?
     1. Track Menstrual Cycle.
     2. Fertility And Family Planing.
     3. Mental Health Awareness For Ladies.
     4. Health Monitoring.
     """);

        while (true) {
            int menuChoice;
            try {
           System.out.print("Enter your choice: ");
           menuChoice = keyboard.nextInt();
           keyboard.nextLine();


       } catch (InputMismatchException e) {

           System.out.print("Please enter a valid option!");
           keyboard.nextLine();
           continue;
       }



            switch (menuChoice) {

           case 1:
               System.out.println("You selected Track Menstrual Cycle.");
               System.out.printf("""
                       Your next Menstrual period is likely to be on the %s%n
                       Your next Menstrual flow will be within this days %s%n
                       Your next Ovulation is likely to be on the %s%n
                       Your Pre Ovulation period will be within this days %s%n
                       Your Ovulation is likely to be on this day %s%n
                       Your Post Ovulation period will be within this days %s
                       """, period.getNextPeriodDate(result, cycleRange), period.getFlowPeriodS(result), period.getPreOvulation(result), period.getPreOvulation(result), period.getOvulationDate(result, cycleRange), period.getPostOvulation(result));
              break;
           case 2:
               System.out.println("You selected Fertility And Family Planing..");
               System.out.printf("""
                       Low Probability of pregnancy is likely to be within this period %s%n
                       High Probability of pregnancy is likely to be within this period %s%n
                       Ovulation day have the highest probability and is likely to be on this day %s%n
                       """, period.getSafeDay(result, cycleRange), period.getFertilityDays(result, cycleRange), period.getOvulationDate(result,cycleRange));
               break;
           case 3:
               break;
           case 4:
               break;

           default:
               System.out.println("Please enter a valid option!");
               break;
       }
       break;
   }











    }

}
