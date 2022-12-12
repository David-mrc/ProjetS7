package dao;
import fc.interfaces.CyberVideoInterface;
import fc.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMovie extends DAO<Movie>{

    protected DAOMovie(Connection conn) {
        super(conn);
    }

    int id;
    String title;
    ArrayList<String> actors;
    String Director;
    CyberVideoInterface cvinterface;
    boolean isAvailableAsQRCode = false;
    boolean isAvailableAsBluRay = false;

    @Override
    public boolean create(Movie obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO MOVIES_BASE VALUES ( ? , ? ,  ?, ? ) ")) {
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getTitle());
            preparedStatement.setString(3, obj.getDirectorFirstname());
            preparedStatement.setString(4, obj.getDirectorLastname());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Movie read(Object obj) throws SQLException {
        Movie movie = null;

        try {
            PreparedStatement Movie = conn.prepareStatement("SELECT TITLE, DIRECTORFIRSTNAME ,DIRECTORLASTNAME FROM MOVIES_BASE WHERE MovieID = ?");
            PreparedStatement ActorsPlaying = conn.prepareStatement(("SELECT firstName, lastNAme FROM ACTORS WHERE MovieID = ?"));
            System.out.println(Movie);
            Movie.setInt(1, ((Integer)obj).intValue());
            ResultSet MovieResult = Movie.executeQuery();

            movie = new Movie();
            movie.setId((Integer)obj);
            if (MovieResult.next()) {
                movie.setTitle(MovieResult.getString(1));
                movie.setDirectorFirstname(MovieResult.getString(2));
                movie.setDirectorLastname(MovieResult.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movie;
    }

    @Override
    public boolean update(Movie obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Movie obj) throws SQLException {
        return false;
    }
}
