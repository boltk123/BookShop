package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genre_id;
    private String genre;
    private Long parent_id;

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }




}
