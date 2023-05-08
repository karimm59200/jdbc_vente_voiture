package org.example;

import org.example.DAO.CarDAO;
import org.example.DAO.PersonDAO;
import org.example.model.Car;
import org.example.model.Person;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main{
    static IHM ihm = new IHM();
    public static void main(String[] args) {
        ihm.start();
    }
}
/*
public class Main {
    private Connection connection;

    private static String request;


    private static PreparedStatement statement;
    public static void main(String[] args) {
// System.out.println("Hello world!");
        CarDAO carDAO;
        PersonDAO personDAO;

        Connection connection;

        String request;


        PreparedStatement statement;
        Car car1 = new Car("renault 5 ",1980, 60, 1000);
        Car car2 = new Car(1,"tesla",2020, 200, 45000);
        Car car3 = new Car(4,"saaba",1895, 80, 2000);

        Person person1 = new Person( "toto", "tata", 20);
        Person person2 = new Person( 2,"titi", "tutu", 35);
        Person person3 = new Person( 3,"tete", "titi", 35);
        try {
           connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
            personDAO = new PersonDAO(connection);
            if ( personDAO.update(person2)  carDAO.save(car1) personDAO.save(person3)) {
                //System.out.println("personne ajouté " + person3.getIdPerson());
                System.out.println("personne modifiée" + person3.getIdPerson());
                /*carDAO.update(car2);
                carDAO.update(car3);
                carDAO.delete(new Car(5,"",0,0,0));
                personDAO.update(person3);


                connection.commit();
            } else {

                System.out.println("personne non ajouté");
                connection.rollback();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            person1 = null;
        }

    }
}
    */