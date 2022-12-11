package dao;


import fc.Cards;
import fc.Support;
import fc.User;

import java.sql.*;

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

    public User login(String firstName, String lastName){
        User user = null;

        try (PreparedStatement User = conn.prepareStatement(
                "SELECT USERID, FIRSTNAME, LASTNAME, ADDRESS, SUBSCRIBER FROM USERS WHERE FIRSTNAME = ? AND LASTNAME = ?"))
        {
            User.setString(1, firstName);
            User.setString(2, lastName);
            ResultSet UserResult = User.executeQuery();

            user = new User();

            if (UserResult.next()) {
                user.setUserID(UserResult.getInt(1));
                user.setFirstname(UserResult.getString(2));
                user.setLastName(UserResult.getString(3));
                user.setAddress(UserResult.getString(4));
                user.setSubscriber(UserResult.getInt(5) == 1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean create(User obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO USERS VALUES (USERID = ? , FIRSTNAME = ? , LASTNAME = ? , ADDRESS = ?, SUBSCRIBER) ")) {
            preparedStatement.setInt(1, obj.getUserID());
            preparedStatement.setString(2, obj.getFirstname());
            preparedStatement.setString(3, obj.getLastName());
            preparedStatement.setString(4, obj.getAddress());
            preparedStatement.setInt(5,obj.isSubscriber() ? 1 : 0);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    //ToDo :
    public void rentMovie(User user,Support support, Cards card){


    }

    //ToDo :
    public void requestSubscriberCard(){

    }


}

