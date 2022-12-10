package fc;

import java.sql.Date;
import java.util.ArrayList;

public class Movie {
    private int id;
    private String title;
    private ArrayList<String> actors;
    private String Director;
    private CyberVideoInterface cvinterface;
    private boolean isAvailableAsQRCode = false;
    private boolean isAvailableAsBluRay = false;
    private Date releaseDate;
    private int ageRestriction;
    private String poster;

    public void requestAsBluRay(Movie movie){
        cvinterface.requestMovieAsBluRay(movie);
    }

    //GETTERS
    public boolean getQRCodeAvailability(){return isAvailableAsQRCode;}

    public boolean getBluRayAvailability(){
        return isAvailableAsBluRay;
    }

    public CyberVideoInterface getCyberVideoInterface(){return cvinterface;}

    public String getDirector(){return Director;}

    public ArrayList<String> getActors(){return actors;}

    public String getTitle() {return title;}

    public int getId() {return id;}

    public Date getDate() {return releaseDate;}
    public int getAgeRestriction() {return ageRestriction;}
    public String getPoster(){return poster;}

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

   //SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActors(ArrayList<String> actors) {this.actors = actors;}

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

    public void setPoster(String p){poster = p;}
    public void setAgeRestriction(int a){ageRestriction = a;}
    public void setId(int a){id = a;}


    public void setReleaseDate(Date d){releaseDate = d;}

    public String toString() {
        return "ID : " + id + " TITLE : " + title + " RELEASEDATE : " + releaseDate +
                "AGERESTRICTION :" + ageRestriction + "POSTER :" + poster;
    }


}
