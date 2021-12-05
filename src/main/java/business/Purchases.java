package business;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Purchases implements Serializable {

    @Id
    private int user_id;
    @Id
    private int product_id;
    private boolean purchased;

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

}
