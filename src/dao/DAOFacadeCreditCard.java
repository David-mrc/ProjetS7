package dao;

import java.sql.Connection;

public class DAOFacadeCreditCard {
    protected Connection conn;
    public DAOFacadeCreditCard(Connection conn) {
        this.conn = conn;
    }

    public Boolean canRent(){
        System.out.println("Interrogate bank...");
        System.out.println("...");
        System.out.println("Authorized payment !");
        return true;
    }
}

