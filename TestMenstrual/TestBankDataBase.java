import org.junit.Test;

import static org.junit.Assert.*;

public class TestBankDataBase {
    @Test
    public void testBankDataBaseIsEmpty() {
        BankDataBase data = new BankDataBase();
        assertTrue(data.isEmoty());
    }

}
