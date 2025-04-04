package oldSnacks;

public class CreditCardMethod {
    public static int[] convertToArray(String numbers) {
        int[] array = new int[numbers.length()];
        for (int count = 0; count < numbers.length(); count++) {
            array[count] = Integer.parseInt(numbers.charAt(count) + "");
        }
      return array;
    }

    public boolean validateLength(String numbers) {
        if(numbers.length() < 13 || numbers.length() > 16)return false;
        return true;
    }

    public int sumofArrayFromLastIndex(int[] numbers) {
        int sum = 0;
        for(int count = numbers.length - 1; count >= 0; count -= 2) {
            sum += numbers[count];
        }
        return sum;
    }

    public int sumofArrayLuhmPrincipleIndex(int[] numbers) {
        int sum = 0;
        for(int count = numbers.length - 2; count >= 0 ; count -= 2) {
            int temp = numbers[count] * 2;
            if( temp > 9){
                temp= temp - 9;
            }
            sum += temp;
        }
        return sum;
    }

    public boolean validateStringOfNumbers(String numbers) {
        if(!numbers.matches("^[0-9]+$")) return false;
        return true;
    }

    public String getCardType(String number) {
        if(number.charAt(0) == '4')return "Visa";
        else if(number.charAt(0) == '5') return "MasterCard";
        else if(number.charAt(0) == '6') return "Discover Card";
        else if(number.charAt(0)  == '3' && number.charAt(1) == '7') return "Amex";
        return "Unknown";
    }


}
