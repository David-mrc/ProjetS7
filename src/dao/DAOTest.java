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
            DAO<SubscriptionCard> cardsDAO = new DAOCards(conn);
            DAO<User> userDAO = new DAOUser(conn);
            DAO<CreditCard> creditCardDAO = new DAOCreditCard(conn);

            // Movie
            Movie movie1 = movieDAO.read(1);
            System.out.println(movie1.toString());
            Movie movie2 = movieDAO.read(2);
            System.out.println(movie2.toString());

            Support supp1 = supportDAO.read(1);
            System.out.println(supp1.toString());
            Support supp2 = supportDAO.read(3);
            System.out.println(supp2.toString());

            DAOInterface daoFacade = new DAOInterface();
            System.out.println("is Available as BluRay movie1 ? " + daoFacade.isAvailableAsBluRay(movie1));
            System.out.println("is Available ? " + daoFacade.isAvailableAsBluRay(movie2));
            System.out.println("is Available ? " + daoFacade.isAvailableAsQRCode(movie1));
            System.out.println("is Available ? " + daoFacade.isAvailableAsQRCode(movie2));
            System.out.println("Monthly Rentals movie 1 ? " + daoFacade.getMonthlyRentals(movie1));
            System.out.println("Weekly Rentals movie 2 ? " + daoFacade.getWeeklyRentals(movie2));
            // Maybe null = must be managed by superior layer
            daoFacade.getAvailableQRCode(movie1);
            daoFacade.getAvailableBluRay(movie2);

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
            System.out.println("is Available ? " + suppFacade.isAvailable(supp3.getSupportID()));

            System.out.println("Monthly rentals : " + suppFacade.getMonthlyRentals(supp3.getSupportID()) );
            System.out.println("Weekly rentals : " +suppFacade.getWeeklyRentals(supp3.getSupportID()));

            //CreditCard
            //CreditCard creditCard = creditCardDAO.read(2);
            DAOFacadeCreditCard creditCardFacade = new DAOFacadeCreditCard(conn);
            creditCardFacade.canRent();


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
