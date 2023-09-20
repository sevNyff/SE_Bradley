package ch.fhnw.richards.Week_09.annotations.ORMexample.model;

import ch.fhnw.richards.Week_09.annotations.ORM.Column;
import ch.fhnw.richards.Week_09.annotations.ORM.Entity;
import ch.fhnw.richards.Week_09.annotations.ORM.ID;
import ch.fhnw.richards.Week_09.annotations.ORM.Table;

@Entity
@Table(name="LineItem")
public class LineItem {
    @ID
    @Column(name="invoiceID")
    private final Integer invoiceID;
    @Column(name="productID")
    private final Integer productID;
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="salesPrice")
    private Integer salesPrice;

    public LineItem(Integer invoiceID, Integer productID) {
        this.invoiceID = invoiceID;
        this.productID = productID;
    }

    public LineItem(Integer invoiceID, Integer productID, Integer quantity, Integer salesPrice) {
        this(invoiceID, productID);
        this.quantity = quantity;
        this.salesPrice = salesPrice;
    }

    public Integer getInvoiceID() {
        return invoiceID;
    }

    public Integer getProductID() {
        return productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Integer salesPrice) {
        this.salesPrice = salesPrice;
    }
}
