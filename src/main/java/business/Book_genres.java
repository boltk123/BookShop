package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book_genres implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    private Long genre_id;

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }
}
