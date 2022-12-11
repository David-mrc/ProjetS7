package fc.interfaces;
import IHM.App;
import fc.*;

import java.util.ArrayList;

public class FCInterface {
    App a;
    CyberVideoInterface cvi;
    DBInterface dbi;

    User user;

    ArrayList<Movie> moviesList;
    ArrayList<MovieCategories> movieCategories;


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
