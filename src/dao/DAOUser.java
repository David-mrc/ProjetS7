package dao;

import fc.Movie;
import fc.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUser extends DAO<User>{

    protected DAOUser(Connection conn) {
        super(conn);
    }

    @Override
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

    @Override
    public User read(Object obj) throws SQLException {
        User user = null;
        //Vérifaction obj de type int ?
        try (PreparedStatement User = conn.prepareStatement(
                "SELECT FIRSTNAME,LASTNAME,ADDRESS,SUBSCRIBER  FROM USERS WHERE USERID = ?");)
        {
            User.setInt(1, (Integer) obj);
            ResultSet UserResult = User.executeQuery();

            user = new User();
            user.setUserID((Integer) obj );
            if (UserResult.next()) {
                user.setFirstname(UserResult.getString(1));
                user.setLastName(UserResult.getString(2));
                user.setAddress(UserResult.getString(3));
                user.setSubscriber(UserResult.getInt(4) == 1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "UPDATE USERS_BASE SET ADDRESS = ?, SUBSCRIBER = ? WHERE USERID = ? ")) {
            preparedStatement.setString(1, obj.getAddress());
            preparedStatement.setInt(2, obj.isSubscriber() ? 1 : 0);
            preparedStatement.setInt(3,obj.getUserID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User obj) throws SQLException {
        try (PreparedStatement User = conn.prepareStatement(
                "DELETE FROM USERS WHERE USERID = ?");)
        {
            User.setInt(obj.getUserID(),1);
            return User.executeUpdate() > 0;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }
}
