
/* 유한한 값인가? */
console.log(global.isFinite(10));
console.log(global.isFinite(Infinity));

/* NaN인가? */
console.log(global.isNaN(NaN));
console.log(global.isNaN(10));

/*
  js에서 uri경로 상에 한글이 포함된 값을 처리해야 할 경우라면 encoding 또는 decoding을 하기 위해
  전역객체에서 사용하는 메소드를 활용할 수 있다.
*/
const uriComp = 'name=홍길동&job=student';
const encComp = encodeURIComponent(uriComp);
console.log(encComp);

const decComp = decodeURIComponent(encComp);
console.log(decComp);

