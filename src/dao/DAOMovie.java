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
                "INSERT INTO MOVIES_BASE VALUES (id = ? , title = ? , releaseDate = ? , ageRestriction = ?) ")) {
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getTitle());
            preparedStatement.setDate(3, obj.getDate());
            preparedStatement.setInt(4, obj.getAgeRestriction());
            preparedStatement.setString(5, obj.getPoster());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Movie read(Object obj) throws SQLException {
        Movie movie = null;

        try (PreparedStatement Movie = conn.prepareStatement("SELECT TITLE,RELEASEDATE,AGERESTRICTION,POSTER  FROM MOVIES WHERE MovieID = ?");
            PreparedStatement ActorsPlaying = conn.prepareStatement(("SELECT firstName, lastNAme FROM ACTORS WHERE MovieID = ?"))) {
            Movie.setInt(1, (Integer) obj);
            ActorsPlaying.setInt(1, (Integer)obj);
            ResultSet MovieResult = Movie.executeQuery();
            ResultSet ActorsResult = Movie.executeQuery();

            movie = new Movie();
            if (MovieResult.next()) {
                movie.setTitle(MovieResult.getString(1));
                movie.setReleaseDate(MovieResult.getDate(2));
                movie.setAgeRestriction(MovieResult.getInt(3));
                movie.setPoster(MovieResult.getString(4));
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
