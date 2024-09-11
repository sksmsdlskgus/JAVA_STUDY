
/* 1. OR의 경우 */
console.log('apple' || 'banana');
console.log('' || 'banana');
console.log('apple' || false);

/* 2. AND의 경우 */
console.log('apple' && 'banana');
console.log(false && 'banana');
console.log('apple' && false);

/* 3. 단축 평가 구문 */
var num = 3;
num % 2 == 0 && console.log('짝수입니다.'); // &&는 왼쪽이 맞으면 오른쪽이 실행
num % 2 == 0 || console.log('홀수입니다.'); // ||은 왼쪽이 틀리면 오른쪽이 실행

// if(num % 2 == 0) {
//     console.log('짝수입니다');
// } else {
//     console.log('홀수입니다');
// }
