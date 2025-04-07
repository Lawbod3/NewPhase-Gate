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
        period.setPeriodDays(28);
        assertEquals("05/05/2025",period.getNextPeriodDays());
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
        period.setPeriodDays(28);
        assertEquals("19/05/2025", period.getNextOvulation());
        period.setPeriodDays(30);
        assertEquals("21/05/2025", period.getNextOvulation());
        period.setPeriodDays(34);
        assertEquals("25/05/2025", period.getNextOvulation());

    }
    @Test
    public void testGetNextFertilityPeriod() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setPeriodDays(28);
        assertEquals("14/05/2025 - 19/05/2025", period.getFertilityPeriod());
        period.setPeriodDays(21);
        assertEquals("03/05/2025 - 07/05/2025", period.getFertilityPeriod());
        period.setPeriodDays(30);
        assertEquals("16/05/2025 - 21/05/2025", period.getFertilityPeriod());

    }
    @Test
    public void testGetFlowPeriodS() {
        NewMenstrualMethod period = new NewMenstrualMethod();
        period.setFlowDays(3);
        period.setPeriodDays(28);
        assertEquals("05/05/2025 - 08/05/2025",period.getNextFlowDays());

    }
}
