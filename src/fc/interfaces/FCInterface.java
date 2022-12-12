package fc.interfaces;

import fc.*;

import java.util.ArrayList;

public class FCInterface {

    DBInterface dbi;
    User user;

    public FCInterface(CyberVideoInterface cvi, DBInterface dbi) {
        this.dbi = dbi;
    }


    public ArrayList<Movie> getAvailableMovies() {
        return dbi.getMovieList();
    }

    public ArrayList<Movie> getMoviesAvailableAsBluRay() {
        return dbi.getMovieListBR();
    }

    public ArrayList<Movie> getMoviesAvailableAsQRCode() {
        return dbi.getMovieListQR();
    }

    public ArrayList<Movie> getWeeklyTopRentals(int i) {
        return dbi.getMovieListGrossingWeekly(i);
    }

    public ArrayList<Movie> getMonthlyTopRentals(int i) {
        return dbi.getMovieListGrossingMonthly(i);
    }

    public void requestMovieAsBluRay(Movie m) {
        this.user.requestMovieAsBluRay(m);
    }

    public void topUpCard(float amount) {
        dbi.topUpCard(this.user, amount);
    }

    public ArrayList<Movie> getHistory() {
        return dbi.getHistory(this.user);
    }

    public float getBalance() {
        return dbi.getBalance(this.user);
    }

    public boolean login(int id) {
        user = dbi.logUserIn(id);
        return user != null;
    }

    public void logout() {
        this.user = null;
    }

    public boolean createAccount(int id, String firstName, String lastName, String address) {
        User newUser = new User(dbi);
        newUser.setUserID(id);
        newUser.setFirstname(firstName);
        newUser.setLastName(lastName);
        newUser.setAddress(address);
        newUser.setSubscriber(false);

        if (dbi.createAccount(newUser)) {
            this.user = newUser;
            return true;
        } else {
            return false;
        }
    }

    public boolean requestSubscriberCard() {
        if (this.user == null) {
            throw new RuntimeException("No user logged in error");
        }
        return this.user.requestSubscriberCard();
    }

    public boolean rentMovieQR(int movieID) {
        if (this.user == null) {
            throw new RuntimeException("No user logged in error");
        }
        Support s = dbi.getMovieQR(movieID);
        Cards c = dbi.getUserCard(this.user);

        if (c == null || s == null) {
            return false;
        }
        return this.user.rentMovieQR(s, c);

    }

    public boolean rentMovieBR(int movieID) {
        if (this.user == null) {
            throw new RuntimeException("No user logged in error");
        }
        Support s = dbi.getMovieBR(movieID);
        Cards c = dbi.getUserCard(this.user);

        if (c == null || s == null) {
            return false;
        }
        return this.user.rentMovieBR(s, c);

    }

    public ArrayList<Actor> getMovieActors(Movie m){
        return dbi.getMovieActors(m.getId());
    }

}
