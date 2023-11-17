package ch.fhnw.richards.Week_11.translator;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View {
    Stage stage;
    Model model;

    // Current translator to use; default to US English
    Translator t = new Translator("en-US");

    // UI components
    MenuBar menus = new MenuBar();
    Menu menuLanguage = new Menu();
    MenuItem menuLanguageEN = new MenuItem();
    MenuItem menuLanguageDE = new MenuItem();

    Label lblText = new Label();

    public View(Stage stage, Model model) {
        this.stage = stage;
        this.model = model;

        menus.getMenus().add(menuLanguage);
        menuLanguage.getItems().addAll(menuLanguageEN, menuLanguageDE);

        BorderPane root = new BorderPane();
        root.setTop(menus);
        root.setCenter(lblText);

        updateTexts();

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
    }

    public void start() {
        stage.show();
    }

    /**
     * Update all texts shown in the view
     */
    protected void updateTexts() {
        // The menu entries
        menuLanguage.setText(t.getString("program.menu.language"));
        menuLanguageEN.setText(t.getString("program.menu.language.english"));
        menuLanguageDE.setText(t.getString("program.menu.language.german"));

        // Other controls
        lblText.setText(t.getString("label.text"));

        // Window title
        stage.setTitle(t.getString("program.name"));
    }
}
