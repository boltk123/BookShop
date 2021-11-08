package exercise.nhanebook;
import java.io.Serializable;

public class User_JDBC implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String heardFrom;
    private String wantsUpdates;
    private String contactVia;

    public User_JDBC() {
        firstName = "";
        lastName = "";
        email = "";
    }

    public User_JDBC(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getHeardFrom() {
        return heardFrom;
    }
    public String getWantsUpdates() {
        return wantsUpdates;
    }
    public String getContactVia() {
        return contactVia;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }
    public void setWantsUpdates(String wantsUpdates) {
        this.wantsUpdates = wantsUpdates;
    }
    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    }
}
