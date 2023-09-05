package ch.fhnw.richards.Week_05.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Invoice {
    private Integer ID;
    private LocalDate date;
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

    /**
     * Create an invoice from a row in a ResultSet
     */
    public Invoice(ResultSet rs) throws SQLException {
        this.ID = rs.getInt("ID");
        this.date = rs.getDate("date").toLocalDate();
        this.customerID = rs.getInt("customerID");
    }

    /**
     * Method to get all invoices from the database
     */
    public static List<Invoice> getInvoices(Database db) {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM Invoice ORDER BY ID";
        try (
                PreparedStatement stmt = db.getConnection().prepareStatement(query, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                Invoice invoice = new Invoice(rs);
                invoice.lineItems = LineItem.getLineItems(db, invoice.ID);
                invoices.add(new Invoice(rs));
            }

        } catch (SQLException e) {
            System.out.println("Exception " + e.toString());
        }
        return invoices;
    }

    public void addLineItem(Integer productID, Integer quantity, Integer salesPrice) {
        lineItems.add(new LineItem(this.ID, productID, quantity, salesPrice));
    }

    public void addLineItemFromProduct(Product product, Integer quantity) {
        lineItems.add(new LineItem(this.ID, product.getID(), quantity, product.getPrice()));
    }

    public void removeLineItem(LineItem li) {
        Iterator<LineItem> i = lineItems.iterator();
        while (i.hasNext()) {
            if (i.next().equals(li)) i.remove();
        }
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


