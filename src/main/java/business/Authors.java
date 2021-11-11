package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Authors implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int author_id;
    private String first_name;
    private String middle_name;
    private String last_name;

    public Authors() {

    }

    public Authors(int author_id, String first_name, String middle_name, String last_name) {
        this.author_id = author_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
