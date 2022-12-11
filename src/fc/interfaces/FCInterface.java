package fc.interfaces;
import IHM.App;
import fc.*;

import java.util.ArrayList;

public class FCInterface {
    App a;
    CyberVideoInterface cvi;
    DBInterface dbi;
    User user;

    public FCInterface(App a, CyberVideoInterface cvi, DBInterface dbi){
        this.a = a;
        this.cvi = cvi;
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
    public void  login(String firstName, String lastName){
        this.user = dbi.logUserIn(firstName, lastName);
    }
    public void  logout(){
        this.user = null;
    }
    public boolean createAccount(String firstName, String lastName, String address){
        User newUser = new User();
        newUser.setUserID(10);  // a changer //// important
        newUser.setFirstname(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setSubscriber(false);

        if(dbi.createAccount(newUser)){
            return true;
        } else {
            return false;
        }
    }

}
