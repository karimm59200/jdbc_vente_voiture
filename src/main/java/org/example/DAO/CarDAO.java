package org.example.DAO;

import org.example.DAO.BaseDAO;
import org.example.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDAO extends BaseDAO<Car> {

    private ResultSet resultset;



    public CarDAO(Connection connection) {
        super(connection);
    }


    @Override
    public boolean save(Car element) throws SQLException {
        request = "insert into car (name, year, power, price) values(?,?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getName());
        statement.setInt(2, element.getYear());
        statement.setInt(3, element.getPower());
        statement.setFloat(4, element.getPrice());
        int nbRow = statement.executeUpdate();
        resultset = statement.getGeneratedKeys();
        if (resultset.next()) {
            element.setIdCar(resultset.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public Car getById(int id) throws SQLException {
        Car car = null;
        request = "select * from car where idCar = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultset = statement.executeQuery();
        if (resultset.next()) {
            car = new Car(resultset.getInt("idCar"),
                    resultset.getString("name"),
                    resultset.getInt("year"),
                    resultset.getInt("power"),
                    resultset.getFloat("price"));
        }
        return car;
    }

    @Override
    public boolean update(Car element) throws SQLException {

        request = "update car set name = ?, year = ?, power = ?, price = ? where idCar = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.getName());
        statement.setInt(2,  element.getYear());
        statement.setInt(3, element.getPower());
        statement.setFloat(4, element.getPrice());
        statement.setInt(5, element.getIdCar());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }


    public boolean updateV2(Car car) throws SQLException {

        Optional<Car> element = Optional.ofNullable(getById(car.getIdCar()));
        int nbRow=0;

        if (element.isPresent()){
            element.get().setName(car.getName());
            element.get().setYear(car.getYear());
            element.get().setPower(car.getPower());
            element.get().setPrice(car.getPrice());

        request = "update car set name = ?, year = ?, power = ?, price = ? where idCar = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.get().getName());
        statement.setInt(2,  element.get().getYear());
        statement.setInt(3, element.get().getPower());
        statement.setFloat(4, element.get().getPrice());
        statement.setInt(5, element.get().getIdCar());
        nbRow = statement.executeUpdate();
        }
        else{
            System.out.println("No car found");
        }
        return nbRow == 1;
    }


    @Override
    public boolean delete(Car element) throws SQLException {
        if (element != null)
            request = "delete from car where idCar = ?";
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdCar());
            int nbRow = statement.executeUpdate();
            return nbRow == 1;
        }


    @Override
    public List<Car> getAll()  throws SQLException{
        List<Car> cars = new ArrayList<>();
        request = "select * from car";
        statement = _connection.prepareStatement(request);
        resultset = statement.executeQuery();

        while (resultset.next()) {
            Car c = new Car(resultset.getInt("idCar"), resultset.getString("name"), resultset.getInt("year"), resultset.getInt("power"), resultset.getFloat("price"));
            cars.add(c);
        }
        return cars;
    }
}
