package org.example.model;

import java.util.Date;

public class Sale {
    private int idSale;
    private int idCar;
    private int idPerson;
    private Date date;

    public Sale(int idSale, int idCar, int idPerson, Date date) {
        this.idSale = idSale;
        this.idCar = idCar;
        this.idPerson = idPerson;
        this.date = date;
    }

    public Sale(int idCar, int idPerson, Date date) {
        this.idCar = idCar;
        this.idPerson = idPerson;
        this.date = date;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", idCar=" + idCar +
                ", idPerson=" + idPerson +
                ", date=" + date +
                '}';
    }
}
