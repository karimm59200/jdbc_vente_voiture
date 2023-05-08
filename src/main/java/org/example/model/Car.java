package org.example.model;

import java.util.Date;

public class Car {
    private int idCar;
    private String name;
    private int year;
    private int power;
    private float price;

    public Car(int idCar, String name, int year, int power, float price) {
        this.idCar = idCar;
        this.name = name;
        this.year = year;
        this.power = power;
        this.price = price;
    }

    public Car(String name, int year, int power, float price) {
        this.name = name;
        this.year = year;
        this.power = power;
        this.price = price;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", power=" + power +
                ", price=" + price +
                '}';
    }
}
