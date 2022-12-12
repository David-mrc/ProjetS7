
package dao;

import fc.BluRay;
import fc.QRCode;
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
                "INSERT INTO SUPPORTS_BASE VALUES ( supportId = ? , supportType = ? ,DAMAGEDDISK = ? ,lostDisk = ?, streamAddress = ?, movieId = ?) ")) {
            preparedStatement.setInt(1, obj.getSupportID());
            preparedStatement.setString(2, obj.getSupportType());
            preparedStatement.setInt(3,obj.isDamagedDisk()? 1 : 0);
            preparedStatement.setInt(5, obj.isLostDisk()? 1 : 0);
            preparedStatement.setString(6, obj.getStreamAddress());
            preparedStatement.setInt(7, obj.getMovieId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Support read(Object supportID) throws SQLException {
        Support support = null;

        try (PreparedStatement Support = conn.prepareStatement("SELECT SUPPORTTYPE, DAMAGEDDISK, LOSTDISK, STREAMADDRESS, MOVIEID FROM SUPPORTS_BASE WHERE SUPPORTID = ?")){
            Support.setInt(1, (Integer)supportID);
            ResultSet resultSet = Support.executeQuery();
            if (resultSet.next()) {
                support = resultSet.getString(1) == "BluRay" ? new BluRay() : new QRCode(); // 1 == BLuray
                support.setSupportID(((Integer) supportID));
                support.setSupportType(resultSet.getString(1));
                support.setDamagedDisk(resultSet.getInt(2)==1);
                support.setLostDisk(resultSet.getInt(3)==1);
                support.setStreamAddress(resultSet.getString(4));
                support.setMovieId(resultSet.getInt(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return support;
    }

    @Override
    public boolean update(Support obj) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE SUPPORTS SET SUPPORTTYPE = ?, AVAILABLE = ?, DAMAGEDDISK = ?, STREAMADDRESS = ?, MOVIEID = ? WHERE SUPPORTID = ?")) {
            preparedStatement.setString(1, obj.getSupportType());
            preparedStatement.setInt(2, obj.isAvailable() ? 1 : 0);
            preparedStatement.setInt(3, obj.isDamagedDisk() ? 1 : 0);
            preparedStatement.setString(1, obj.getStreamAddress());
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