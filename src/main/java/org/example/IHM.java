package org.example;

import org.example.DAO.CarDAO;
import org.example.DAO.PersonDAO;
import org.example.DAO.SaleDAO;
import org.example.model.Car;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {

    Scanner scanner;

    String choix;


    private CarDAO carDAO;
    private PersonDAO personDAO;

    private SaleDAO saleDAO;

    private Connection connection;

    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1": createCarAction();
                    break;
                case "2": listAllCarsAction();
                    break;
                case "3": deleteCarAction();
                    break;
                case "4": changeCarAction();
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
                case "11":
                    break;
            }

        } while (!choix.equals("12"));
    }

    private void menu() {
        System.out.println("1- Enregistrer la voiture.");
        System.out.println("2- Lister toutes les voitures.");
        System.out.println("3- Supprimer la voiture.");
        System.out.println("4-Changer de voiture.");
        System.out.println("5-Inscrire une personne.");
        System.out.println("6-Lister toutes les personnes.");
        System.out.println("7- Supprimer la personne.");
        System.out.println("8- Changer de personne.");
        System.out.println("9- Faire une vente.");
        System.out.println("10- Afficher les ventes de voiture.");
        System.out.println("11- Afficher la liste des ventes d'un véhicule pour une personne.");
        System.out.println("Quitter");
    }

    private Car createCarAction() {
        System.out.println("Merci de saisir le nom: ");
        String name = scanner.nextLine();
        System.out.println("Merci de saisir l'année: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir la puissance en chevaux.");
        int power = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir le prix de la voiture.");
        float price = scanner.nextFloat();
        scanner.nextLine();
        Car car = new Car(name, year, power, price);

        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
            if (carDAO.save(car)) {
                System.out.println("voiture ajouté " + car.getIdCar());
                connection.commit();
            } else {
                car = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            car = null;
        }
        return car;
    }

    public void listAllCarsAction(){
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
            carDAO.getAll().forEach(System.out::println);
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean deleteCarAction(){
        System.out.println("Merci de saisir l'id de la voiture à supprimer.");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
            if (carDAO.delete(carDAO.getById(id))) {
                System.out.println("voiture supprimée");
                connection.commit();
            } else {
                System.out.println("voiture non supprimée");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void changeCarAction(){
        System.out.println("Merci de saisir l'id de la voiture à modifier.");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            carDAO = new CarDAO(connection);
            Car car = carDAO.getById(id);
            System.out.println("Merci de saisir le nom: ");
            String name = scanner.nextLine();
            System.out.println("Merci de saisir l'année: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Merci de saisir la puissance en chevaux.");
            int power = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Merci de saisir le prix de la voiture.");
            float price = scanner.nextFloat();
            scanner.nextLine();
            car.setName(name);
            car.setYear(year);
            car.setPower(power);
            car.setPrice(price);
            if (carDAO.update(car)) {
                System.out.println("voiture modifiée");
                connection.commit();
            } else {
                System.out.println("voiture non modifiée");
            } connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}