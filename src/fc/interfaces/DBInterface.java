package fc.interfaces;
import dao.*;
import fc.*;

import java.sql.*;
import java.util.ArrayList;

public class DBInterface {

    String url ="jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    String user="bultincl";
    String passwd="e5f05c6c48";

    Connection conn;

    DAOFacadeSupport facadeSupport;
    DAOFacadeMovie facadeMovie;
    DAOFacadeUser facadeUser;



        public DBInterface() {
            try {
                conn = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            facadeMovie = new DAOFacadeMovie(conn);
            facadeSupport = new DAOFacadeSupport(conn);
            facadeUser = new DAOFacadeUser(conn);
        }

        public ArrayList<Movie> getMovieList(){
            return facadeMovie.getMovieList();
        }

        public ArrayList<Movie> getMovieListQR(){
            return facadeMovie.getMovieListQR();
        }

        public ArrayList<Movie> getMovieListBR(){
            return facadeMovie.getMovieListBR();
        }

        public User logUserIn(int userID){
            return facadeUser.login(userID);
        }

        public boolean createAccount(User user){
            try {
                return facadeUser.create(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public ArrayList<Movie> getHistory(User user){
            return facadeMovie.getHistory(user.getUserID());
        }


}

