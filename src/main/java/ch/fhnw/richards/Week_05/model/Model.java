package ch.fhnw.richards.Week_05.model;

import java.sql.ResultSet;
import java.util.List;

/**
 * The model maintains the list of products, information on one customer and that customers invoice-IDs,
 * and the detailed information on one invoice (including all line items).
 */
public class Model {
    private Database db = new Database();
    private ResultSet rs; // Used to hold query results
    private List<Product> products;
    private List<Customer> customers;
    private List<Invoice> invoices;

    public Model() {
        db.createDatabase(); // Always recreate fresh data
        products = Product.getProducts(db);
        customers = Customer.getCustomers(db);
        invoices = Invoice.getInvoices(db);
    }

    public void stop() {
        db.closeConnection();
    }
}
