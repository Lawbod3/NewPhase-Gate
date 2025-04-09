const {
    convertToArray,
    validateLength,
    sumOfArrayAtLastIndex,
    sumOfArrayAtFirstIndex,
    getCardType,
    validateStringOfNumber} = require('./CreditCardMethod.js');


const prompt = require('prompt-sync')();


console.log("App to validate CreditCard");
let creditCardNumber = prompt("Please enter the credit card number: ");
while(!validateStringOfNumber(creditCardNumber) || !validateLength(creditCardNumber)){
    console.log("Wrong card input, try again: ");
    creditCardNumber = prompt();
}

array = convertToArray(creditCardNumber);
sumOne = sumOfArrayAtLastIndex(array);
sumTwo = sumOfArrayAtFirstIndex(array);
total = sumOne + sumTwo;

validate = false;

if (total % 10 == 0) {
    validate = true;
}

result = validate ? "valid" : "inValid";

if (result == "valid") {
    const text = `
****Credit Card Type: ${getCardType(creditCardNumber)}
****Credit Card number: ${creditCardNumber}
****Credit Card Digit Length: ${creditCardNumber.length}
****Credit Card Validity Status: ${result}
    `;

    console.log(text);
}
else{
    const text = `
*****Credit Card Type: Invalid Card
*****Credit Card number: ${creditCardNumber}
*****Credit Card Digit Length: ${creditCardNumber.length}
*****Credit Card Validity Status: ${result}
            `;
    console.log(text);
    console.log("Please try again with a valid card number.");
    console.log("Thank you for using the Credit Card Validator App!");
}

