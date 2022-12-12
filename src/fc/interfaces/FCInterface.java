package fc.interfaces;
import fc.*;

import java.util.ArrayList;

public class FCInterface {

    DBInterface dbi;
    User user;

    public FCInterface(CyberVideoInterface cvi, DBInterface dbi){
        this.dbi = dbi;
    }


    //TODO: implement methods
    public ArrayList<Movie> getAvailableMovies(){
        return dbi.getMovieList();
    }

    public ArrayList<Movie> getMoviesAvailableAsBluRay() {
        return dbi.getMovieListBR();
    }

    public ArrayList<Movie> getMoviesAvailableAsQRCode(){
        return dbi.getMovieListQR();
    }

    public void  searchUnavailableMovie(String s){ // c quoi

    }
    public void  getWeeklyTopRentals(Integer i){

    }
    public void  getMonthlyTopRentals(Integer i){

    }
    public void  rentAsBluRay(Movie m){

    }
    public void  rentAsQRCode(Movie m){

    }
    public void  requestMovieAsBluRay(Movie m){

    }
    public void  topUpCard(){

    }
    public ArrayList<Movie> getHistory(){
        return dbi.getHistory(this.user);
    }
    public void getBalance() {

    }
    public void login(int id){
        this.user = dbi.logUserIn(id);
    }
    public void  logout(){
        this.user = null;
    }
    public boolean createAccount(String firstName, String lastName, String address){
        User newUser = new User(this.dbi);
        newUser.setUserID(10);  // a changer //// important
        newUser.setFirstname(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setSubscriber(false);

        if(dbi.createAccount(newUser)){
            this.user = newUser;
            return true;
        } else {
            return false;
        }
    }

    public boolean requestSubscriberCard(){
        if(this.user == null){
            throw new RuntimeException("No user logged in error");
        }
        return this.user.requestSubscriberCard();
    }

}
