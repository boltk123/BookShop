package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Authors implements Serializable {
    @Id
    private int author_id;
    private String name;
    private String description;


    public Authors() {

    }

    public Authors(int author_id, String name, String description) {
        this.author_id = author_id;
        this.name = name;
        this.description = description;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
