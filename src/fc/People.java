package fc;

public class People {

    private int id;
    private String firstName;
    private String lastName;


    @Override
    public String toString() {
        return "id : " + id + " ; firstName : " + firstName + " ; lastName : " + lastName;
    }
    //GETTERS
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
