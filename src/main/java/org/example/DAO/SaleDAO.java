package org.example.DAO;

import org.example.model.Sale;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO extends BaseDAO <Sale> {

    protected SaleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Sale element) throws SQLException {
        request = "insert into sale (idCar, idPerson, date) values(?,?,?)";
        statement = _connection.prepareStatement(request, statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, element.getIdCar());
        statement.setInt(2, element.getIdPerson());
        statement.setDate(3, (Date) element.getDate());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setIdSale(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public Sale getById(int id) throws SQLException {
        Sale sale = null;
        request = "select * from sale where idSale = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, sale.getIdSale());
        resultSet = statement.executeQuery();
        if( resultSet.next()){
            sale = new Sale(resultSet.getInt("idSale"),
                    resultSet.getInt("idPerson"),
                    resultSet.getInt("idCar"),
                    resultSet.getDate("date"));
        }
        return sale;
    }

    @Override
    public boolean update(Sale element) throws SQLException {
        request = "UPDATE sale SET idPerson = ?, idCar = ?, date = ? where idSale = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getIdPerson());
        statement.setInt(2, element.getIdCar());
        statement.setDate(3, (Date)element.getDate());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Sale element) throws SQLException {
        request = "DELETE FROM sale WHERE idSale = ?";
        try{
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdSale());
            int nbRow = statement.executeUpdate();
            if(nbRow ==1){
                System.out.println("la vente a bien été supprimée");
            } else {
                System.out.println("la vente n'existe pas");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Sale> getAll() throws SQLException {
        List<Sale> result = new ArrayList<>();
        request = "SELECT * FROM sale";
        statement= _connection.prepareStatement(request);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Sale sale = new Sale(resultSet.getInt("idSale"),
                    resultSet.getInt("idPerson"),
                    resultSet.getInt("idCar"),
                    resultSet.getDate("date"));
            result.add(sale);
        }
        return null;
    }
}

