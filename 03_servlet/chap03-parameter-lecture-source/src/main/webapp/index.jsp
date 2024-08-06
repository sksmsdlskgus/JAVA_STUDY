<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 align="center">Request Parameter</h1>
<h3>GET 방식의 요청</h3>
<h4>from 태그를 이용한 get 방식 요청</h4>
<form action="querystring" method="get">
    <label>이름: </label><input type="text" name="name"> <br>
    <label>나이: </label><input type="number" name="age"> <br>
    <label>생일: </label><input type="date" name="birthday"> <br>
    <label>성별: </label><br>
    <label for="male">남자</label>
    <input type="radio" name="gender" id="male" value="M"> <br>
    <label for="female">여자</label>
    <input type="radio" name="gender" id="female" value="W"> <br>
    <label>국적: </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie">영화</label>
    <input type="checkbox" name="hobbies" id="music" value="music">음악</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep">취침</label>
    <br>

  <!--<input type="submit" value="GET 요청"> 이랑 똑같다.-->
  <!--<button type="submit">GET 요청</button> 이랑 똑같다.-->
    <button>GET 요청</button> <!-- 버튼 태그는 type 을 생략하면 기본이 submit 버튼이다.-->
</form>

<h4>a 태그의 href 속성에 직접 파라미터를 포함한 쿼리스트링 방식으로 작성하여 get 방식 요청하기</h4>
<a href="http://localhost:8080/chap03/querystring?name=%EC%9D%B4%EB%82%98%EC%A7%B1&age=23&birthday=2002-03-28&gender=W&national=ko&hobbies=music&hobbies=sleep">a 태그를 활용한 쿼리스트링 값 전달</a>

<h4>form 태그를 이용한 post 방식 요청</h4>
<form action="formdate" method="post">
    <label>이름: </label><input type="text" name="name"> <br>
    <label>나이: </label><input type="number" name="age"> <br>
    <label>생일: </label><input type="date" name="birthday"> <br>
    <label>성별: </label><br>
    <label for="male">남자</label>
    <input type="radio" name="gender" id="male" value="M"> <br>
    <label for="female">여자</label>
    <input type="radio" name="gender" id="female" value="W"> <br>
    <label>국적: </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie">영화</label>
    <input type="checkbox" name="hobbies" id="music" value="music">음악</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep">취침</label>
    <br>

    <button>POST 요청</button>
</form>

</body>
</html>