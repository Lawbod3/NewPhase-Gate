package MenstrualMethodFolder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewMenstrualMethod {
    private int periodDays;
    private int flowDays;
    private String firstDayOfLastPeriod;


    public void setPeriodDays(int days) {
        if (days < 21 || days > 35) throw new IllegalArgumentException("Days must be between 21 to 35");
        this.periodDays = days;
    }

    public String getNextPeriodDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate setDate = LocalDate.parse(firstDayOfLastPeriod, formatter);
        LocalDate nextPeriod = setDate.plusDays(periodDays);
        return nextPeriod.format(formatter);
    }

    public String getNextOvulation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate setDate = LocalDate.parse(firstDayOfLastPeriod, formatter);
        LocalDate nextOvulation = setDate.plusDays(periodDays + 9);
        if (periodDays > 24) {
            LocalDate nextOvulation2 = setDate.plusDays(periodDays + 14);
            return nextOvulation2.format(formatter);
        }
        else if (periodDays > 28) {
            LocalDate nextOvulation3 = setDate.plusDays(periodDays + 16);
            return nextOvulation3.format(formatter);
        }
        else if (periodDays > 33) {
            LocalDate nextOvulation4 = setDate.plusDays(periodDays + 21);
            return nextOvulation4.format(formatter);
        }
        return nextOvulation.format(formatter);

    }

    public String getFertilityPeriod() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate setDate = LocalDate.parse(firstDayOfLastPeriod, formatter);
        LocalDate nextFertilityPeriod = setDate.plusDays(periodDays + 5);
        if(periodDays > 24) {
            LocalDate nextFertilityPeriod2 = setDate.plusDays(periodDays + 9);
            return String.valueOf(nextFertilityPeriod2.format(formatter)) + " - " + String.valueOf(getNextOvulation());
        }
        else if (periodDays > 28) {
            LocalDate nextFertilityPeriod3 = setDate.plusDays(periodDays + 11);
            return String.valueOf(nextFertilityPeriod3.format(formatter)) + " - " + String.valueOf(getNextOvulation());
        }
        return String.valueOf(nextFertilityPeriod.format(formatter)) + " - " + String.valueOf(getNextOvulation());
    }

    public void setFlowDays(int flow) {
        this.flowDays = flow;
    }

    public String getNextFlowDays() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate setDate = LocalDate.parse(firstDayOfLastPeriod, formatter);
            LocalDate nextFlowDays = setDate.plusDays(periodDays + flowDays);
            return  String.valueOf(getNextPeriodDays()) + " - " +  String.valueOf(nextFlowDays.format(formatter));

    }

    public void setLastPeriodDate(String input) {
        this.firstDayOfLastPeriod = input;
    }

    public String getNextPreOvulation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate setDate = LocalDate.parse(getNextOvulation(), formatter);
        LocalDate nextPreOvulation = setDate.minusDays(1);
        return getNextPeriodDays() + " - " + String.valueOf(nextPreOvulation.format(formatter));
    }

    public String getEndOfNextCycle() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate setDate = LocalDate.parse(firstDayOfLastPeriod, formatter);
        LocalDate endPeriod = setDate.plusDays(periodDays + periodDays - 1);
        return endPeriod.format(formatter);

    }

    public String getNextPostOvulation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate setDate = LocalDate.parse(firstDayOfLastPeriod, formatter);
        LocalDate nextOvulation = setDate.plusDays(periodDays + 10);
        if (periodDays > 24) {
            LocalDate nextOvulation2 = setDate.plusDays(periodDays + 15);
            return nextOvulation2.format(formatter)  + " - " + String.valueOf(getEndOfNextCycle());
        }
        else if (periodDays > 28) {
            LocalDate nextOvulation3 = setDate.plusDays(periodDays + 17);
            return nextOvulation3.format(formatter) + " - " + String.valueOf(getEndOfNextCycle());
        }
        else if (periodDays > 33) {
            LocalDate nextOvulation4 = setDate.plusDays(periodDays + 22);
            return nextOvulation4.format(formatter) +  " - " + String.valueOf(getEndOfNextCycle());
        }
        return nextOvulation.format(formatter) + " - " + String.valueOf(getEndOfNextCycle());

    }

    public String getSafeDay() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate setDate = LocalDate.parse(firstDayOfLastPeriod, formatter);
        LocalDate nextFlowDays = setDate.plusDays(periodDays + flowDays + 2);
        return  String.valueOf(getNextPeriodDays()) + " - " +  String.valueOf(nextFlowDays.format(formatter));

    }
}


