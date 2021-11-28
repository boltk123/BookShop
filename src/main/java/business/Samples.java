package business;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Base64;

@Entity
public class Samples implements Serializable {

    @Id
    private int book_id;
    @Id
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] sample;
    private String base64Sample;

    public Samples(int book_id, byte[] sample) {
        this.book_id = book_id;
        this.sample = sample;
    }
    // default constructor
    public Samples() {

    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public byte[] getSample() {
        return sample;
    }

    public void setSample(byte[] sample) {
        this.sample = sample;
    }

    @Transient
    public String getBase64Sample() {
        base64Sample = Base64.getEncoder().encodeToString(this.sample);
        return base64Sample;
    }

    public void setBase64Image(String base64Image) {
        this.base64Sample = base64Image;
    }

}

