package repository;

import model.Bank;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRepository {
    private Connection connection;
    //crud create read update delete
    public BankRepository() throws SQLException, ClassNotFoundException {
        connection = InitialConnection.getInstance().getConnection();
    }

    public void add(Bank bank) throws SQLException {
        String insert = "insert into Bank (bankName) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1,bank.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Integer find(String name) throws SQLException {
        String select = "select * from Bank where bankName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
           return resultSet.getInt(1);
        }
        return -1;
    }

    public void update(Bank bank) throws SQLException {
        String update = "update Bank set bankName = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1,bank.getName());
        preparedStatement.setInt(2,bank.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(Bank bank) throws SQLException {
        String delete = "delete from Bank where bankName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setString(1,bank.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
