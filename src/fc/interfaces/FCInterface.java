package fc.interfaces;
import fc.*;

import java.util.ArrayList;

public class FCInterface {
    CyberVideoInterface cvi;
    DBInterface dbi;

    public FCInterface(CyberVideoInterface cvi, DBInterface dbi){
        this.cvi = cvi;
        this.dbi = dbi;
    }


    //TODO: implement methods
    public void getAvailableMovies(){

    }
    public ArrayList<String> getMoviesAvailableAsBluRay() {
        return new ArrayList<String>();
    }
    public void getMoviesAvailableAsQRCode(){

    }
    public void  searchUnavailableMovie(String s){

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
    public void  getHistory(){

    }
    public void  getBalance() {

    }
    public void  login(){

    }
    public void  logout(){

    }
    public void  createAccount(){

    }

}
