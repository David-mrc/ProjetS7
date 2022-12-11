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

        public DBInterface() {
            try {
                conn = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    public ArrayList<Movie> getMovieList(){ // All available movies
        // A METTRE DANS DAOFacadeMovie
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            PreparedStatement MovieStatement = conn.prepareStatement("SELECT * FROM MOVIES");
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

