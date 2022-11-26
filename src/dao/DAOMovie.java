package dao;
import fc.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMovie extends DAO<Movie>{

    protected DAOMovie(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Movie obj) throws SQLException {
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
