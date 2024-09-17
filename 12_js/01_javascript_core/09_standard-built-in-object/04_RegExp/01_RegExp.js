
/* 정규 표현식 */
let regex = /j/i;    // 패턴: j, 플래그 옵션: i => 대소문자 구별 없이
regex = new RegExp('j', 'i');
regex = new RegExp(/j/, 'i');
regex = new RegExp(/j/i);

let target = 'JavaScript';

/* test 메소드: 정규표현식 regex의 패턴을 확인하여 매칭 결과를 boolean으로 반환 */
console.log(regex.test(target));