package fc;

import dao.DAOFacadeMovie;

import java.sql.SQLException;
import java.util.ArrayList;

public class Movie {
    private int id;
    private String title;
    private String  directorFirstname;
    private String  directorLastname;
    private ArrayList<Actor> actors;
    private DAOFacadeMovie dao;
    public Movie(){}
    public Movie(int id, DAOFacadeMovie dao) throws SQLException {
        this.dao = dao;
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
        return dao.getWeeklyRentals(id);
    }

    public int getMonthlyRentals(){
        return dao.getMonthlyRentals(id);
        // Calcul via request DAO.
    }

    public Support getAvailableBluRay(){
        return dao.getAvailableBluRay(this);
    }

    public Support getAvailableQRCode(){
        return dao.getAvailableQRCode(this);
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
        return "ID : " + id + " TITLE : " + title + "DIRECTORS : " + directorFirstname + " " +directorLastname;
    }


}
