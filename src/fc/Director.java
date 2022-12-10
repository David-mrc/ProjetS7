package fc;
import java.util.ArrayList;

public class Director {

    private String firstName;
    private String lastName;
    private int MovieID;

    @Override
    public String toString() {
        return "Movieid : " + MovieID + " ; firstName : " + firstName + " ; lastName : " + lastName;
    }
    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int movieID) {
        MovieID = movieID;
    }
//GETTERS

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //SETTERS

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}