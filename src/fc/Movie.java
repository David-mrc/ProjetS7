package fc;

import dao.DAOFacade;
import dao.DAOMovie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Movie {
    private int id;
    private String title;
    private String  directorFirstname;
    private String  directorLastname;
    private ArrayList<Actor> actors;
    public Movie(){}
    public Movie(int id, DAOFacade dao) throws SQLException {
        Movie m = dao.readMovie(id);
        this.id = id;
        this.title = m.getTitle();
        this.directorLastname = m.getDirectorLastname();
        this.directorFirstname = m.getDirectorFirstname();
        actors = dao.getActorFromMovies(id);
    }

    public String getDirectorFirstname(){return directorFirstname;}
    public String getDirectorLastname(){return directorLastname;}


    public String getTitle() {return title;}

    public int getId() {return id;}

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

    public void setDirectorLastname(String directorLn) {
        directorLastname = directorLn;
    }
    public void setDirectorFirstname(String directorFn) {
        directorFirstname = directorFn;
    }
    public void setId(int a){id = a;}

    public String toString() {
        return "ID : " + id + " TITLE : " + title + "DIRECTORS : "+ ;
    }


}
