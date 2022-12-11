package dao;


import fc.Cards;
import fc.Support;
import fc.User;

import java.sql.*;

public class DAOFacadeUser {


    protected Connection conn;

    protected DAOFacadeUser(Connection conn) {
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

    //ToDo :
    public void rentMovie(User user,Support support, Cards card){


    }

    //ToDo :
    public void requestSubscriberCard(){

    }


}

