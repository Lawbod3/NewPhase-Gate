package MenstrualMethodFolder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewMenstrualMethod {
    private int periodDays;
    private int flowDays;


    public void setPeriodDays(int days) {
        if (days < 21 || days > 35) throw new IllegalArgumentException("Days must be between 21 to 35");
        this.periodDays = days;
    }

    public String getNextPeriodDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate nextPeriod = LocalDate.now().plusDays(periodDays);
        return nextPeriod.format(formatter);
    }

    public String getNextOvulation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate nextOvulation = LocalDate.now().plusDays(periodDays + 9);
        if (periodDays > 24) {
            LocalDate nextOvulation2 = LocalDate.now().plusDays(periodDays + 14);
            return nextOvulation2.format(formatter);
        }
        else if (periodDays > 28) {
            LocalDate nextOvulation3 = LocalDate.now().plusDays(periodDays + 16);
            return nextOvulation3.format(formatter);
        }
        else if (periodDays > 33) {
            LocalDate nextOvulation4 = LocalDate.now().plusDays(periodDays + 21);
            return nextOvulation4.format(formatter);
        }
        return nextOvulation.format(formatter);

    }

    public String getFertilityPeriod() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate nextFertilityPeriod = LocalDate.now().plusDays(periodDays + 5);
        if(periodDays > 24) {
            LocalDate nextFertilityPeriod2 = LocalDate.now().plusDays(periodDays + 9);
            return String.valueOf(nextFertilityPeriod2.format(formatter)) + " - " + String.valueOf(getNextOvulation());
        }
        else if (periodDays > 28) {
            LocalDate nextFertilityPeriod3 = LocalDate.now().plusDays(periodDays + 11);
            return String.valueOf(nextFertilityPeriod3.format(formatter)) + " - " + String.valueOf(getNextOvulation());
        }
        return String.valueOf(nextFertilityPeriod.format(formatter)) + " - " + String.valueOf(getNextOvulation());
    }

    public void setFlowDays(int flow) {
        this.flowDays = flow;
    }

    public String getNextFlowDays() {

    }
}
