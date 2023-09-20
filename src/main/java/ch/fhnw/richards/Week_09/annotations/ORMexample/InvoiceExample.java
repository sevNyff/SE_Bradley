package ch.fhnw.richards.Week_09.annotations.ORMexample;

import ch.fhnw.richards.Week_09.annotations.ORMexample.controller.Controller;
import ch.fhnw.richards.Week_09.annotations.ORMexample.model.Model;
import ch.fhnw.richards.Week_09.annotations.ORMexample.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A small application showing DIY Object-relational mapping
 */
public class InvoiceExample extends Application {
    private Model model;
    private View view;
    private Controller controller;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.model = new Model();
        this.view = new View(model, stage);
        this.controller = new Controller(model, view);

        view.start();
    }


    @Override
    public void stop() {
        model.stop();
    }
}
