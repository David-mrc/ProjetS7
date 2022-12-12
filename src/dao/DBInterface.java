package dao;

import fc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class DBInterface {

    String url = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    String user = "bultincl";
    String passwd = "e5f05c6c48";

    Connection conn;
    DAOFacadeUser daoFacadeUser;
    DAOFacadeMovie daoFacadeMovie;
    DAOFacadeCreditCard daoFacadeCreditCard;
    DAOFacadeSubscriptionCards daoFacadeSubscriptionCards;
    DAOFacadeSupport daoFacadeSupport;

    public DBInterface() {
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

    public boolean rentMovie(User user, Support support, Cards card){
        try {
            daoFacadeUser.rentMovie(user,support,card);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean requestSubscriberCard(User user){
        try {
            daoFacadeUser.requestSubscriberCard(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
    public ArrayList<Movie> getTopMonthlyRentals(int i){
        return daoFacadeMovie.getTopMonthlyRentals(i);
    }
    public ArrayList<Movie> getTopWeeklyRentals(int i){
        return daoFacadeMovie.getTopWeeklyRentals(i);
    }

    public int getMonthlyRentals(Movie movie){
        return daoFacadeMovie.getMonthlyRentals(movie.getId());
    }

    public Support getAvailableQRCode(Movie m){
        return daoFacadeMovie.getAvailableQRCode(m);
    }
    public Support getAvailableBluRay(Movie m){
        return daoFacadeMovie.getAvailableBluRay(m);
    }


    public boolean isAvailableAsBluRay(Movie m){
        return daoFacadeMovie.isAvailableAsBluRay(m);
    }
    public boolean isAvailableAsQRCode(Movie movie) {
        return daoFacadeMovie.isAvailableAsQRCode(movie);
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

    public ArrayList<Movie> getMovieList(){
        return daoFacadeMovie.getMovieList();
    }

    public ArrayList<Movie> getMovieListQR(){
        return daoFacadeMovie.getMovieListQR();
    }

    public ArrayList<Movie> getMovieListBR(){
        return daoFacadeMovie.getMovieListBR();
    }

    public ArrayList<Movie> getMovieListGrossingMonthly(int i){
        return daoFacadeMovie.getTopMonthlyRentals(i);
    }

    public ArrayList<Movie> getMovieListGrossingWeekly(int i){
        return daoFacadeMovie.getTopWeeklyRentals(i);
    }

    public User logUserIn(int userID){
        return daoFacadeUser.login(userID);
    }

    public boolean createAccount(User user){
        try {
            return daoFacadeUser.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Movie> getHistory(User user){
        return daoFacadeMovie.getHistory(user.getUserID());
    }

    public boolean rentMovie2(User user,Support support, Cards cards){
        try {
            if(cards.getType() == "Subscription"){
                if(!daoFacadeSubscriptionCards.canRent(cards.getID())){
                    return false;
                }
            } else {
                if(!daoFacadeCreditCard.canRent()){
                    return false;
                }
            }
            daoFacadeUser.rentMovie(user, support, cards);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public Support getMovieBR(int movieID){
        return daoFacadeSupport.getIfAvailable(movieID);
    }

    public Support getMovieQR(int movieID){
        return daoFacadeSupport.getQR(movieID);
    }

    public Cards getUserCard(User user){
        Cards c;
        if(user.isSubscriber()){
            c = daoFacadeSubscriptionCards.getSubscriptionCard(user.getUserID());
        } else {
            c = daoFacadeCreditCard.getCreditCard(user.getUserID());
        }

        return c;
    }

    public float getBalance(User user){
        Cards c = getUserCard(user);
        if(Objects.equals(c.getType(), "Subscription")){
            return ((SubscriptionCard) c).getBalance();
        }
        return 0.0F;
    }

    public void topUpCard(User user, float amount){
        Cards c = getUserCard(user);
        if(Objects.equals(c.getType(), "Subscription")){
            float oldBalance = ((SubscriptionCard) c).getBalance();
            ((SubscriptionCard) c).setBalance(oldBalance + amount);
            //db call
            daoFacadeSubscriptionCards.credit(amount, ((SubscriptionCard) c).getID());
        }
    }

    public ArrayList<Actor> getMovieActors(int movieID){
        return daoFacadeMovie.getActorFromMovies(movieID);
    }


    public Support requestMovieAsBluRay(Movie m) {
        return daoFacadeMovie.getAvailableBluRay(m);
    }
}
