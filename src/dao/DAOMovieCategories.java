
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fc.MovieCategories;
public class DAOMovieCategories extends DAO<MovieCategories> {

    public DAOMovieCategories(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(MovieCategories obj) {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO MOVIESCATEGORIES VALUES (? , ? )"))
        {
            preparedStatement.setInt(1, obj.getMovieID());
            preparedStatement.setString(2, obj.getCategory());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public MovieCategories read(Object movieId) {
        MovieCategories movieCategories = null;

        try (PreparedStatement MovieCategories = conn.prepareStatement("SELECT CATEGORYNAME FROM MOVIESCATEGORIES WHERE MOVIEID = ?")){
            MovieCategories.setInt(1, (Integer)movieId);
            ResultSet resultSet = MovieCategories.executeQuery();

            movieCategories = new MovieCategories();
            movieCategories.setMovieID(((Integer) movieId));
            if (resultSet.next()) {
                movieCategories.setCategory(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movieCategories;
    }

    public boolean update(MovieCategories obj) {
        return false;
    }
    @Override
    public boolean delete(MovieCategories obj) {
        return false;
    }

}
