package MenstrualAndOthers;

import MenstrualMethodFolder.MenstrualMethod;
import MenstrualMethodFolder.NewMenstrualMethod;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NewMenstrual {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        NewMenstrualMethod period = new NewMenstrualMethod();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String result;

        System.out.println("Welcome to Women Menstrual Cycle");
        System.out.println("We will be asking some personal information");

        System.out.print("When was the first day of your last period?(dd/MM/yyyy): ");
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







    }

}
