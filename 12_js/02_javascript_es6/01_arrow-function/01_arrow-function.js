
/* 화살표 함수의 특징 */

/* 
  1. 콜백함수로 화살표 함수를 사용하게 되면 해당 화살표 함수가 사용되는 곳에
     따라 this의 의미가 정해진다.
     (반드시 써야하는 경우) 
*/
let theater = {
    store: '강남점',
    titles: ['베테랑2', '룩백', '그녀에게', '캐시아웃', '빅토리'],
    showMovieList() {
        this.titles.forEach(

            /* 화살표 함수(콜백)에서의 this는 showMovieList를 호출한 객체 */
            title => console.log(this.store + ": " + title) // 화살표 함수의 this는 원래 대상이 없다.
        );
    }

    // showMovieList() {
    //     this.titles.forEach(
               
               /* 단순 익명함수(콜백)의 this는 global 객체를 말한다. */
    //         function(title) {
    //             console.log(this.store + ": " + title)
    //         }
    //     );
    // }
};

theater.showMovieList();

/* 2. 화살표 함수는 new 연산자와 함께 사용할 수 없다.(생성자 함수로 쓰일 수 없다.) */
const arrowFunc = () => {};
const normalFunc = function() {

};

// new arrowFunc();         // 에러 발생
new normalFunc();

/* 
  3. 화살표 함수는 arguments를 지원하지 않는다.
     (외부 함수의 arguments가 있다면 외부 함수 것이 적용될 순 있음) 
*/
let test = function () {
    console.log('normal outer: ', arguments);
    const arrowFunc = () => console.log('arrow inner: ', arguments);
    arrowFunc(10, 20);
}

test(1, 2, 3, 4, 5);