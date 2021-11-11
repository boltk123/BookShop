package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book_authors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    private int author_id;

    public Book_authors() {
    }

    public Book_authors(int book_id, int author_id) {
        this.book_id = book_id;
        this.author_id = author_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }
    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }


}
