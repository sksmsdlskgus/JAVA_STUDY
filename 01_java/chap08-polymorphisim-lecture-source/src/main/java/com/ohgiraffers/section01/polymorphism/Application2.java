package com.ohgiraffers.section01.polymorphism;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 다형성을 적용하여 객체배열을 만들어 다양한 인스턴스들을 연속 처리할 수 있다. */
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

//        for (int i = 0; i < animals.length; i++) {
//            animals[i].cry();
//        }

        for (Animal animal : animals) {
            animal.cry();

            /* 설명. 오버라이딩 되지 않은 메소드는 추가 처리가 필요 */
            if(animal instanceof Tiger){        //런타임 에러 방지 코드
                ((Tiger) animal).bite();
            }
            if(animal instanceof Rabbit){
                ((Rabbit) animal).jump();
            }
        }

    }
}
