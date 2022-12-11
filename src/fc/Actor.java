package fc;
import java.util.ArrayList;

public class Actor {

    private int movieId;
    private String firstName;
    private String lastName;

    //GETTERS


    @Override
    public String toString() {
        return "id : " + movieId + " ; firstName : " + firstName + " ; lastName : " + lastName;
    }

    public int getId() {
        return movieId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //SETTERS


    public void setMovieID(int id) {
        this.movieId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
