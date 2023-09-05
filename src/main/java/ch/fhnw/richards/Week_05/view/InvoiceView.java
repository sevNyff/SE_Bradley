package ch.fhnw.richards.Week_05.view;

import ch.fhnw.richards.Week_05.model.Model;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InvoiceView {
    private final Model model;
    private final Stage stage;

    public InvoiceView(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;

        BorderPane root = new BorderPane();
    //    root.setTop(new TopBar(model));
      //  root.setBottom(new BottomBar(model));

        root.setCenter(new Label("Database example"));
        Scene scene = new Scene(root);
        stage.setTitle("Database example");
        stage.setScene(scene);
    }

    public void start() {
        stage.show();
    }
}
