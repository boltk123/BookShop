package business;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

@Entity
public class Books implements Serializable {
    @Id
    private int book_id;
    private String title;
    private int total_pages;
    private double rating;
    private double cost;
    private String author;
    private String genre;
    private String description;
    private String base64Image;
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] book_cover;
    //default constructor
    public Books() {
    }

    public Books(int book_id, String title, int total_pages, double rating, double cost, String author, String genre,String description, byte[] book_cover) {
        this.book_id = book_id;
        this.title = title;
        this.total_pages = total_pages;
        this.rating = rating;
        this.cost = cost;
        this.author = author;
        this.genre = genre;
        this.description = description;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authors) {
        this.author = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Transient
    public String getBase64Image() {
        base64Image = Base64.getEncoder().encodeToString(this.book_cover);
        return base64Image;
    }
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}