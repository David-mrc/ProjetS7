package fc.interfaces;

import fc.Movie;
import fc.User;

public class CyberVideoInterface {

    public void requestMovieAsBluRay(Movie mov ){
        System.out.println("fc.BluRay request send for : " + mov.getTitle());
    }

    public boolean requestSubscriberCard(User user){
        System.out.println("request for a subscriber card has been sent, mailing address: " + user.getFirstname() +
                user.getLastName() + user.getAddress());
        return true;
    }
}
