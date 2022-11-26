package dao;
import fc.CyberVideoInterface;
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
                "INSERT INTO MOVIES VALUES  id = ? , title = ? , actors = ? , director = ? , isAvailableAsQRCode = ? , isAvailableAsBluRay = ? ")) {
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getTitle());
            preparedStatement.setString(3, obj.getActors()); //TODO: comment gérer foreignkey?
            preparedStatement.setString(4, obj.getDirector());
            preparedStatement.setBoolean(5, obj.getQRCodeAvailability());
            preparedStatement.setBoolean(6, obj.getBluRayAvailability());


            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Movie read(Object obj) throws SQLException {
        Movie movie = null;

        try (PreparedStatement Movie = conn.prepareStatement("SELECT TITLE, DIRECTOR FROM MOVIES WHERE MovieID = ?");
            PreparedStatement ActorsPlaying = conn.prepareStatement(("SELECT firstName, lastNAme FROM ACTORS WHERE MovieID = ?"))) {
            Movie.setInt(1, (Integer) obj);
            ActorsPlaying.setInt(1, (Integer)obj);
            ResultSet MovieResult = Movie.executeQuery();
            ResultSet ActorsResult = Movie.executeQuery();

            movie = new Movie();
            if (MovieResult.next()) {
                movie.setTitle(MovieResult.getString(1));
                movie.setDirector(MovieResult.getString(2));
            }

            while (ActorsResult.next()) {
                movie.addActor(ActorsResult.getString(1) + " " +ActorsResult.getString(2));
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
