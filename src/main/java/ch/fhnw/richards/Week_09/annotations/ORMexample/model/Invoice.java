package ch.fhnw.richards.Week_09.annotations.ORMexample.model;

import ch.fhnw.richards.Week_09.annotations.ORM.Column;
import ch.fhnw.richards.Week_09.annotations.ORM.Entity;
import ch.fhnw.richards.Week_09.annotations.ORM.ID;
import ch.fhnw.richards.Week_09.annotations.ORM.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Invoice")
public class Invoice {
    @ch.fhnw.richards.Week_09.annotations.ORM.ID
    @Column(name="ID")
    private final Integer ID;
    @Column(name="date")
    private LocalDate date;
    @Column(name="customerID")
    private Integer customerID;
    private List<LineItem> lineItems = new ArrayList<>();
    private Integer total;

    public Invoice(Integer ID) {
        this.ID = ID;
    }

    public Invoice(Integer ID, LocalDate date, Integer customerID) {
        this(ID);
        this.date = date;
        this.customerID = customerID;
    }


    public void addLineItem(Integer productID, Integer quantity, Integer salesPrice) {
        lineItems.add(new LineItem(this.ID, productID, quantity, salesPrice));
        updateTotal();
    }

    public void addLineItemFromProduct(Product product, Integer quantity) {
        lineItems.add(new LineItem(this.ID, product.getID(), quantity, product.getPrice()));
        updateTotal();
    }

    public void removeLineItem(LineItem li) {
        lineItems.removeIf(lineItem -> lineItem.equals(li));
        updateTotal();
    }

    private void updateTotal() {
        int total = 0;
        for (LineItem li : lineItems) {
            int subtotal = li.getQuantity() * li.getSalesPrice();
            total += subtotal;
        }
        this.total = total;
    }

    public ArrayList<LineItem> getLineItems() {
        return new ArrayList<>(lineItems); // Copy, so no one else can change our list
    }

    public Integer getID() {
        return ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getTotal() {
        return total;
    }
}


