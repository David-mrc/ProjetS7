package dao;

import fc.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOTest {
    public static void main(String[] args) {
        String url ="jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
        String user="bultincl";
        String passwd="e5f05c6c48";

        Connection conn;

        try {
            conn = DriverManager.getConnection(url,user,passwd);
            DAO<Movie> movieDAO = new DAOMovie(conn);
            DAO<Support> supportDAO = new DAOSupport(conn);
            DAO<People> peopledaoDAO = new DAOPeople(conn);
            DAO<SubscriptionCard> cardsDAO = new DAOCards(conn);
            DAO<User> userDAO = new DAOUser(conn);

            // READ
            Movie movie1 = movieDAO.read(1);
            System.out.println(movie1.toString());
            Movie movie2 = movieDAO.read(2);
            System.out.println(movie2.toString());

            Support supp1 = supportDAO.read(1);
            System.out.println(supp1.toString());
            Support supp2 = supportDAO.read(2);
            System.out.println(supp2.toString());

            // WRITE

            Movie movie3 = new Movie();
            movie3.setTitle("Winnie L'ourson");
            movie3.setId(3);
            movie3.setDirectorFirstname("Disney");
            movie3.setDirectorFirstname("Disney");

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
