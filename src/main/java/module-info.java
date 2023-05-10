module ch.fhnw.richards {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.fhnw.richards.demo to javafx.fxml;
    exports ch.fhnw.richards.demo;
    exports ch.fhnw.richards.Week_01;
}