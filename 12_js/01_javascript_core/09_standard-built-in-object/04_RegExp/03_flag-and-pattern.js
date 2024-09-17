
/*
  flag의 종류
  i(case Insensitive): 대소문자를 구별하지 않고 패턴 적용
  g(Global): 대상 문자열 텍스트 내에서 패턴과 일치하는 모든 문자열을 전역 검색
  m(multi line): 문자열의 행이 바뀌더라도 패턴 검색을 계속
*/

let target = 'Java JavaScript';

console.log(target.match(/VA/));
console.log(target.match(/VA/i));
console.log(target.match(/VA/ig));
console.log('--------------------');

/* .: 임의의 문자열 한 개 */
target = 'abcdefg';
console.log(target.match(/../g));

let arr = target.match(/../g);
console.log(arr[1]);
console.log('--------------------');

/* {m, n}: 최소 m번, 최대 n번 반복되는 문자열(반복 검색) */
target = 'a aa aaa b bb bbb bbbb ab aab abb';
console.log(target.match(/a{2,3}/g));
console.log(target.match(/b{2}/g));
console.log(target.match(/b{3,}/g));

/* +: 앞선 패턴이 최소 한번 이상 반복되는 문자열 */
console.log(target.match(/b+/g));
console.log(target.match(/b{1,}/g));
console.log('--------------------');

/* ?: 앞선 패턴이 없가나 하나 있는 문자열 */
target = 'soul seoul seeoul';
console.log(target.match(/se?oul/g));
console.log(target.match(/se{0,1}oul/g));

/* |: or, []: or */
target = 'aa bb cc dd 123 456 _@';
console.log(target.match(/a|b/g));
console.log(target.match(/[ab]/g));
console.log(target.match(/a+|b+/g));

/* 하이픈(-)은 아스키코드 또는 유니코드의 범위 */
console.log(target.match(/[a-zA-Z]/g));
console.log('--------------------');

/* \d: 숫자 */
console.log(target.match(/[0-9]+/g));
console.log(target.match(/\d+/g));

/* \D: 숫자가 아닌 문자 */
console.log(target.match(/[^0-9]+/g));
console.log(target.match(/\D+/g));
console.log('--------------------');

/* \w: 알파벳, 숫자, 언더스코어 */
/* \W: \w의 반대 */
console.log(target.match(/\w+/g));          // 알파벳, 숫자, 언더스코어가 있는 문자
console.log(target.match(/\W+/g));          // 그 외의 특수기호
console.log('--------------------');

/* ^: 시작 위치([] 안에서는 not을 뜻함), $: 마지막 위치 */
target = 'https://www.google.com/https';
console.log(target.match(/^https/g));
console.log(target.match(/https$/g));

/* (): 그룹(한번에 고려될 묶음) */
target = 'test tesk tesa';
console.log(target.match(/test|tesk|tesa/g));
console.log(target.match(/tes(t|k|a)/g));

target = 'RegExp was created by gskinner.com, and is proudly hosted by Media Temple.';
console.log(target.match(/[a-zA-Z.]+$/g));


