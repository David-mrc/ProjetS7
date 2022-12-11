package fc;

import dao.DAOFacadeUser;
import dao.DAOUser;

import java.sql.Date;
import java.sql.SQLException;

public class User {
    private int userID;
    private String firstname;
    private String lastName;
    private String address;
    private Date birthday;
    private boolean subscriber;
    private DAOFacadeUser dao;

    @Override
    public String toString() {
        return "userID : " + userID + " ; firstname : " + firstname + " ; lastName : " + lastName + " ; address : " + address + " ; birthday : " + birthday + " ; subscriber : " + subscriber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSubscriber() {
        return subscriber;
    }

    public void setSubscriber(boolean subscriber) {
        this.subscriber = subscriber;
    }

    public void rentMovie(Support support,Cards cards){
        try {
            dao.rentMovie(this,support,cards);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void requestSubscriberCard(){
        try {
            dao.requestSubscriberCard(this);
            System.out.println("Asking for a new subscription Card");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
