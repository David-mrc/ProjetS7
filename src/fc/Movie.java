package fc;
import java.util.ArrayList;

public class Movie {
    int id;
    String title;
    ArrayList<String> actors;
    String Director;
    CyberVideoInterface cvinterface;
    boolean isAvailableAsQRCode = false;
    boolean isAvailableAsBluRay = false;

    public boolean isAvailableAsQRCode(){
        return isAvailableAsQRCode;
    }

    public boolean isAvailableAsBluRay(){
        return isAvailableAsBluRay;
    }

    public int getWeeklyRentals(){
        return 0;
        // Calcul via request DAO.
    }

    public int getMonthlyRentals(){
        return 0;
        // Calcul via request DAO.
    }

    public BluRay getAvailableBluRay(){
        return new BluRay();
    }

    public QRCode getAvailableQRCode(){
        return new QRCode();
    }

    public void requestAsBluRay(Movie movie){
        cvinterface.requestMovieAsBluRay(movie);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setCvinterface(CyberVideoInterface cvinterface) {
        this.cvinterface = cvinterface;
    }

    public void setAvailableAsQRCode(boolean availableAsQRCode) {
        isAvailableAsQRCode = availableAsQRCode;
    }

    public void setAvailableAsBluRay(boolean availableAsBluRay) {
        isAvailableAsBluRay = availableAsBluRay;
    }

    public void addActor(String actor){
        actors.add(actor);
    }
}
