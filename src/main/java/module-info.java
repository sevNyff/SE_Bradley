module ch.fhnw.richards {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.fhnw.richards.demo to javafx.fxml;
    exports ch.fhnw.richards.demo;
    exports ch.fhnw.richards.Week_01;
    exports ch.fhnw.richards.Week_02.Lambdas.countrySort_v1;
    exports ch.fhnw.richards.Week_02.Lambdas;
    exports ch.fhnw.richards.Week_02.Streams.loginRecord_example;
    exports ch.fhnw.richards.Week_02.Streams.transaction_exercise;
}