package org.example.model;

public class Person {
    private int idPerson;
    private String firstName;
    private String lastName;
    private int Age;

    public Person(int idPerson, String firstName, String lastName, int age) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        Age = age;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        Age = age;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Age=" + Age +
                '}';
    }
}
