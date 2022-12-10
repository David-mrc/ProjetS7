package dao;
import fc.People;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOPeople extends DAO<People>{

    protected DAOPeople(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(People obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO PEOPLE VALUES (FIRSTNAME = ? , lastName = ?) ")) {
            preparedStatement.setString(1, obj.getFirstName());
            preparedStatement.setString(2, obj.getLastName());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    // INUTILE sans id pour people ???
    @Override
    public People read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(People obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(People obj) throws SQLException {
        return false;
    }
}