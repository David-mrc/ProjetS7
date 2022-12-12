package dao;

import fc.CreditCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOFacadeCreditCard {
    protected Connection conn;
    public DAOFacadeCreditCard(Connection conn) {
        this.conn = conn;
    }

    public Boolean canRent(){
        System.out.println("Interrogate bank...");
        System.out.println("...");
        System.out.println("Authorized payment !");
        return true;
    }

    public CreditCard getCreditCard(int userID){
        CreditCard cc = new CreditCard();
        try {

            PreparedStatement CCStatement = conn.prepareStatement("SELECT * FROM CREDITCARDS WHERE USERID = ?");
            CCStatement.setInt(1, userID);
            ResultSet resultSet = CCStatement.executeQuery();


            if (resultSet.next()) {

                    cc.setCardNumber(resultSet.getInt(1));
                    cc.setHolder(resultSet.getString(2));
                    cc.setCcv(resultSet.getInt(3));
                    cc.setExpiryDate(resultSet.getDate(4));
                    cc.setUserID(resultSet.getInt(5));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cc;
    }
}

