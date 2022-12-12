package fc.interfaces;
import dao.*;
import fc.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DBInterface {

    String url ="jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    String user="bultincl";
    String passwd="e5f05c6c48";

    CyberVideoInterface cvi;
    Connection conn;

    DAOFacadeSupport facadeSupport;
    DAOFacadeMovie facadeMovie;
    DAOFacadeUser facadeUser;
    DAOFacadeSubscriptionCards facadeSC;
    DAOFacadeCreditCard facadeCC;




        public DBInterface() {
            try {
                conn = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            facadeMovie = new DAOFacadeMovie(conn);
            facadeSupport = new DAOFacadeSupport(conn);
            facadeUser = new DAOFacadeUser(conn);
            facadeSC = new DAOFacadeSubscriptionCards(conn);
            facadeCC = new DAOFacadeCreditCard(conn);

            this.cvi = new CyberVideoInterface();
        }

        public ArrayList<Movie> getMovieList(){
            return facadeMovie.getMovieList();
        }

        public ArrayList<Movie> getMovieListQR(){
            return facadeMovie.getMovieListQR();
        }

        public ArrayList<Movie> getMovieListBR(){
            return facadeMovie.getMovieListBR();
        }

        public ArrayList<Movie> getMovieListGrossingMonthly(){
            return facadeMovie.getTopMonthlyRentals(5);
        }

        public ArrayList<Movie> getMovieListGrossingWeekly(){
            return facadeMovie.getTopWeeklyRentals(5);
        }

        public User logUserIn(int userID){
            return facadeUser.login(userID);
        }

        public boolean createAccount(User user){
            try {
                return facadeUser.create(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public ArrayList<Movie> getHistory(User user){
            return facadeMovie.getHistory(user.getUserID());
        }

        public boolean rentMovie(User user,Support support, Cards cards){
            try {
                if(cards.getType() == "Subscription"){
                     if(!facadeSC.canRent(cards.getID())){
                         return false;
                     }
                } else {
                    if(!facadeCC.canRent()){
                        return false;
                    }
                }
                facadeUser.rentMovie(user, support, cards);
            } catch(SQLException e) {
                e.printStackTrace();
            }
            return true;
        }

        public boolean requestSubscriberCard(User user){
            return cvi.requestSubscriberCard(user);
        }

        public void requestMovieAsBluRay(Movie m){
            cvi.requestMovieAsBluRay(m);
        }

        public Support getMovieBR(int movieID){
            return facadeSupport.getIfAvailable(movieID);
        }

        public Support getMovieQR(int movieID){
            return facadeSupport.getQR(movieID);
        }

        public Cards getUserCard(User user){
            Cards c;
            if(user.isSubscriber()){
                 c = facadeSC.getSubscriptionCard(user.getUserID());
            } else {
                 c = facadeCC.getCreditCard(user.getUserID());
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
                facadeSC.credit(amount, ((SubscriptionCard) c).getID());
            }
        }

        public ArrayList<Actor> getMovieActors(int movieID){
            return facadeMovie.getActorFromMovies(movieID);
        }

}

