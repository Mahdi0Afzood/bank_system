package repository;

import model.CreditCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreditCardRepository {
    private Connection connection;

    public CreditCardRepository() throws SQLException, ClassNotFoundException {
        this.connection = InitialConnection.getInstance().getConnection();
    }

    public boolean add(int id, CreditCard creditCard) throws SQLException {
        String insert = "insert into creditcard values (default , ? , ? , ? , ? , ? , ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,creditCard.getCardNumber());
        preparedStatement.setInt(3,creditCard.getPassword());
        preparedStatement.setInt(4,creditCard.getCvv2());
        preparedStatement.setDate(5,creditCard.getStartDate());
        preparedStatement.setDate(6,creditCard.getExpiredDate());
        return preparedStatement.executeUpdate()>0;
    }
}
