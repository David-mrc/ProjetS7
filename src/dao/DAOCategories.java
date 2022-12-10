
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOCategories extends DAO<Categories> {
    public DAOCategories(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Categories obj) {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO MOVIECATEGORIES VALUES (  category = ? )"))
        {
            preparedStatement.setString(1, obj.getCategory());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;;
    }

    @Override
    public Categories read(Object category) {//inutile
        return Null;
    }


    @Override
    public boolean delete(Categories obj) {
        return false;
    }

}
