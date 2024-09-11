
/* 
  자바스크립트는 객체 지향(기반) 프로그래밍 언어로 원시 값을 제외한 나머지 값 
  (함수, 배열, 정규 표현식 등)은 객체이다.
*/
// var name = '홍씨';
// var age = 10;
var student = {
    name: '유관순',
    age: 16,
    getInfo: function () {

        /* 메소드(객체 안의 함수)에서 프로퍼티를 활용할 때는 this.을 반드시 명시해야 한다. */
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};

console.log(student.getInfo);       // student의 getInfo 프로퍼티에 접근
console.log(student.getInfo());     // 메소드일 경우 실행할 때는 ()를 명시한다.

student.name = '강감찬';
console.log(student.getInfo());