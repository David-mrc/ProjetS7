package fc.interfaces;
import dao.*;
import fc.*;

import java.sql.*;
import java.util.ArrayList;

public class DBInterface {

    String url ="jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    String user="bultincl";
    String passwd="e5f05c6c48";

    Connection conn;

    DAOFacadeSupport facadeSupport;
    DAOFacadeMovie facadeMovie;
    DAOFacadeUser facadeUser;


        public DBInterface() {
            try {
                conn = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            facadeMovie = new DAOFacadeMovie(conn);
            facadeSupport = new DAOFacadeSupport(conn);
            facadeUser = new DAOFacadeUser(conn);
        }




    public ArrayList<Movie> getMovieList(){ // All available movies
        // A METTRE DANS DAOFacadeMovie
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
        // A METTRE DANS DAOFacadeMovie
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
        // A METTRE DANS DAOFacadeMovie
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

