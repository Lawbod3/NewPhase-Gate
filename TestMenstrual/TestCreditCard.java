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
    public void testCreditCardMethodStringOfNumberValidation() {
        String numbers = "123456afg89";
        assertFalse(cc.validateStringOfNumbers(numbers));
    }
    @Test
    public void testCreditCardMethodStringOfNumberValidationForNull() {
        String numbers = "";
        assertFalse(cc.validateStringOfNumbers(numbers));
    }

    @Test
    public void testCreditCardConvertInputToArrayOfNumbers() {
        String numbers = "1234567890345";
        int[] arrayOfNumbers = cc.convertToArray(numbers);
        int[] expected = {1,2,3,4,5,6,7,8,9,0,3,4,5};
        assertArrayEquals(expected, arrayOfNumbers);
    }
    @Test
    public void testCreditCardSumArrayFromTheLastIndex() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,2,3,4,5,6};
        assertEquals(32, cc.sumofArrayFromLastIndex(numbers));
    }
    @Test
    public void testCreditCardSumArrayFromTheSecondToLastIndexUsingLuhmAlgorithm() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,2,3,4,5,6};
        assertEquals(30, cc.sumofArrayLuhmPrincipleIndex(numbers));

    }
    @Test
    public void testCreditCardType() {
        String numbers = "4234567890345";
        assertEquals("Visa", cc.getCardType(numbers));

    }
    @Test
    public void testCreditCardTypeMasterCard() {
        String answers = "56789345678567";
        assertEquals("MasterCard", cc.getCardType(answers));
    }
    @Test
    public void testCreditCardTypeAmex() {
        String answers = "37789345678567";
        assertEquals("Amex", cc.getCardType(answers));
    }
    @Test
    public void testCreditCardTypeDiscovery() {
        String answers = "67789345678567";
        assertEquals("Discover Card", cc.getCardType(answers));
    }
    @Test
    public void testCreditCardTypeUnknown() {
        String answers = "87789345678567";
        assertEquals("Unknown", cc.getCardType(answers));
    }
}
