package dao;
import fc.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOActor extends DAO<Actor>{

    protected DAOActor(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Actor obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO ACTORS VALUES id = ? , firstName = ? , lastName = ? ")) {
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

        try (PreparedStatement Actor = conn.prepareStatement("SELECT id, firstName, lastName FROM ACTOR WHERE id = ?")){
            Actor.setInt(1, (Integer) obj);
            ResultSet resultSet = Actor.executeQuery();

            actor = new Actor();
            if (resultSet.next()) {
                actor.setId(resultSet.getInt(1));
                actor.setFirstName(resultSet.getString(2));
                actor.setLastName(resultSet.getString(3));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Actor obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "UPDATE ACTORS SET firstName = ? , lastName = ? WHERE id = ?")) {
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