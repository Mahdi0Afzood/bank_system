package repository;

import model.Branch;
import model.Employee;
import model.Person;

import java.sql.*;

public class BranchRepository {
    private Connection connection;
    //crud create read update delete
    public BranchRepository() throws SQLException, ClassNotFoundException {
        connection = InitialConnection.getInstance().getConnection();
    }

    public void add(int id, Branch branch) throws SQLException {
        String insert = "insert into Branch (id_bank,address) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,branch.getAddress());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Branch find(Branch branch) throws SQLException {
        String select = "select * from branch inner join bank b on branch.id_bank = b.id " +
                "inner join employee e on branch.id_boss = e.id " +
                " where b.bankName = ? or  Branch.id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1,branch.getName());
        preparedStatement.setInt(2,branch.getBranchId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Branch(resultSet.getInt("id_bank"),resultSet.getString("bankName"),resultSet.getString("address"),
                resultSet.getInt("phone"),resultSet.getInt("id"),null ,null);
    }

    public void update(Branch branch) throws SQLException {
        String update = "update Branch set address = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1,branch.getAddress());
        preparedStatement.setInt(2,branch.getBranchId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(Branch branch) throws SQLException {
        String delete = "delete from Branch " +
                "where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,branch.getBranchId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
