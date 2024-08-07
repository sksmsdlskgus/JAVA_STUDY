<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1 align="center">Filter</h1>
<h3>필터의 라이프 사이클</h3>
<ul>
  <li><a href="first/filter">Filter 사용하기</a></li>
</ul>

<hr>
<!--build.gradle에 단방향 암호화를 위한 bcrypt 관련 라이브러리 추가ㅣ
(2개의 라이브러리 추가)-->
<h3>필터의 활용</h3>
<form action="member/regist" method="post">
  <label for="test">아이디: </label>
  <input id="test" type="text" name="userId">
  <br>
  <label>비밀번호: </label>
  <input type="password" name="password">
  <br>
  <label>이름: </label>
  <input type="text" name="name">
  <br>
  <button type="submit">가입하기</button>
</form>

</body>
</html>