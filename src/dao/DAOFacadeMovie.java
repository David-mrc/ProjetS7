package dao;

import fc.Actor;
import fc.BluRay;
import fc.Movie;
import fc.Support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOFacadeMovie {

    protected Connection conn;

    protected DAOFacadeMovie(Connection conn) {
        this.conn = conn;
    }

    //
    public Movie readMovie (int id){
        DAOMovie daoMovie =  new DAOMovie(conn);
        Movie m = null;
        try {
            m = daoMovie.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public ArrayList<Actor> getActorFromMovies(int movieID){
        ArrayList<Actor> actors = new ArrayList<>();

        try {
            PreparedStatement actorsPlaying = conn.prepareStatement("SELECT FIRSTNAME,LASTNAME FROM ACTORSMOVIES WHERE MovieID = ?");
            actorsPlaying.setInt(1, movieID);
            ResultSet MovieResult = actorsPlaying.executeQuery();


            if (MovieResult.next()) {
                Actor actor = new Actor();
                actor.setFirstName(MovieResult.getString(1));
                actor.setLastName(MovieResult.getString(2));
                actors.add(actor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    public int getWeeklyRentals(int movieID){
        int weeklyRentals = 0;
        try {
            PreparedStatement WeeklyRentals = conn.prepareStatement("SELECT WEEKRENTALS FROM MOVIES WHERE MovieID = ?");
            WeeklyRentals.setInt(1, movieID);
            ResultSet resultSet = WeeklyRentals.executeQuery();


            if (resultSet.next()) {
                weeklyRentals =  resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weeklyRentals;

    }

    public int getMonthlyRentals(int movieID){
        int monthlyRentals = 0;
        try {
            PreparedStatement MonthlyRentals = conn.prepareStatement("SELECT MONTHRENTALS FROM MOVIES WHERE MovieID = ?");
            MonthlyRentals.setInt(1, movieID);
            ResultSet resultSet = MonthlyRentals.executeQuery();


            if (resultSet.next()) {
                monthlyRentals =  resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monthlyRentals;

    }

    public BluRay getAvailableBluRay(int movieID){
        BluRay br = null;
        DAOSupport daoSupport = new DAOSupport(conn);
        try {
            PreparedStatement availableBluRay = conn.prepareStatement("SELECT SUPPORTID FROM SUPPORTS WHERE MovieID = ? AND AVAILABLE = 1");
            availableBluRay.setInt(1, movieID);
            ResultSet resultSet = availableBluRay.executeQuery();


            if (resultSet.next()) {
                br = (BluRay) daoSupport.read(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return br;

    }

}
