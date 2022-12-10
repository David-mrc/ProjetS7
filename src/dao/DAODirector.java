package dao;
import fc.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAODirector extends DAO<Director>{

    protected DAODirector(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Director obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO DIRECTORS VALUES (FIRSTNAME = ? , LASTNAME = ? , MOVIEID = ?) ")) {
            preparedStatement.setString(1, obj.getFirstName());
            preparedStatement.setString(2, obj.getLastName());
            preparedStatement.setInt(3, obj.getMovieID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Director read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Director obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Director obj) throws SQLException {
        try (PreparedStatement Director = conn.prepareStatement(
                "DELETE FROM DIRECTORS WHERE FIRSTNAME = ? AND LASTNAME = ?");)
        {
            Director.setString(1, obj.getFirstName());
            Director.setString(2,obj.getLastName());
            return Director.executeUpdate() > 0;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }
}