package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int genre_id;
    private String genre;
    private int parent_id;

    public Genres(int genre_id, String genre, int parent_id) {
        this.genre_id = genre_id;
        this.genre = genre;
        this.parent_id = parent_id;
    }

    public Genres() {
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }




}
