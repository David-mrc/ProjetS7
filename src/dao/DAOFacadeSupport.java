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

    public Support getIfAvailable(int movieID){ //for blurays
        Support support = new BluRay();
        try {
            PreparedStatement BRStatement = conn.prepareStatement("SELECT * FROM SUPPORTS_BASE WHERE MOVIEID = ? AND available = 1 AND supportType = 'BluRay' ");
            BRStatement.setInt(1, movieID);
            ResultSet resultSet = BRStatement.executeQuery();


            if (resultSet.next()) {
                support.setSupportID(resultSet.getInt(1));
                support.setSupportType(resultSet.getString(2));
                support.setDamagedDisk(resultSet.getBoolean(3));
                support.setLostDisk(resultSet.getBoolean(4));
                support.setStreamAddress(resultSet.getString(5));
                support.setMovieId(resultSet.getInt(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return support;
    }

    public Support getQR(int movieID){ //for QRs
        Support support = new QRCode();
        try {
            PreparedStatement BRStatement = conn.prepareStatement("SELECT * FROM SUPPORTS_BASE WHERE MOVIEID = ? AND available = 1 AND supportType = 'QRCode' ");
            BRStatement.setInt(1, movieID);
            ResultSet resultSet = BRStatement.executeQuery();


            if (resultSet.next()) {
                support.setSupportID(resultSet.getInt(1));
                support.setSupportType(resultSet.getString(2));
                support.setDamagedDisk(resultSet.getBoolean(3));
                support.setLostDisk(resultSet.getBoolean(4));
                support.setStreamAddress(resultSet.getString(5));
                support.setMovieId(resultSet.getInt(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return support;
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
