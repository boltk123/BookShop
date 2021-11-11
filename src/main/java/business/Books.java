package business;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Books implements Serializable {
    @Id
    private int book_id;
    private String title;
    private int total_pages;
    private double rating;

    @Temporal(TemporalType.DATE)
    private Date published_date;
    private int publisher_id;

    @Type(type="org.hibernate.type.BinaryType")
    private byte[] book_cover;

    public Books() {
    }

    public Books(int book_id, String title, int total_pages, double rating, Date published_date, int publisher_id, byte[] book_cover) {
        this.book_id = book_id;
        this.title = title;
        this.total_pages = total_pages;
        this.rating = rating;
        this.published_date = published_date;
        this.publisher_id = publisher_id;
        this.book_cover = book_cover;
    }

    public byte[] getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(byte[] book_cover) {
        this.book_cover = book_cover;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }


}