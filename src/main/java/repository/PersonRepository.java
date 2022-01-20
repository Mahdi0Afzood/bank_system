package repository;

import model.EmployeeType;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepository {
    private Connection connection;
    //crud create read update delete
    public PersonRepository () throws SQLException, ClassNotFoundException {
        connection = InitialConnection.getInstance().getConnection();
    }

    public boolean add(Person person) throws SQLException {
        String insert = "insert into Person values (default,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1,person.getFirstName());
        preparedStatement.setString(2,person.getLastName());
        preparedStatement.setString(3,person.getUsername());
        preparedStatement.setString(4,person.getPassword());
        preparedStatement.setString(5,person.getAddress());
        preparedStatement.setDate(6,person.getBirthDate());
        preparedStatement.setInt(7,person.getNationalCode());
        preparedStatement.setInt(8,person.getPhone());
        return preparedStatement.executeUpdate()>0;
    }

    public Person findByUser(String username) throws SQLException {
        String select = "select * from Person  " +
                " where username = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Person(resultSet.getInt("id"),resultSet.getString("first_name"),resultSet.getString("last_name"),
                resultSet.getString("address"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getDate("birth_date"),
                resultSet.getInt("nationalCode"),resultSet.getInt("phone"));

    }



    public void update(int id, Person person) throws SQLException {
        String update = "update Person set " +
                "(firstName , lastName , nationalCode , birthDate , phone , adress) = (?,?,?,?,?,?) " +
                "where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1,person.getFirstName());
        preparedStatement.setString(2,person.getLastName());
        preparedStatement.setInt(3,person.getNationalCode());
        preparedStatement.setDate(4,person.getBirthDate());
        preparedStatement.setInt(5,person.getPhone());
        preparedStatement.setString(6,person.getAddress());
        preparedStatement.setInt(7,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(int id) throws SQLException {
        String delete = "delete from Person where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
