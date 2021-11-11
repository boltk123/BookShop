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
    private Long book_id;
    private Long author_id;

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getBook_id() {
        return book_id;
    }
    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }


}
