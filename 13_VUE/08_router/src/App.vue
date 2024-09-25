<template>
<header>
  <h1>Router 사용하기</h1>
 <hr>
 <div class="wrapper">
  <!--  to를 이용해서 경로 설정
     replace속성은 브라우저의 히스토리 스택을 대체하여 뒤로가기를 방지한다.  
  <h2>basic router</h2>
  <nav>
      <RouterLink to="/" active-class="active" replace>Home</RouterLink>  
        <RouterLink to="/pathvariable/1" active-class="active" replace>PathVariable</RouterLink>  
        <RouterLink to="/querystring?name=홍길동&age=20" active-class="active" replace>QueryString</RouterLink>
  </nav> -->

  <h2>nested router</h2>
  <nav>
    <RouterLink to="/" active-class="active" replace>Home</RouterLink> 
    <RouterLink to="/nested/home" active-class="active" replace>중첩 home</RouterLink>
    <RouterLink to="/nested/View" active-class="active" replace>중첩 view</RouterLink>
  </nav>

 </div>
</header>
<main>
  <!-- 라우터 뷰로 정의해 여기가 바뀐다는걸 정의 -->
<RouterView/>  
<!--  컴포넌트 자체가 페이지가 되며 컴포넌트 폴더에 파일을 만들지 않는다. -->
</main>
</template>

<script setup>
import { RouterView, RouterLink } from 'vue-router'; // 라우터 뷰 임포트


</script>

<style scoped>
nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
  font-size: 30px;
}

a {
  margin-left: 10px;
}

.active {
  color: red;
}

main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

header {
  text-align: center;
}
</style>