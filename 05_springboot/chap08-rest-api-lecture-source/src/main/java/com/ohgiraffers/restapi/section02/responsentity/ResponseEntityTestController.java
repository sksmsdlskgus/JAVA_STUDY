package com.ohgiraffers.restapi.section02.responsentity;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {

    /* 필기.
    *   ResponseEntity란?
    *   HttpRequest를 응답하기 위해  httpEntity를 상속받아 HttpStatus,HttpHeaders,HttpBody,  */

    private List<UserDTO> users;

    public ResponseEntityTestController() {
        this.users = new ArrayList<>();

        users.add(new UserDTO(1,"user01","pass01","이나짱",new java.util.Date()));
        users.add(new UserDTO(2,"user02","pass02","이나련",new java.util.Date()));
        users.add(new UserDTO(3,"user03","pass03","현나이",new java.util.Date()));
    }

    /* 설명. 1. 직접 ResponseEntity 객체 만들기 */
    @GetMapping("users")
    public ResponseEntity<ResponseMessage>findAllUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("users",users);
        ResponseMessage responseMessage = new ResponseMessage(200,"조회성공!!",responseMap);

        return new ResponseEntity<>(responseMessage,headers, HttpStatus.OK);
    }

    /* 설명. 2. 빌더를 활용한 메소드 체이닝 방식으로 ResponseEntity 객체 만들기(요즘 유행)*/
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        /* 설명. 요청 리소스(회원 번호와 일치하는 회원 한명)를 추출 */
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).collect(Collectors.toList()).get(0);

        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("user",foundUser);

        return ResponseEntity.ok().headers(headers).body(new ResponseMessage(200,"조회성공!",responseMap));
    }

    /* 설명. json문자열 받아 파싱하기(feat.커맨드 객체)
    *   설명.
    *     기존에 우리가 배웠던 @ResquestParam과 달리 json 문자열이 핸들러 메소드로 넘어올 때는 @RequestBody를 붙이고,
    *     json 문자열의 각 프로퍼티 별로 받을 수도 있지만 하나의 타입으로 다 받아낼 때는 커맨드 객체(userDTO)를 활용해야 하며
    *     커맨드 객체는 json 문자열의 프로퍼티명과 일치해야 한다.
    * */
    @PostMapping("users")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO newUser){
        /* 설명. auto_increment가 안되니 soft delete를 가정하여 마지막 회원 번호 +1로 newUser에 추가하기 */
        int lastUserNo = users.get(users.size()-1).getNo(); // 컬렉션에 쌓인 마지막 회원 번호
        newUser.setNo(lastUserNo+1);     //마지막 회원 번호 +1

        users.add(newUser);

        /* 설명. created를 통해 Response Header에 Location이라는 속성으로 생성된 리소스를 찾아갈 경로를 제시할 수 있다. */
        return ResponseEntity
                .created(URI.create("/entity/users/" + users.get(users.size() -1).getNo())).build();
    }

    @PutMapping("users/{userNo}")
    public ResponseEntity<?> modifyUser(@RequestBody UserDTO modifyUser, @PathVariable int userNo) {

        UserDTO foundUser =
                users.stream().filter(user -> user.getNo() == userNo)
                        .collect(Collectors.toList())
                        .get(0);

        foundUser.setId(modifyUser.getId());
        foundUser.setPwd(modifyUser.getPwd());
        foundUser.setName(modifyUser.getName());

        return ResponseEntity
                .created(URI.create("/entity/users/" + userNo))   // Response Header의 Location 정보 제공을 위해
                .build();
    }

    @DeleteMapping("users/{userNo}")
    public ResponseEntity<?> removeUser(@PathVariable int userNo) {
        UserDTO foundUser =
                users.stream().filter(user -> user.getNo() == userNo)
                        .collect(Collectors.toList())
                        .get(0);

        users.remove(foundUser);

        return ResponseEntity.noContent().build();
    }

}


