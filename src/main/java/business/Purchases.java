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
    private boolean delivered;
    private int quantity;
    private float total;
    private LocalDate purchase_date;
    private LocalDate delivery_date;
    public Purchases() {
    }

    public Purchases(int user_id, int product_id, int quantity, float total) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.purchased = true;
        this.total = total;
        this.purchase_date = LocalDate.now();
        this.delivery_date = purchase_date.plusDays(7);
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
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }
    public boolean isDelivered() {
        if(LocalDate.now().equals(delivery_date) ){
            delivered = true;
        }
        else {
            delivered = false;
        }
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

}
