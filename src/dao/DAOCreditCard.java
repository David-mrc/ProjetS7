package dao;

import fc.CreditCard;
import fc.Rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCreditCard extends DAO<CreditCard>{

    protected DAOCreditCard(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(CreditCard obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO CREDITCARDS VALUES (CARDNUMBER = ?, HOLDER = ?, CCV = ?, EXPIRYDATE = ?, USERID =?) ")) {
            preparedStatement.setInt(1, obj.getCardNumber());
            preparedStatement.setString(2, obj.getHolder());
            preparedStatement.setInt(3, obj.getCcv());
            preparedStatement.setDate(4, obj.getExpiryDate());
            preparedStatement.setInt(5, obj.getUserID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public CreditCard read(Object obj) throws SQLException {
        CreditCard cb = null;
        //Vérifaction obj de type int ?
        try (PreparedStatement Rentals = conn.prepareStatement(
                "SELECT CARDNUMBER,CCV,EXPIRYDATE,HOLDER FROM CREDITCARDS WHERE USERID = ?");)
        {
            Rentals.setInt(1, (Integer) obj);
            ResultSet resultSet = Rentals.executeQuery();

            cb = new CreditCard();
            cb.setUserID((Integer) obj );
            if (resultSet.next()) {
                cb.setCardNumber(resultSet.getInt(1));
                cb.setCcv(resultSet.getInt(2));
                cb.setExpiryDate(resultSet.getDate(3));
                cb.setHolder(resultSet.getString(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cb;
    }

    @Override
    public boolean update(CreditCard obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(CreditCard obj) throws SQLException {
        return false;
    }
}
