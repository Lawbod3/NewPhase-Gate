import MenstrualMethodFolder.NewMenstrualMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestingMenstrual {
    @Test
    public void testSetPeriodDays() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        int days = 28;
        period.setPeriodDays(28);
    }
    @Test
    public void testGetNextPeriod() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        int days = 28;
        period.setLastPeriodDate("06/04/2025");
        period.setPeriodDays(28);
        assertEquals("04/05/2025",period.getNextPeriodDays());
    }
    @Test
    public void testSetPeriodDaysLimit() {
        NewMenstrualMethod period = new NewMenstrualMethod();

        int days = 36;
        assertThrows(IllegalArgumentException.class, () -> period.setPeriodDays(days));
    }
    @Test
    public void testGetNextOvulation() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setLastPeriodDate("06/04/2025");
        period.setPeriodDays(28);
        assertEquals("18/05/2025", period.getNextOvulation());
        period.setPeriodDays(30);
        assertEquals("20/05/2025", period.getNextOvulation());
        period.setPeriodDays(34);
        assertEquals("24/05/2025", period.getNextOvulation());

    }
    @Test
    public void testGetNextFertilityPeriod() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setLastPeriodDate("06/04/2025");
        period.setPeriodDays(28);
        assertEquals("13/05/2025 - 18/05/2025", period.getFertilityPeriod());
        period.setPeriodDays(21);
        assertEquals("02/05/2025 - 06/05/2025", period.getFertilityPeriod());
        period.setPeriodDays(30);
        assertEquals("15/05/2025 - 20/05/2025", period.getFertilityPeriod());
    }
    @Test
    public void testGetFlowPeriodS() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setLastPeriodDate("06/04/2025");
        period.setFlowDays(3);
        period.setPeriodDays(28);
        assertEquals("04/05/2025 - 07/05/2025",period.getNextFlowDays());
    }
    @Test
    public void testSetLastPeriodDay() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setLastPeriodDate("06/04/2025");
        period.setPeriodDays(28);
        assertEquals("18/05/2025", period.getNextOvulation());
    }
    @Test
    public void testGetPreOvulationPeriodDay() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setLastPeriodDate("06/04/2025");
        period.setPeriodDays(28);
        assertEquals("04/05/2025 - 17/05/2025", period.getNextPreOvulation());
    }
    @Test
    public void testGetEndOfNextMenstrualCycle() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setLastPeriodDate("06/04/2025");
        period.setPeriodDays(28);
        assertEquals("31/05/2025", period.getEndOfNextCycle());
    }
    @Test
    public void testGetPostOvulationPeriodDay() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setLastPeriodDate("06/04/2025");
        period.setPeriodDays(28);
        assertEquals("19/05/2025 - 31/05/2025", period.getNextPostOvulation());
    }
}
