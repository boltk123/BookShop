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
    private int book_id;
    private int genre_id;

    public Book_genres() {
    }

    public Book_genres(int book_id, int genre_id) {
        this.book_id = book_id;
        this.genre_id = genre_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
}
