package repository;

import model.Account;
import model.AccountType;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    private Connection connection;

    public AccountRepository() throws SQLException, ClassNotFoundException {
        this.connection = InitialConnection.getInstance().getConnection();
    }

    public boolean add(int id, Account account) throws SQLException {
        String insert = "insert into account values (default , ? , ? , ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, account.getAccountType().name());
        preparedStatement.setDouble(3, account.getBalance());
        return preparedStatement.executeUpdate() > 0;
    }

    public Account find(int id) throws SQLException {
        String select = "select * from account " +
                "where id_client = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
            return new Account(resultSet.getInt("id"), resultSet.getInt("id_client") , AccountType.valueOf(resultSet.getString("account_type")),
                    resultSet.getDouble("balance"));

    }


    public void findAll() throws SQLException {
        String selectAll = "select * from account " ;
        PreparedStatement preparedStatement = connection.prepareStatement(selectAll);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(
                    "id account   :"+resultSet.getInt("id") +
                    "\nid client    :"+resultSet.getInt("id_client")+
                    "\naccount type :"+resultSet.getString("account_type")+
                    "\nbalance      :"+resultSet.getDouble("balance")+
                    "\n--------------------------------");
        }
    }

    public boolean update(Account account) throws SQLException {
        String update = "update account set account_type = ? , balance = ? " +
                " where id_client = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, account.getAccountType().name());
        preparedStatement.setDouble(2, account.getBalance());
        preparedStatement.setInt(3, account.getId_client());
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean delete(int id) throws SQLException {
        String delete = "delete from account where id_client = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

}
