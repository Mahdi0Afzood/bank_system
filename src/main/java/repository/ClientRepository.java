package repository;

import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepository {
    private Connection connection;

    public ClientRepository() throws SQLException, ClassNotFoundException {
        connection = InitialConnection.getInstance().getConnection();
    }

    public boolean add(int id) throws SQLException {
        String insert = "insert into Client (id_person) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate()>0;
    }

    public int findByUser(String username) throws SQLException {
        String select = "select * from client inner join person p on client.id_person = p.id " +
                "where p.username=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");

    }


}
