
/*
  일급객체의 특징
  1. 무명의 리터럴로 생성할 수 있다. 즉, 런타임에 생성이 가능하다. 
  2. 변수나 자료구조(객체, 배열 등)에 저장할 수 있다. 
  3. 함수의 매개변수로 전달할 수 있다. 
  4. 함수의 반환값으로 사용할 수 있다. 
*/

/* 1, 2번 특징 */
var hello = function() {
    return '안녕하세요';
};

/* 3번 특징 */
function repeat(func, count) {
    for(var i = 0; i < count; i++) {
        console.log(func());
    }

    /* 4번 특징 */
    return function() {
        console.log(`${count}번 반복 완료`);
    }
}

repeat(hello, 5)();