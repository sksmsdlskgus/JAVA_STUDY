package com.ohgiraffers.section04.testapp.aggregate;

import java.io.Serializable;
import java.util.Arrays;

public class Member implements Serializable {
    private String memee;
    private String id;
    private String pwq;
    private int age;
    private String[] hobbies;
    private BloodType bloodType;


    public Member() {
    }

    public Member(String memee, String id, String pwq, int age, String[] hobbies, BloodType bloodType) {
        this.memee = memee;
        this.id = id;
        this.pwq = pwq;
        this.age = age;
        this.hobbies = hobbies;
        this.bloodType = bloodType;
    }

    public String getMemee() {
        return memee;
    }

    public String getId() {
        return id;
    }

    public String getPwq() {
        return pwq;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memee='" + memee + '\'' +
                ", id='" + id + '\'' +
                ", pwq='" + pwq + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", bloodType=" + bloodType +
                '}';
    }
}
