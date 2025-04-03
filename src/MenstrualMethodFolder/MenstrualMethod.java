package MenstrualMethodFolder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class MenstrualMethod {

    public String getNextPeriodDate(String firstDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate lastPeriod = LocalDate.parse(firstDate, formatter);
        LocalDate nextPeriod = lastPeriod.plusDays(28);

        return String.valueOf(nextPeriod.format(formatter));

    }

    public String getOvulationDate(String firstDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDate, formatter);
        LocalDate ovulationPeriod = lastPeriod.plusDays(42);
        return String.valueOf(ovulationPeriod.format(formatter));


    }


    public String getFertilityDays(String firstDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate fertilityPeriod = lastPeriod.plusDays(37);
        return String.valueOf(fertilityPeriod.format(formatter)) + " - " + getOvulationDate(firstDay);
    }

    public String getSafeDay(String firstDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate safeDay = lastPeriod.plusDays(28);
        LocalDate endSafeDay = safeDay.plusDays(7);
        return  String.valueOf(safeDay.format(formatter)) + " - " + String.valueOf(endSafeDay.format(formatter));

    }


    public String getFlowPeriodS(String firstDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate flowPeriod = lastPeriod.plusDays(28);
        LocalDate endFlowPeriod = flowPeriod.plusDays(5);
        return String.valueOf(flowPeriod.format(formatter)) + " - " + String.valueOf(endFlowPeriod.format(formatter));
    }

    public String getPreOvulation(String firstDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate preOvulationPeriod = lastPeriod.plusDays(28);
        LocalDate endPreOvulationPeriod = preOvulationPeriod.plusDays(13);
        return String.valueOf(preOvulationPeriod.format(formatter)) + " - " + String.valueOf(endPreOvulationPeriod.format(formatter));

    }


    public String getPostOvulation(String firstDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate postOvulationPeriod = lastPeriod.plusDays(43);
        LocalDate endPostOvulationPeriod = postOvulationPeriod.plusDays(13);
        return String.valueOf(postOvulationPeriod.format(formatter)) + " - " + String.valueOf(endPostOvulationPeriod.format(formatter));
    }


    public String getNextPeriodDate(String firstDay, int selection) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate nextPeriod = lastPeriod.plusDays(selection);
        if(selection == 2) {
            LocalDate nextPeriod2 = lastPeriod.plusDays(31);
            return String.valueOf(nextPeriod2.format(formatter));
        }
        return String.valueOf(nextPeriod.format(formatter));



    }
}
