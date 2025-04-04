package oldSnacks;

public class CreditCardMethod {
    public static int[] convertToArray(String numbers) {
        int[] array = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            array[i] = Integer.parseInt(numbers.charAt(i) + "");
        }
      return array;
    }

    public boolean validateLength(String numbers) {
        if(numbers.length() < 13 || numbers.length() > 16)return false;
        return true;

    }
}
