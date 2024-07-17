package com.ohgiraffers.section01.section02.superkeyword;

import java.util.Date;

public class Computer extends Product{
    private String cpu;
    private int hd;
    private int ram;
    private String operatingSystem;

    public Computer() {
        super();
    }

    public Computer(String cpu, int hd, int ram, String operatingSystem) {
        super();
        this.cpu = cpu;
        this.hd = hd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }

    public Computer(String code, String brand, String name, int price, Date manufaturingDate, String cpu, int hd, int ram, String operatingSystem) {
        super(code, brand, name, price, manufaturingDate);
        this.cpu = cpu;
        this.hd = hd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
//        return "Computer{" +
//                "code=" + this.getCode() + // 메소드 이름이 같으면 super를 명시.
//                ", brand=" + getBrand() + // 다르면 this를 쓰든 생략을 하든 상관 ㄴㄴ
//                ", name=" + super.getName() +
//                ", price=" + super.getPrice() +
//                ", manufaturingDate=" + super.getManufaturingDate() +
//                "cpu='" + cpu + '\'' +
//                ", hd=" + hd +
//                ", ram=" + ram +
//                ", operatingSystem='" + operatingSystem + '\'' +
//                '}';
        return super.toString() +
                "Computer{" +
                "cpu='" + cpu + '\'' +
                ", hd=" + hd +
                ", ram=" + ram +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}

