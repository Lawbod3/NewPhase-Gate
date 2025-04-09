const {
    convertToArray,
    validateLength,
    sumOfArrayAtLastIndex,
    sumOfArrayAtFirstIndex,
    getCardType,
    validateStringOfNumber} = require('./CreditCardMethod.js');

test("Convert string to array", () => {
    let input = "1234567890123456";
    const result = convertToArray(input);
    let answer = [1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6];
    expect(result).toEqual(answer);
});

test("Validate length of array", () => {
    let input = [1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6];
    const result = validateLength(input);
    expect(result).toEqual(true);
});

test("Validate length of array", () => {
    let input = [1,2,3,4,5,6,7,8,9,0,1];
    const result = validateLength(input);
    expect(result).toEqual(false);
});

test("Sum of array at last index", () => {
    let input = [1,1,3,1,5,1,7,1];
    const result = sumOfArrayAtLastIndex(input);
    expect(result).toEqual(4);
});

test("Sum of array at first index", () => {
    let input = [1,2,1,2,1,2,1,1];
    const result = sumOfArrayAtFirstIndex(input);
    expect(result).toEqual(8);
});

test("Get card type", () => {
    let input = "37111111111111111";
    const result = getCardType(input);
    expect(result).toEqual("Amex");
});