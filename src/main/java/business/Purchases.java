package business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Purchases implements Serializable {

    @Id
    private int user_id;
    @Id
    private int product_id;
    private boolean purchased;
    @Temporal(TemporalType.DATE)
    private Date purchase_date;
    public Purchases() {
    }

    public Purchases(int user_id, int product_id) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.purchased = true;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    private java.sql.Date parseDate(String date) {
        try {
            return new Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
