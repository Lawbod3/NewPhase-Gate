import MenstrualMethodFolder.MenstrualMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMenstrualMethod {
    @Test
    public void testMenstrualMethodGetNextPeriod() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2022",  menstrualMethod.getNextPeriodDate("01/10/2022"));
    }
    @Test
    public void testMenstrualMethodGetNextOvulationDate() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("12/11/2022", menstrualMethod.getOvulationDate("01/10/2022"));
    }
    @Test
    public void testMenstrualMethodGetFertilityDays() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("07/11/2022 - 12/11/2022", menstrualMethod.getFertilityDays("01/10/2022"));
    }
    @Test
    public void testMenstrualMethodGetSafeDate() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2022 - 05/11/2022",    menstrualMethod.getSafeDay("01/10/2022"));
    }
    @Test
    public void testMenstrualMethodGetFlowPeriod() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2022 - 03/11/2022", menstrualMethod.getFlowPeriodS("01/10/2022"));
    }
    @Test
    public void testMenstrualMethodGetPreOvulationPeriod() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2025 - 11/11/2025", menstrualMethod.getPreOvulation("01/10/2025"));
    }
    @Test
    public void testMenstrualMethodGetPostOvulationPeriod() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("13/11/2025 - 26/11/2025", menstrualMethod.getPostOvulation("01/10/2025"));
    }
    @Test
    public void testMenstrualMethodGetNextPeriodTwoForAboveNormalDays() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2022",  menstrualMethod.getNextPeriodDate("01/10/2022"));
        assertEquals("01/11/2022",  menstrualMethod.getNextPeriodDate("01/10/2022", 2));
    }
    @Test
    public void testMenstrualMethodGetNextPeriodThreeForAboveNormalMonth() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2022",  menstrualMethod.getNextPeriodDate("01/10/2022"));
        assertEquals("01/11/2022",  menstrualMethod.getNextPeriodDate("01/10/2022", 2));
        assertEquals("05/11/2022",  menstrualMethod.getNextPeriodDate("01/10/2022", 3));
    }
    @Test
    public void testMenstrualMethodGetNextOvulationDateAboveNormalDays() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("12/11/2022", menstrualMethod.getOvulationDate("01/10/2022"));
        assertEquals("18/11/2022", menstrualMethod.getOvulationDate("01/10/2022", 2));

    }
    @Test
    public void testMenstrualMethodGetNextOvulationDateWayAboveNormalDays() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("12/11/2022", menstrualMethod.getOvulationDate("01/10/2022"));
        assertEquals("18/11/2022", menstrualMethod.getOvulationDate("01/10/2022", 2));
        assertEquals("26/11/2022", menstrualMethod.getOvulationDate("01/10/2022", 3));
    }
    @Test
    public void testMenstrualMethodGetFertilityForAboveNormalDays() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("07/11/2022 - 12/11/2022", menstrualMethod.getFertilityDays("01/10/2022"));
        assertEquals("13/11/2022 - 18/11/2022", menstrualMethod.getFertilityDays("01/10/2022", 2));
    }
    @Test
    public void testMenstrualMethodGetFertilityForWayAboveNormalDays() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("07/11/2022 - 12/11/2022", menstrualMethod.getFertilityDays("01/10/2022"));
        assertEquals("13/11/2022 - 18/11/2022", menstrualMethod.getFertilityDays("01/10/2022", 2));
        assertEquals("21/11/2022 - 26/11/2022", menstrualMethod.getFertilityDays("01/10/2022", 3));
    }
    @Test
    public void testMenstrualMethodGetSafeDateForAboveNormalCycle() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2022 - 05/11/2022",    menstrualMethod.getSafeDay("01/10/2022"));
        assertEquals("01/11/2022 - 08/11/2022",    menstrualMethod.getSafeDay("01/10/2022", 2));
    }
    @Test
    public void testMenstrualMethodGetSafeDateForWayAboveNormalCycle() {
        MenstrualMethod menstrualMethod = new MenstrualMethod();
        assertEquals("29/10/2022 - 05/11/2022",    menstrualMethod.getSafeDay("01/10/2022"));
        assertEquals("01/11/2022 - 08/11/2022",    menstrualMethod.getSafeDay("01/10/2022", 2));
        assertEquals("05/11/2022 - 12/11/2022",    menstrualMethod.getSafeDay("01/10/2022", 3));
    }









}
