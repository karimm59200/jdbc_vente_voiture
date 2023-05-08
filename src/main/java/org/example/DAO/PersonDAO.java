package org.example.DAO;

import org.example.model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends BaseDAO<Person>{
    public PersonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Person element) throws SQLException {
        request = "insert into person ( firstName, lastName, age) values(?,?,?)";
        statement = _connection.prepareStatement(request, statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setInt(3, element.getAge());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setIdPerson(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public Person getById(int id) throws SQLException {
        Person person = null;
        request = "select * from person where idPerson = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, person.getIdPerson());
        if(resultSet.next()) {
            person = new Person(resultSet.getInt("idPerson"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getInt("age"));
        }
        return person;
    }

    @Override
    public boolean update(Person element) throws SQLException {
        request = "update person set firstName = ?, lastName = ?, age = ? where idPerson = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setInt(3, element.getAge());
        statement.setInt(4, element.getIdPerson());
        int nbRow = statement.executeUpdate();
        if(nbRow == 1){
            System.out.println("la personne a bien été modifiée");
        } else {
            System.out.println("la personne n'existe pas");
        }
        return false;
    }

    @Override
    public boolean delete(Person element) throws SQLException {
        request = "delete from person where idPerson = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdPerson());
            int nbRow = statement.executeUpdate();
            if (nbRow == 1) {
                System.out.println("la personne a bien été supprimée");
            } else {
                System.out.println("la personne n'existe pas");
            }
        } catch (SQLException e) {
            /*La méthode printStackTrace() en Java est un outil utilisé pour gérer les exceptions et les erreurs.
            Il s’agit d’une méthode de la classe « throwable » de Java qui affiche l’exception avec d’autres détails
            comme le numéro de ligne et le nom de la classe où l’exception s’est produite.
            La méthode printStackTrace() est très utile pour diagnostiquer les exceptions.
            Par exemple, si une méthode dans votre code provoque une exception,
            printStackTrace() localisera la ligne exacte dans laquelle la méthode a levé l’exception.*/
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Person> getAll() throws SQLException {
        List<Person>  result = new ArrayList<>();
        request = "select * from person";
        statement = _connection.prepareStatement(request);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()){
             Person person = new Person(resultSet.getInt("idPerson"),
                     resultSet.getString("firstName"),
                     resultSet.getString("lastName"),
                     resultSet.getInt("age"));
             result.add(person);
         }
        return result;
    }
}
