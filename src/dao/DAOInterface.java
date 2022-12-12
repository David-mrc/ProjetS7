package dao;

import fc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOInterface {

    String url = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    String user = "bultincl";
    String passwd = "e5f05c6c48";

    Connection conn;
    DAOFacadeUser daoFacadeUser;
    DAOFacadeMovie daoFacadeMovie;
    DAOFacadeCreditCard daoFacadeCreditCard;
    DAOFacadeSubscriptionCards daoFacadeSubscriptionCards;
    DAOFacadeSupport daoFacadeSupport;

    public DAOInterface() {
        try {
            conn = DriverManager.getConnection(url, user, passwd);
            daoFacadeMovie = new DAOFacadeMovie(conn);
            daoFacadeCreditCard = new DAOFacadeCreditCard(conn);
            daoFacadeSupport = new DAOFacadeSupport(conn);
            daoFacadeSubscriptionCards = new DAOFacadeSubscriptionCards(conn);
            daoFacadeUser = new DAOFacadeUser(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User readUser (int id){
        return daoFacadeUser.readUser(id);
    }

    public User login(int userID) {
        return daoFacadeUser.login(userID);
    }

    public boolean create(User user){
        try {
            return daoFacadeUser.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void rentMovie(User user, Support support, Cards card){
        try {
            daoFacadeUser.rentMovie(user,support,card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void requestSubscriberCard(User user){
        try {
            daoFacadeUser.requestSubscriberCard(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Movie readMovie (int id){
        return daoFacadeMovie.readMovie(id);
    }
    public ArrayList<Actor> getActorFromMovies(int movieID){
        return daoFacadeMovie.getActorFromMovies(movieID);
    }

    public int getWeeklyRentals(Movie movie){
        return daoFacadeMovie.getWeeklyRentals(movie.getId());
    }

    public int getMonthlyRentals(Movie movie){
        return daoFacadeMovie.getMonthlyRentals(movie.getId());
    }

    public Support getAvailableQRCode(Movie m){
        return daoFacadeMovie.getAvailableQRCode(m);
    }

    public boolean isAvailableAsBluRay(Movie m){
        return daoFacadeMovie.isAvailableAsBluRay(m);
    }

    public ArrayList<Movie> getMovieList(){
        return  daoFacadeMovie.getMovieList();
    }

    public ArrayList<Movie> getMovieListBR(){
        return  daoFacadeMovie.getMovieListBR();
    }

    public ArrayList<Movie> getMovieListQR(){
        return  daoFacadeMovie.getMovieListQR();
    }

    public ArrayList<Movie> getHistory(int userID){
        return daoFacadeMovie.getHistory(userID);
    }

    public Support readSupport (Support id){
        return daoFacadeSupport.readSupport(id);
    }

    public Boolean isAvailable(Support support){
        return daoFacadeSupport.isAvailable(support.getSupportID());
    }

    public int getWeeklyRentals(Support support){
        return daoFacadeSupport.getWeeklyRentals(support.getSupportID());
    }

    public int getMonthlyRentals(Support support){
        return daoFacadeSupport.getMonthlyRentals(support.getSupportID());
    }

    public Boolean canRent(){
        return daoFacadeCreditCard.canRent();
    }

    public SubscriptionCard read (SubscriptionCard subscriptionCard){
        return daoFacadeSubscriptionCards.read(subscriptionCard.getCardId());
    }

    public void getHistory(SubscriptionCard subscriptionCard){
        //todo: return ArrayList historique;
        daoFacadeSubscriptionCards.getHistory(subscriptionCard.getCardId());
    }

    public void credit(SubscriptionCard subscriptionCard, float credit){
        daoFacadeSubscriptionCards.credit(credit,subscriptionCard.getCardId());
    }

    public boolean canRent(SubscriptionCard subscriptionCard){
        return daoFacadeSubscriptionCards.canRent(subscriptionCard.getCardId());
    }
}
