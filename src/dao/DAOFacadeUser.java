package dao;


import fc.Cards;
import fc.Support;
import fc.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void rentMovie(Support support, Cards card){

    }

    //ToDo :
    public void requestSubscriberCard(){

    }


}

