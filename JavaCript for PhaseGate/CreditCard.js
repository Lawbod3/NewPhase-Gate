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

const sumOfArrayLuhmIndex =

console.log(convertToArray("123456789"));
console.log(validateLength("123456789"));
console.log(sumOfArrayAtLastIndex([1,2,1,4,1,6,1,8,1,0,1,12,1]))