/* 1. 숫자 1, 문자 '1', true 비교 */
console.log(`1 == 1: ${ 1 == 1 }`);
console.log(`1 == true: ${ 1 == true }`);
console.log(`1 == '1': ${ 1 == '1' }`);
console.log(`1 === '1': ${ 1 === '1' }`);  // 자료형까지 고려하여 동일한지는 '==='로 비교한다.

/* 2. NaN는 자신과 일치하지 않는 유일한 값이다. */
console.log(`NaN == NaN: ${NaN == NaN}`);
console.log(`NaN === NaN: ${NaN === NaN}`);

console.log(`Number.isNaN(NaN): ${Number.isNaN(NaN)}`);

/* 3. 일치하지 않는 값 비교 */
console.log(`1 != '1': ${1 != '1'}`);
console.log(`1 !== '1': ${1 !== '1'}`);

