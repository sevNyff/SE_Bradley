package ch.fhnw.richards.Week_05.Controller;

import ch.fhnw.richards.Week_05.model.Model;
import ch.fhnw.richards.Week_05.view.InvoiceView;

public class InvoiceController {
    private final Model model;
    private final InvoiceView view;

    public InvoiceController(Model model, InvoiceView view) {
        this.model = model;
        this.view = view;
    }
}
