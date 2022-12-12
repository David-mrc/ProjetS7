package dao;

import fc.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOFacadeSupport {
    public Connection conn;

    public DAOFacadeSupport(Connection conn) {
        this.conn = conn;
    }

    public Support readSupport (Support id){
        DAOSupport daoSupport =  new DAOSupport(conn);
        Support s = null;
        try {
            s = daoSupport.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Boolean isAvailable(int supportId ){
        boolean available = false;
        try {
            PreparedStatement WeeklyRentals = conn.prepareStatement("SELECT * FROM SUPPORTS_BASE WHERE SUPPORTID = ?");
            WeeklyRentals.setInt(1, supportId);
            ResultSet resultSet = WeeklyRentals.executeQuery();


            if (resultSet.next()) {
                available = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return available;
    }

    public int getWeeklyRentals(int supportId ){
        int weeklyRentals = 0;
        try {
            PreparedStatement WeeklyRentals = conn.prepareStatement("SELECT WEEKRENTALS FROM SUPPORTS WHERE SUPPORTID = ?");
            WeeklyRentals.setInt(1, supportId);
            ResultSet resultSet = WeeklyRentals.executeQuery();


            if (resultSet.next()) {
                weeklyRentals =  resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weeklyRentals;
    }

    public int getMonthlyRentals(int supportId ){
        int monthlyRentals = 0;
        try {
            PreparedStatement MonthlyRentals = conn.prepareStatement("SELECT MONTHRENTALS FROM SUPPORTS WHERE SUPPORTID = ?");
            MonthlyRentals.setInt(1, supportId);
            ResultSet resultSet = MonthlyRentals.executeQuery();


            if (resultSet.next()) {
                monthlyRentals =  resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monthlyRentals;
    }


}
