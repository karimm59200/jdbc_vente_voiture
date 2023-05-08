package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public  abstract class BaseDAO<T>{
    protected static String request;
    protected static PreparedStatement statement;
    protected final Connection _connection;
    protected static ResultSet resultSet;

    protected BaseDAO(Connection connection) {
        this._connection = connection;
    }
    public abstract boolean save(T element) throws SQLException;
    public abstract T getById(int id) throws SQLException;
    public abstract boolean update(T element) throws SQLException;
    public abstract boolean delete(T element) throws SQLException;
    public abstract List<T> getAll() throws SQLException;

}
