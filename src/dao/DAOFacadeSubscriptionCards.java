package dao;

import fc.SubscriptionCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOFacadeSubscriptionCards {
    public Connection conn;

    public DAOFacadeSubscriptionCards(Connection conn) {
        this.conn = conn;
    }

    public SubscriptionCard read (Object id){
        DAOSubscriptionCards daoSubscriptionCards =  new DAOSubscriptionCards(conn);
        SubscriptionCard s = null;
        try {
            s = daoSubscriptionCards.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void getHistory(int cardId ){
        try {
            PreparedStatement History = conn.prepareStatement("SELECT RENTALID, STARTDATE, ENDDATE, PRICE, USERID, CARDNUMBER FROM RENTALS WHERE CARDID = ?");
            History.setInt(1, cardId);
            ResultSet resultSet = History.executeQuery();

            System.out.println("Historique :" );
            while (resultSet.next()) {

                System.out.print("Rental number : " + resultSet.getInt(1) +
                        "; Rental start : " + resultSet.getDate(2) +
                        "; Rental end : " + resultSet.getDate(3) +
                        "; Rental price : " + resultSet.getInt(4) +
                        "; User number : " + resultSet.getInt(5) +
                        "; Card number : " + resultSet.getInt(6));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void credit(float credit , int cardId){
        try {
            PreparedStatement balance = conn.prepareStatement("SELECT BALANCE FROM SUBSCRIPTIONCARDS WHERE CARDID = ?");
            balance.setInt(1, cardId);
            ResultSet resultSet2 = balance.executeQuery();

            if(resultSet2.next()) {
                PreparedStatement price = conn.prepareStatement("UPDATE SUBSCRIPTIONCARDS SET BALANCE = ? WHERE CARDID = ?");
                price.setInt(2, cardId);
                price.setFloat(1, resultSet2.getFloat(1) + credit);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean canRent(int cardId){
        boolean rent = false;
        try {

            PreparedStatement balance = conn.prepareStatement("SELECT BALANCE FROM SUBSCRIPTIONCARDS WHERE CARDID = ?");
            balance.setInt(1, cardId);
            ResultSet resultSet = balance.executeQuery();


            if (resultSet.next()) {
                if( resultSet.getFloat(1) >= 15) {
                    rent =true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rent;
    }
}

