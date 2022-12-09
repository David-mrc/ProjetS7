package dao;
import fc.Actor;
import fc.CyberVideoInterface;
import fc.Director;
import fc.Movie;

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
        return false;
    }
}