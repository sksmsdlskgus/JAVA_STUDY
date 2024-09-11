
/*
  ES11(ECMA11(2020))에서 도입된 연산자로 연산자의 좌항이 null 또는 undefined인 경우
  에러 대신 undefined를 반환하고 그렇지 않으면 우항의 프로퍼티 참조를 이어간다.
*/
var obj = null;
// var obj = {
//     'value': 'abc'
// }

var val = obj?.value;   // npe(null pointer exception) 방지코드
console.log(val);

var str = '';
var len = str?.length;
console.log(len);