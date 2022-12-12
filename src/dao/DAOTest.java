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
            DAO<CreditCard> creditCardDAO = new DAOCreditCard(conn);

            // READ
            Movie movie1 = movieDAO.read(1);
            System.out.println(movie1.toString());
            Movie movie2 = movieDAO.read(2);
            System.out.println(movie2.toString());

            Support supp1 = supportDAO.read(1);
            System.out.println(supp1.toString());
            Support supp2 = supportDAO.read(2);
            System.out.println(supp2.toString());

            // SubscriptionCards
            SubscriptionCard subCard = new SubscriptionCard();
            DAOFacadeSubscriptionCards cardsFacade = new DAOFacadeSubscriptionCards(conn);
            subCard.setCardId(2);
            subCard.setBalance(40.0F);
            subCard.setUserId(2);
            if (cardsDAO.create(subCard)){
                System.out.println("Creation SubCard reussi.");
            }
            SubscriptionCard subCard1 = cardsFacade.read(1);
            cardsFacade.getHistory(subCard1.getCardId());
            cardsFacade.credit(5.0F,subCard1.getCardId());
            cardsFacade.canRent(subCard1.getCardId());

            //Support
            Support supp3 = supportDAO.read(1);
            DAOFacadeSupport suppFacade = new DAOFacadeSupport(conn);
            suppFacade.isAvailable(supp3.getSupportID());
            suppFacade.getMonthlyRentals(supp3.getSupportID());
            suppFacade.getWeeklyRentals(supp3.getSupportID());

            //CreditCard
            //CreditCard creditCard = creditCardDAO.read(2);
            DAOFacadeCreditCard creditCardFacade = new DAOFacadeCreditCard(conn);
            creditCardFacade.canRent();

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
