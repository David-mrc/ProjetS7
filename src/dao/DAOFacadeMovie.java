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

    public Connection conn;

    public DAOFacadeMovie(Connection conn) {
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

    public Support getAvailableBluRay(Movie m){
        Support br = null;
        DAOSupport daoSupport = new DAOSupport(conn);
        try {
            PreparedStatement availableBluRay = conn.prepareStatement("SELECT SUPPORTID FROM SUPPORTS WHERE MovieID = ? AND AVAILABLE = 1 AND SUPPORTTYPE='BluRay'");
            availableBluRay.setInt(1, m.getId());
            ResultSet resultSet = availableBluRay.executeQuery();


            if (resultSet.next()) {
                br = daoSupport.read(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return br;

    }

    public Support getAvailableQRCode(Movie m){
        Support qrc = null;
        DAOSupport daoSupport = new DAOSupport(conn);
        try {
            PreparedStatement availableQRcode = conn.prepareStatement("SELECT SUPPORTID FROM SUPPORTS WHERE MovieID = ? AND AVAILABLE = 1 AND SUPPORTTYPE='QRCode'");
            availableQRcode.setInt(1, m.getId());
            ResultSet resultSet = availableQRcode.executeQuery();


            if (resultSet.next()) {
                qrc = daoSupport.read(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qrc;

    }

    public boolean isAvailableAsQRCode(Movie m) {
        try {
            PreparedStatement availableQRcode = conn.prepareStatement("SELECT SUPPORTID FROM SUPPORTS WHERE MovieID = ? AND AVAILABLE = 1 AND SUPPORTTYPE='QRCode'");
            availableQRcode.setInt(1, m.getId());
            ResultSet resultSet = availableQRcode.executeQuery();


            if (resultSet.next()) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isAvailableAsBluRay(Movie m) {
        try {
            PreparedStatement availableBluRay = conn.prepareStatement("SELECT SUPPORTID FROM SUPPORTS WHERE MovieID = ? AND AVAILABLE = 1 AND SUPPORTTYPE='BluRay'");
            availableBluRay.setInt(1, m.getId());
            ResultSet resultSet = availableBluRay.executeQuery();


            if (resultSet.next()) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Movie> getMovieList(){ // All available movies

        ArrayList<Movie> movies = new ArrayList<>();

        try {
            PreparedStatement MovieStatement = conn.prepareStatement("SELECT * FROM Movies_base");
            ResultSet MovieResult = MovieStatement.executeQuery();

            while(MovieResult.next()) {
                Movie movie = new Movie();

                movie.setId(MovieResult.getInt(1));
                movie.setTitle(MovieResult.getString(2));
                movie.setDirectorLastname(MovieResult.getString(3));
                movie.setDirectorFirstname(MovieResult.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public ArrayList<Movie> getMovieListQR(){ // All movies available on QR Code

        ArrayList<Movie> movies = new ArrayList<>();

        try {
            PreparedStatement MovieStatement = conn.prepareStatement("SELECT * FROM Movies_base WHERE movieID IN " +
                    "(SELECT * FROM SUPPORTS WHERE supportType = 'QRCode')");
            ResultSet MovieResult = MovieStatement.executeQuery();

            while(MovieResult.next()) {
                Movie movie = new Movie();

                movie.setId(MovieResult.getInt(1));
                movie.setTitle(MovieResult.getString(2));
                movie.setDirectorLastname(MovieResult.getString(3));
                movie.setDirectorFirstname(MovieResult.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public ArrayList<Movie> getMovieListBR(){ // All movies available on BluRay

        ArrayList<Movie> movies = new ArrayList<>();

        try {
            PreparedStatement MovieStatement = conn.prepareStatement("SELECT * FROM Movies_base WHERE movieID IN " +
                    "(SELECT * FROM SUPPORTS WHERE supportType = 'BluRay' and available = 1)");
            ResultSet MovieResult = MovieStatement.executeQuery();

            while(MovieResult.next()) {
                Movie movie = new Movie();

                movie.setId(MovieResult.getInt(1));
                movie.setTitle(MovieResult.getString(2));
                movie.setDirectorLastname(MovieResult.getString(3));
                movie.setDirectorFirstname(MovieResult.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

}
