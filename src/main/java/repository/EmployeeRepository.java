package repository;

import model.Employee;
import model.EmployeeType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository {
    private Connection connection;

    public EmployeeRepository() throws SQLException, ClassNotFoundException {
        this.connection = InitialConnection.getInstance().getConnection();
    }

    public Employee findByUP(String username , String password) throws SQLException {
        String select = "select * from employee inner join person p on " +
                "employee.id_person = p.id " +
                " where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Employee(resultSet.getInt("id"),resultSet.getString("first_name"),resultSet.getString("last_name"),
                resultSet.getString("address"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getDate("birth_date"),
                resultSet.getInt("nationalCode"),resultSet.getInt("phone"),EmployeeType.valueOf(resultSet.getString("employeeType").toUpperCase()));
    }
}
