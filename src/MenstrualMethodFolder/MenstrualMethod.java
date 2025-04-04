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
        LocalDate nextPeriod = lastPeriod.plusDays(28);
        if(selection == 2) {
            LocalDate nextPeriod2 = lastPeriod.plusDays(31);
            return String.valueOf(nextPeriod2.format(formatter));
        }
        else if(selection == 3) {
            LocalDate nextPeriod3 = lastPeriod.plusDays(35);
            return String.valueOf(nextPeriod3.format(formatter));
        }
        return String.valueOf(nextPeriod.format(formatter));



    }

    public String getOvulationDate(String firstDate, int selection) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDate, formatter);
        LocalDate ovulationPeriod = lastPeriod.plusDays(42);
        if(selection == 2) {
            LocalDate ovulationPeriod2 = lastPeriod.plusDays(48);
            return String.valueOf(ovulationPeriod2.format(formatter));
        }
        if(selection == 3) {
            LocalDate ovulationPeriod3 = lastPeriod.plusDays(56);
            return String.valueOf(ovulationPeriod3.format(formatter));
        }
        return String.valueOf(ovulationPeriod.format(formatter));
    }

    public String getFertilityDays(String firstDay, int selection) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate fertilityPeriod = lastPeriod.plusDays(37);
        if(selection == 2) {
            LocalDate fertilityPeriod2 = lastPeriod.plusDays(43);
            return String.valueOf(fertilityPeriod2.format(formatter)) + " - " + getOvulationDate(firstDay, selection);
        }
        if(selection == 3) {
            LocalDate fertilityPeriod3 = lastPeriod.plusDays(51);
            return String.valueOf(fertilityPeriod3.format(formatter) + " - " + getOvulationDate(firstDay, selection));
        }


        return String.valueOf(fertilityPeriod.format(formatter)) + " - " + getOvulationDate(firstDay);

    }

    public String getSafeDay(String firstDay, int selection) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate safeDay = lastPeriod.plusDays(28);
        LocalDate endSafeDay = safeDay.plusDays(7);
        if(selection == 2) {
            LocalDate safeDay2 = lastPeriod.plusDays(31);
            LocalDate endSafeDay2 = safeDay2.plusDays(7);
            return String.valueOf(safeDay2.format(formatter)) + " - " + String.valueOf(endSafeDay2.format(formatter));
        }
        if(selection == 3) {
            LocalDate safeDay3 = lastPeriod.plusDays(35);
            LocalDate endSafeDay3 = safeDay3.plusDays(7);
            return String.valueOf(safeDay3.format(formatter)) + " - " + String.valueOf(endSafeDay3.format(formatter));
        }

        return  String.valueOf(safeDay.format(formatter)) + " - " + String.valueOf(endSafeDay.format(formatter));
    }


    public String getFlowPeriodS(String firstDay, int selection , int flowDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastPeriod = LocalDate.parse(firstDay, formatter);
        LocalDate flowPeriod = lastPeriod.plusDays(28);
        LocalDate endFlowPeriod = flowPeriod.plusDays(5);

        if(flowDays == 1) {
            LocalDate endFlowPeriod1 = flowPeriod.plusDays(3);
            return String.valueOf(flowPeriod.format(formatter)) + " - " + String.valueOf(endFlowPeriod1.format(formatter));
        }
        if(flowDays == 3) {
            LocalDate endFlowPeriod3 = flowPeriod.plusDays(7);
            return String.valueOf(flowPeriod.format(formatter)) + " - " + String.valueOf(endFlowPeriod3.format(formatter));
        }

        return String.valueOf(flowPeriod.format(formatter)) + " - " + String.valueOf(endFlowPeriod.format(formatter));

    }
}
