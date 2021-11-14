package features;

import exercise.nhanebook.LineItem;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

public class BookCart {

    // List of items
    private ArrayList<LineItem> items;
    private double cart_total;
    public void setTotal(double s) {
        cart_total = s;
    }

    public String getTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.cart_total);
    }
    // constructor
    public BookCart() {
        items = new ArrayList<LineItem>();
    }

    // never used
    public ArrayList<LineItem> getItems() {
        return items;
    }

    // never used
    public int getCount() {
        return items.size();
    }

    // called when press "Add To cart" button in cart_exercise.jsp
    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (LineItem cartItem : items) {
            if (cartItem.getProduct().getCode().equals(code)) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }

    public void setCartTotal() {
        double total = 0;
        for (LineItem item : items) {
            total = total + item.getTotal();
        }
        this.cart_total = total;
    }
}
}
