package business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Books implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    private String title;
    private int total_pages;
    private Long rating;
    @Temporal(TemporalType.DATE)
    private Date published_date;
    private Long publisher_id;

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getBook_id() {
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

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public Long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }


}