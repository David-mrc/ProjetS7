
package dao;

import fc.Support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOSupport extends DAO<Support> {
    public DAOSupport(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Support obj) {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO SUPPORTS VALUES  supportId = ? , supportType = ? , available = ? , readableDisk = ? , lostDisk = ?, streamAddress = ?, movieId = ? ")) {
            preparedStatement.setInt(1, obj.getSupportId());
            preparedStatement.setString(2, obj.getSupportType());
            preparedStatement.setInt(3, obj.getAvailable());
            preparedStatement.setInt(4, obj.getReadableDisk());
            preparedStatement.setInt(5, obj.getLostDisk());
            preparedStatement.setString(6, obj.getStreamAddress());
            preparedStatement.setInt(7, obj.getMovieId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;;
    }

    @Override
    public Support read(Object supportID) {
        Support support = null;

        try (PreparedStatement Support = conn.prepareStatement("SELECT SUPPORTTYPE, AVAILABLE, READABLEDISK, LOSTDISK, STREAMADRESS, MOVIEID FROM SUPPORT WHERE SUPPORTID = ?")){
            Support.setInt(1, (Integer)supportID);
            ResultSet resultSet = Support.executeQuery();

            support = new Support();
            if (resultSet.next()) {
                support.setSupportType(resultSet.getString(1));
                support.setAvailable(resultSet.getInt(2));
                support.setReadableDisk(resultSet.getInt(3));
                support.setLostDisk(resultSet.getInt(4));
                support.setStreamAdress(resultSet.getString(5));
                support.setMovieId(resultSet.getInt(6));
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

   @Override
    public boolean delete(Support obj) {
        return false;
    }

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