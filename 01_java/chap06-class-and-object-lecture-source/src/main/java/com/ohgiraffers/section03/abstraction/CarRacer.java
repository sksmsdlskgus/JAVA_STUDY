package com.ohgiraffers.section03.abstraction;

public class CarRacer {
    private Car myCar = new Car();

    public void starUp() {
       this.myCar.startUp();
    }

    public void stepAccelator() {
        this.myCar.go();
    }

    public void stepBreak() {
        this.myCar.stop();
    }

    public void turnOff() {
        this.myCar.turnOff();
    }
}
