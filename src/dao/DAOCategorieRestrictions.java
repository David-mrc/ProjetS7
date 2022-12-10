package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fc.CategorieRestrictions;

public class DAOCategorieRestrictions extends DAO<CategorieRestrictions> {
    public DAOCategorieRestrictions(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(CategorieRestrictions obj) {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO CATEGORIERESTRICTIONS VALUES ( cardId = ? , category = ? )"))
        {
            preparedStatement.setInt(1, obj.getCardId());
            preparedStatement.setString(2, obj.getCategory());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public CategorieRestrictions read(Object cardId) {
        CategorieRestrictions categorieRestrictions = null;

        try (PreparedStatement CategorieRestrictions = conn.prepareStatement("SELECT category FROM CATEGORIERESTRICTIONS WHERE cardId = ?")){
            CategorieRestrictions.setInt(1, (Integer)cardId);
            ResultSet resultSet = CategorieRestrictions.executeQuery();

            categorieRestrictions = new CategorieRestrictions();
            categorieRestrictions.setCardId( (Integer) cardID);
            if (resultSet.next()) {
                categorieRestrictions.setCategory(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorieRestrictions;
    }

    @Override
    public boolean update(CategorieRestrictions obj) throws SQLException {
        return false;
    }


    @Override
    public boolean delete(CategorieRestrictions obj) {
        return false;
    }

}
