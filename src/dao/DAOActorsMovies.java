package dao;

import fc.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOActorsMovies extends DAO<Actor>{

    protected DAOActorsMovies(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Actor obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO ACTORSMOVIES VALUES (MOVIEID = ? , FIRSTNAME = ? , LASTNAME = ? )")) {
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getFirstName());
            preparedStatement.setString(3, obj.getLastName());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Actor read(Object obj) throws SQLException {
        Actor actor = null;

        try (PreparedStatement Actor = conn.prepareStatement("SELECT FIRSTNAME, LASTNAME FROM ACTORSMOVIES WHERE MOVIEID = ?")){
            Actor.setInt(1, (Integer) obj);
            ResultSet resultSet = Actor.executeQuery();

            actor = new Actor();
            actor.setMovieID(((Integer) obj));
            if (resultSet.next()) {
                actor.setFirstName(resultSet.getString(1));
                actor.setLastName(resultSet.getString(2));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Actor obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "UPDATE ACTORSMOVIES SET FIRSTNAME = ? , LASTNAME = ? WHERE MOVIEID = ?")) {
            preparedStatement.setString(1, obj.getFirstName());
            preparedStatement.setString(2, obj.getLastName());
            preparedStatement.setInt(3, obj.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Actor obj) throws SQLException {
        return false;
    }
}
