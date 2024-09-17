
const user = {
    activate: true,
    login: function() {
        console.log('로그인 되었습니다.');
    }
};

console.log(user.__proto__.constructor === Object);
console.log(user.__proto__ === Object.prototype);

/* __proto__는 권장되지 않고 Object의 getPropertyOf()를 사용하는 것이 권장되고 있다. */
console.log(Object.getPrototypeOf(user) === Object.prototype);

/* 상속 */
const user2 = {
    activate: true,
    login: function() {
        console.log('로그인 실패 되었습니다.');
    }
};
console.log(user2.__proto__);

const student = {
    passion: true
};
console.log(student.__proto__);

/* student의 prototype을 활용한 상속 */
// student.__proto__ = user2;
Object.setPrototypeOf(student, user2);
student.login();

/* 프로토타입 체인 */
const greedyStudent = {
    class: 1,
    __proto__: student
};

console.log(greedyStudent.activate);        // user2에서 상속
console.log(greedyStudent.passion);         // student에서 상속
