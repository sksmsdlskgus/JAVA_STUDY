package com.ohgiraffers.section04.constructor;

public class User { // 1. 얘를 먼저 기본값 null이 들어가서 객체를 채워줌
    private String id = "이나짱"; //참조 자료형
    private String pwd = "1234";
    private String name;
    private java.util.Date enrollDate;

    /* 설명. 기본 생성자 (매개변수가 없는)를 활용한 객체 생성 -> 기본으로 무조건, 명시적으로 생성하기를 */
    public User(){ // 2. 그후 (기본생성자) 얘를 활용해서 객체 생성하는데  얘가 작동이 완료가 되면 객체가 생성됨
        System.out.println("User 객체가 생성됨~"); // 확인용
        // 확인만 하는건 의미없으니까 아래에 매개변수가 들어간 메소드를 생성해보자
    }

    public User(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    /* 설명. 원하는 필드를 초기화 하는 매개변수 잇는 생성자를 활용한 객체 생성  */
    public User(String id, String pwd, String name, java.util.Date enrollDate) {

        /* 설명.  생성자 내부의 this.은 이 생성자로 생성 될 객체를 뜻한다. */
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;

        /* 설명. this()를 통해 다른 생성자를 활용하여 코드의 줄 수를 줄일 수 있다. */
        /* 설명. this()를 통해 다른 생성자를 활용할 때는 "한번만" 코드 "첫 줄"에서 활용할 수 있다. */
        this(id, pwd, name);
        // 안써도 되는데 ()와 .의 차이를 그냥 알려고
        // -> 코드의 줄수를 줄이기 위해
        this.enrollDate = enrollDate;
    }

    public String information(){ // 접근제어 때문에 이렇게 확인 메소드를 생성해 확인함
        return "id: "+ this.id + " pwd: " + this.pwd + " name: " + this.name + " enrollDate: " + this.enrollDate;
    }

}
