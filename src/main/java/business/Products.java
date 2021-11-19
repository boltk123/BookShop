package business;

import database.ProductsDB;
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

    public Products(int user_id, int product_id, int quantity, double shipping, double tax) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.product_name = ProductsDB.getProductName(this.product_id);
        this.subtotal = ProductsDB.getProductSubtotal(this.product_id);
        this.shipping = shipping;
        this.tax = tax;
        this.total = subtotal * quantity;
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


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
