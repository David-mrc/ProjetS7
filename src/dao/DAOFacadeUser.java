package dao;


import fc.*;
import dao.DBInterface;

import java.sql.*;
import java.util.Random;

public class DAOFacadeUser {


    public Connection conn;

    public DAOFacadeUser(Connection conn) {
        this.conn = conn;
    }

    public User readUser (int id){
        DAOUser daoUser =  new DAOUser(conn);
        User u = null;
        try {
            u = daoUser.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public User login(int userid){
        User user = null;

        try (PreparedStatement User = conn.prepareStatement(
                "SELECT USERID, FIRSTNAME, LASTNAME, ADDRESS, SUBSCRIBER FROM USERS WHERE USERID = ?"))
        {
            User.setInt(1, userid);

            ResultSet UserResult = User.executeQuery();

            if (UserResult.next()) {
                user = new User(new DBInterface());

                user.setUserID(UserResult.getInt(1));
                user.setFirstname(UserResult.getString(2));
                user.setLastName(UserResult.getString(3));
                user.setAddress(UserResult.getString(4));
                user.setSubscriber(UserResult.getInt(5) == 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean create(User user) throws SQLException {
        DAOUser daoUser = new DAOUser(conn);
        return daoUser.create(user);
    }

    //ToDo :
    public void rentMovie(User user,Support support, Cards card) throws SQLException {
        DAORentals daoRentals = new DAORentals(conn);
        Rental rental = new Rental();
        Random random = new Random();
        rental.setId(random.nextInt(1000000000)); // todo : voir dans la base...
        rental.setSupportid(support.getSupportID());
        rental.setUserid(user.getUserID());
        if (card.getType().equals("Subscription")) {
            rental.setPrice(3);
            rental.setCardID(card.getID());
        } else {
            rental.setPrice(5);
            rental.setCardnumber(card.getID());
        }
        rental.setStartDate(new Date(System.currentTimeMillis()));

        daoRentals.create(rental);

    }
    //ToDo :
    public void requestSubscriberCard(User user) throws SQLException {
        DAOSubscriptionCards daoSubscriptionCards = new DAOSubscriptionCards(conn);
        SubscriptionCard subscriptionCard = new SubscriptionCard();
        Random random = new Random();
        subscriptionCard.setCardId(random.nextInt(1000000000));
        subscriptionCard.setUserId(user.getUserID());
        if (!user.isSubscriber()) {
            DAOUser daoUser = new DAOUser(conn);
            user.setSubscriber(true);
            daoUser.update(user);
        }
        daoSubscriptionCards.create(subscriptionCard);
    }


}

