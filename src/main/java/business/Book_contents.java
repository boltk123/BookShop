package business;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book_contents implements Serializable {

    public Book_contents(Long book_id){
        this.book_id = book_id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long book_id;

    @Type(type="org.hibernate.type.BinaryType")
    private byte[] book_cover;

    public Book_contents() {

    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public byte[] getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(byte[] book_cover) {
        this.book_cover = book_cover;
    }


}