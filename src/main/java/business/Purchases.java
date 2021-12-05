package business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Purchases implements Serializable {

    @Id
    private int user_id;
    @Id
    private int product_id;
    private boolean purchased;
    private int quantity;
    private LocalDate purchase_date;
    public Purchases() {
    }

    public Purchases(int user_id, int product_id, int quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.purchased = true;
        this.purchase_date = LocalDate.now();
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


}
