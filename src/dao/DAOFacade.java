package dao;

import fc.Actor;
import fc.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOFacade {

    protected Connection conn;

    protected DAOFacade(Connection conn) {
        this.conn = conn;
    }
    public Movie readMovie (int id){
        DAOMovie daoMovie =  new DAOMovie(conn);
        Movie m = null;
        try {
            m = daoMovie.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public ArrayList<Actor> getActorFromMovies(int movieID){
        ArrayList<Actor> actors = new ArrayList<>();

        try {
            PreparedStatement actorsPlaying = conn.prepareStatement("SELECT FIRSTNAME,LASTNAME FROM ACTORSMOVIES WHERE MovieID = ?");
            actorsPlaying.setInt(1, movieID);
            ResultSet MovieResult = actorsPlaying.executeQuery();


            if (MovieResult.next()) {
                Actor actor = new Actor();
                actor.setFirstName(MovieResult.getString(1));
                actor.setLastName(MovieResult.getString(2));
                actors.add(actor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

}
