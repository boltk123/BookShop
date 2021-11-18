package business;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Products implements Serializable {

    @Id
    private int user_id;
    @Id
    private int product_id;
    private int quantity;
    private String product_name;
    private double subtotal;
    private double shipping;
    private double tax;
    private double total;
    public Products() {
    }

    public Products(int user_id, int product_id, int quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSubtotal() {
        return String.format("%.2f", subtotal * this.quantity);
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String productName) {
        this.product_name = productName;
    }

}
