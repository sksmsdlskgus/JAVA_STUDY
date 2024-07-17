package com.ohgiraffers.section01.extend;


public class Car {

    private boolean runingStatus;

    public Car(){
        super();
        System.out.println("Car 클래스의 기본 생성자 호출됨...");
    }

    public void run(){
        runingStatus = true;
        System.out.println("자동차가 달리기 시작합니다.");
    }

    public void soundHorn(){
        if(runingStatus){
            System.out.println("빵! 빵!");
        } else {
            System.out.println("주행중이 아닐 때는 경적을 울릴 수 없습니다.");
        }
    }

    public boolean isRunning() {
        return runingStatus;
    }

    public void stop(){
        runingStatus = false;
        System.out.println("자동차가 멈춥니다.");
    }
}
