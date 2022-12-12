
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fc.SubscriptionCard;

public class DAOCards extends DAO<SubscriptionCard> {
    public DAOCards(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(SubscriptionCard obj) {
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO CARDS VALUES ( cardId = ? , balance = ? , ageRestriction = ? , userId = ?)")) {
            preparedStatement.setInt(1, obj.getCardId());
            preparedStatement.setFloat(2, obj.getBalance());
            preparedStatement.setInt(4, obj.getUserId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    @Override
    public SubscriptionCard read(Object cardID) {
        SubscriptionCard cards = null;

        try (PreparedStatement Cards = conn.prepareStatement("SELECT balance, ageRestriction, userId FROM CARDS WHERE cardId = ?")) {
            Cards.setInt(1, (Integer) cardID);
            ResultSet resultSet = Cards.executeQuery();

            cards = new SubscriptionCard();
            cards.setCardId( (Integer) cardID);
            if (resultSet.next()) {
                cards.setBalance(resultSet.getFloat(1));
                cards.setUserId(resultSet.getInt(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cards;
    }

    @Override
    public boolean update(SubscriptionCard obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(SubscriptionCard obj) {
        return false;
    }
}
