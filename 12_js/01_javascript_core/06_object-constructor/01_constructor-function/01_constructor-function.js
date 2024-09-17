
/* 1. 객체 리터럴 방식 */
const student1 = {
    name: '유관순',
    age: 16,
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다`;
    }
};

const student2 = {
    name: '홍길동',
    age: 20,
    getInfo: function() {
        return `${this.name}(은)는 ${this.age}세 입니다`;
    }
};

/* 객체 리터럴 방식으로 수백명의 학생 객체를 만들어야 된다면? */

/* 2. 생성자 함수 방식(자바의 클래스 + 생성자) */
function Student(name, age) {
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
}

const student3 = new Student('장보고', 30);
const student4 = new Student('신사임당', 40);

console.log(student3.getInfo());
console.log(student4.getInfo());


