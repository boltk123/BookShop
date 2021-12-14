package business;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book_contents {
    @Id
    private int book_id;

    @Type(type="org.hibernate.type.BinaryType")
    private byte[] book_pdf;

    public Book_contents(int book_id, byte[] book_pdf) {
        this.book_id = book_id;
        this.book_pdf = book_pdf;
    }

    public Book_contents() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public byte[] getBook_pdf() {
        return book_pdf;
    }

    public void setBook_pdf(byte[] book_pdf) {
        this.book_pdf = book_pdf;
    }

}
