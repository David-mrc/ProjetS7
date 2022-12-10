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
                "INSERT INTO USERS VALUES (USERID = ? , FIRSTNAME = ? , LASTNAME = ? , ADDRESS = ?, BIRTHDATE, SUBSCRIBER) ")) {
            preparedStatement.setInt(1, obj.getUserID());
            preparedStatement.setString(2, obj.getFirstname());
            preparedStatement.setString(3, obj.getLastName());
            preparedStatement.setString(4, obj.getAddress());
            preparedStatement.setDate(5, obj.getBirthday());
            preparedStatement.setInt(6,obj.isSubscriber() ? 1 : 0);
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
                "SELECT FIRSTNAME,LASTNAME,ADDRESS,BIRTHDATE,SUBSCRIBER  FROM USERS WHERE USERID = ?");)
        {
            User.setInt(1, (Integer) obj);
            ResultSet UserResult = User.executeQuery();

            user = new User();
            user.setUserID((Integer) obj );
            if (UserResult.next()) {
                user.setFirstname(UserResult.getString(1));
                user.setLastName(UserResult.getString(2));
                user.setAddress(UserResult.getString(3));
                user.setBirthday(UserResult.getDate(4));
                user.setSubscriber(UserResult.getInt(5) == 1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User obj) throws SQLException {
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
