
function Student(name, age) {
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }

    return this.getInfo;
}

/* new를 붙이지 않으면 일반 함수와 차이가 없다.(함수명 첫 글자만 대문자일 뿐) */
const student = Student('강감찬', 35);  // 이때 함수 내부의 this(global 객체)는 생성되는 객체를
                                        // 뜻하는 것이 아님
// console.log(student);

/*
  생성자 함수가 일반 함수와 차이나도록 new 연산자 없이 호출되어도 객체가 생성되는 빌트인 함수로 만들 수 있다. 
  (ES6에서 new.target을 지원함으로써 new 연산자 없이 호출되는 것을 처리할 수 있게 되었다.)
*/
function Dog(name, age) {
    console.log('new.target: ', new.target);        // new.target new 키워드가 담겼는지 유무

    /* new 키워드 없이 함수를 호출 했을 때 'new 함수명'해서 객체가 반환되도록 작성 */
    if(!new.target) {
        return new Dog(name, age);
    }
    this.name = name;
    this.age = age;
}

const dog = Dog('뽀삐', 3);
console.log(dog);

/* 제공되는 빌트인 함수들: Object, String, Number, Boolean, Date, Regex, ... */