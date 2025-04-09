const convertToArray = function (input) {
        let array = [];
        for( count = 0; count < input.length; count++) {
            array[count] = parseInt(input.charAt(count));
        }
          return array;
}

const validateLength = function (input) {
    if(input.length < 13 || input.length > 16)return false
    return true;

}

const sumOfArrayAtLastIndex = function (array) {
    sum = 0;
    for(count =  array.length - 1; count >= 0; count -= 2){
        sum += array[count];
    }
    return sum;
}

const sumOfArrayAtFirstIndex = function (array) {
    sum = 0;
    for(count =  array.length - 2; count > 0 ; count -= 2){
        let temp = array[count] * 2;
        if(temp > 9){
            temp = temp - 9;
        }
        sum  += temp;
    }
    return sum;

}

const getCardType = function ( number) {
    if(number.charAt(0) === '4')return "Visa";
    else if(number.charAt(0) === '5') return "MasterCard";
    else if(number.charAt(0) === '6') return "Discover Card";
    else if(number.charAt(0)  === '3' && number.charAt(1) === '7') return "Amex";
    return "Unknown";

}
const validateStringOfNumber = function (number) {
    if(!/"^[0-9]+$"/.test(number)) return false;
    return true;
}
