package ch.fhnw.richards.Week_05;

import ch.fhnw.richards.Week_05.Controller.InvoiceController;
import ch.fhnw.richards.Week_05.model.Database;
import ch.fhnw.richards.Week_05.model.Model;
import ch.fhnw.richards.Week_05.view.InvoiceView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A small application showing DIY Object-relational mapping
 */
public class InvoiceExample extends Application {
    private Model model;
    private InvoiceView view;
    private InvoiceController controller;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.model = new Model();
        this.view = new InvoiceView(model, stage);
        this.controller = new InvoiceController(model, view);

        view.start();
    }


    @Override
    public void stop() {
        model.stop();
    }
}
