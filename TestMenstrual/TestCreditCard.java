import oldSnacks.CreditCard;
import oldSnacks.CreditCardMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCreditCard {
    CreditCardMethod cc = new CreditCardMethod();
    @Test public void testCreditCardLengthValidation() {
        String numbers = "123456789";
        assertFalse(cc.validateLength(numbers));
    }
    @Test
    public void testCreditCardConvertInputToArrayOfNumbers() {
        String numbers = "1234567890345";
        int[] arrayOfNumbers = CreditCardMethod.convertToArray(numbers);
        int[] expected = {1,2,3,4,5,6,7,8,9,0,3,4,5};
        assertArrayEquals(expected, arrayOfNumbers);
    }
}
