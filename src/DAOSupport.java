
package dao;

import Support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DAOSupport extends DAO<Support> {
    public DAOSupport(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Support obj) {
        return false;
    }

    @Override
    public Support read(Object supportID) {
        Support support = null;

        try (PreparedStatement Support = conn.prepareStatement("SELECT TYPE, AVAILABLE, READABLEDISK, STREAMADRESS, MOVIEID FROM SUPPORT WHERE SUPPORTID = ?")){
            Support.setInt(1, (Integer)supportID);
            ResultSet resultSet = Support.executeQuery();

            support = new Support();
            if (resultSet.next()) {
                support.setType(resultSet.getString(1));
                support.setAvailable(resultSet.getBoolean(2));
                support.setReadableDisk(resultSet.getBoolean(3));
                support.setStreamAdress(resultSet.getString(4));
                support.setMovieId(resultSet.getInt(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return support;
    }

    @Override
    public boolean update(Support obj) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE SUPPORT SET TYPE = ?, AVAILABLE = ?, READABLEDISK = ?, STREAMADRESS = ?, MOVIEID = ? WHERE SUPPORTID = ?")) {
            preparedStatement.setString(1, obj.getType());
            preparedStatement.setBoolean(2, obj.getAvailable());
            preparedStatement.setBoolean(3, obj.getReadableDisk());
            preparedStatement.setString(1, obj.getStreamAdress());
            preparedStatement.setInt(1, obj.getMovieId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    //ToDo :
   /* @Override
    public boolean delete(Cage obj) {
        return false;
    }*/

    //ToDo :
    /*public Set<Cage> readAvailableCagesForGardien(Gardien g) {
        Set<Cage> noCages = new HashSet<>();

        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT NOCAGE " +
                "FROM LESCAGES " +
                "WHERE FONCTION IN " +
                "(SELECT FONCTION_CAGE FROM LESSPECIALITES WHERE NOME = ?)")) {
            preparedStatement.setString(1, g.getNomE());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cage c = new Cage();
                c.setNoCage(resultSet.getInt(1));
                noCages.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return noCages;
    }*/
}